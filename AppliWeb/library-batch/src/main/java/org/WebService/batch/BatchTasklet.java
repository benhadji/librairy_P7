package org.WebService.batch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.webservice.service.services.Borrow;

import java.util.List;

@Component
public class BatchTasklet extends AbstractManager implements Tasklet {


    @Autowired
    private EnvoiMessage mail;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        List<Borrow> borrowList = getManagerFactory().getBorrowManager().getListBorrowByTimeExceeded();


        for (Borrow borrow : borrowList){

            String to = borrow.getUserAccount().getEmail();

            String subject = "Periode de pret depassé.";

            String body = "Bonjour, le pret du livre " + borrow.getBook().getTitle() + " est arrivé a terme. " +
                    "Le livre doit donc etre retourné a la biblioteque dans les plus bref delai. " +
                    "Vous pouvez aussi le prolonger dans votre espace personnel si il ne l'a pas deja été. " +
                    "A bientot !!";

            mail.sendMail(to, subject, body);
        }

        return RepeatStatus.FINISHED;
    }
}
