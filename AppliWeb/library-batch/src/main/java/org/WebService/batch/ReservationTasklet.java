package org.WebService.batch;


import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.webservice.service.services.Book;
import org.webservice.service.services.Reservation;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;


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
            String body = "Bonjour, la reservation du livre " + bookMail.getTitle() + " que vous avez faites " +
                    "est a present disponible. Merci de venir le chercher sous 48h, sinon, votre reservation sera annulé. Fais vite !" +
                    "A bientot !!";


            if(reservation.getSendMailDate() == null){
                reservation.setSendMailDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
                getManagerFactory().getReservationManager().updateReservation(reservation);
                mail.sendMail(to, subject, body);
            }
            else{
                sendMailDate = reservation.getSendMailDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
                if(DAYS.between(sendMailDate, currentDate) == 2){
                    getManagerFactory().getReservationManager().deleteReservation(reservation);

                    List<Reservation> listResaByBook = getManagerFactory().getReservationManager().listResaByBook(reservation.getBook());

                    for (Reservation resaByBook : listResaByBook){
                        resaByBook.setPosition(resaByBook.getPosition()-1);
                    }

                    Reservation nextResa = listResaByBook.get(0);
                    nextResa.setSendMailDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
                    getManagerFactory().getReservationManager().updateReservation(nextResa);
                    mail.sendMail(to, subject, body);

                }
            }



        }

        return RepeatStatus.FINISHED;
    }

}
