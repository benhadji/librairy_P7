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
                System.out.println("La date d'envoi est null, l'email vient de partir !!!!!!");
                reservation.setSendMailDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
                getManagerFactory().getReservationManager().updateReservation(reservation);
                mail.sendMail(to, subject, body1);
            }
            else{
                sendMailDate = reservation.getSendMailDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
                if(DAYS.between(sendMailDate, currentDate) >= 2){
                    getManagerFactory().getReservationManager().deleteReservation(reservation);
                    System.out.println("La resa a ete correctement supprimé");

                    List<Reservation> listResaByBook = getManagerFactory().getReservationManager().listResaByBook(reservation.getBook());

                    if(!listResaByBook.isEmpty()){
                        System.out.println("La liste n'est pas vide");

                        for (Reservation nextResa : listResaByBook){
                            nextResa.setPosition(nextResa.getPosition()-1);
                            getManagerFactory().getReservationManager().updateReservation(nextResa);
                            System.out.println("La position du livre suivant dans la liste d'attente a bien ete mise a jour");


                            Book nextResaBook = getManagerFactory().getBookManager().getBook(nextResa.getISBN());
                            nextResa.setBook(nextResaBook);
                            String body2 = "Body2. Bonjour,\n\nLa reservation du livre " + nextResaBook.getTitle() + " que vous avez faites " +
                                    "est a present disponible.\nMerci de venir le chercher sous 48h, sinon, votre reservation sera annulé. Fais vite !" +
                                    "\n\nA bientot !!";


                            nextResa.setSendMailDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
                            getManagerFactory().getReservationManager().updateReservation(nextResa);
                            mail.sendMail(nextResa.getEmail(), subject, body2);
                            System.out.println("Un mail vient d'etre envoyé a l'utilisateur suivant dans la liste d'attente");


                        }
                    }
                    else{
                        System.out.println("La liste est vide !!");
                    }
                }
                else{
                    System.out.println("L'envoi de notif est inferieur a 48h, pour l'instant ne rien faire");
                }
            }

        }

        return RepeatStatus.FINISHED;
    }

}
