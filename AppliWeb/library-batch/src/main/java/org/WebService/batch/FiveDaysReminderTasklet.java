package org.WebService.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.webservice.service.services.Book;
import org.webservice.service.services.Borrow;
import org.webservice.service.services.UserAccount;

import java.util.List;

public class FiveDaysReminderTasklet extends AbstractManager implements Tasklet {


    @Autowired
    private EnvoiMessage mail;

    private Boolean rappel;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {


        List<Borrow> reminders = getManagerFactory().getBorrowManager().sendMailReminder();

        for (Borrow borrow : reminders){

            UserAccount user = getManagerFactory().getUserAccountManager().getUserByEmail(borrow.getEmail());
            Book bookMail = getManagerFactory().getBookManager().getBook(borrow.getISBN());
            borrow.setBook(bookMail);
            borrow.setUserAccount(user);

            String to = borrow.getEmail();

            String subject = "Rappel ! Le pret du livre " + borrow.getBook().getTitle() + " arrive bientot a terme.";

            String body = "Bonjour, \n\nvous avez activé le rappel automatique dans votre espace personnel 5 jours avant la date de fin de pret. " +
                    "Le livre " + bookMail.getTitle() + " a ete emprunté le : " + borrow.getStartDate().toGregorianCalendar().getTime() + " et doit etre rendu avant le " +
                    borrow.getEndDate().toGregorianCalendar().getTime() + ".\nLe pret arrivant bientot a terme, merci de vous rapprocher de votre biblioteque preferé pour nous retourner le livre. Merci pour votre comprehension." +
                    "\n\nA bientot !!";


            mail.sendMail(to, subject, body);




        }

        return RepeatStatus.FINISHED;
    }
}
