package org.WebService.batch;


import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.webservice.service.services.Book;
import org.webservice.service.services.Reservation;
import javax.xml.datatype.DatatypeFactory;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;



public class ReservationTasklet extends AbstractManager implements Tasklet {


    @Autowired
    private EnvoiMessage mail;
    private GregorianCalendar calendar = new GregorianCalendar();
    private LocalDate currentDate = LocalDate.now();
    private LocalDate sendMailDate;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        List<Reservation> resaJob = getManagerFactory().getReservationManager().getResaJobTicket1();


        for (Reservation reservation : resaJob){
            String to = reservation.getEmail();

            String subject = "Bonne nouvelle ! Le livre que vous avez reservé est disponible.";

            Book bookMail = getManagerFactory().getBookManager().getBook(reservation.getISBN());
            reservation.setBook(bookMail);
            String body1 = "Body1. Bonjour,\n\nLa reservation du livre " + bookMail.getTitle() + " que vous avez faites " +
                    "est a present disponible.\nMerci de venir le chercher sous 48h, sinon, votre reservation sera annulé. Fais vite !" +
                    "\n\nA bientot !!";


            if(reservation.getSendMailDate() == null){
                reservation.setSendMailDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
                getManagerFactory().getReservationManager().updateReservation(reservation);
                mail.sendMail(to, subject, body1);
            }
            else{
                sendMailDate = reservation.getSendMailDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
                if(DAYS.between(sendMailDate, currentDate) >= 2){
                    getManagerFactory().getReservationManager().deleteReservation(reservation);

                    List<Reservation> listResaByBook = getManagerFactory().getReservationManager().listResaByBook(reservation.getBook());

                    if(!listResaByBook.isEmpty()){

                        for (Reservation nextResa : listResaByBook){
                            nextResa.setPosition(nextResa.getPosition()-1);
                            getManagerFactory().getReservationManager().updateReservation(nextResa);

                            Book nextResaBook = getManagerFactory().getBookManager().getBook(nextResa.getISBN());
                            nextResa.setBook(nextResaBook);
                            String body2 = "Body2. Bonjour,\n\nLa reservation du livre " + nextResaBook.getTitle() + " que vous avez faites " +
                                    "est a present disponible.\nMerci de venir le chercher sous 48h, sinon, votre reservation sera annulé. Fais vite !" +
                                    "\n\nA bientot !!";


                            nextResa.setSendMailDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
                            getManagerFactory().getReservationManager().updateReservation(nextResa);
                            mail.sendMail(nextResa.getEmail(), subject, body2);

                        }
                    }
                }
            }

        }

        return RepeatStatus.FINISHED;
    }

}
