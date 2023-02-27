package com.anonymous.functions;

import com.anonymous.dto.Account;
import com.anonymous.repository.Repository;

import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.TreeMap;

public class FunctionsModel implements FunctionsModelToController {
    FunctionsControllerToModel functionsController;

    FunctionsModel(FunctionsController functionsController) {
        this.functionsController = functionsController;
    }

    @Override
    public void sendQuestion(String username, String toUsername, String question) {
       if( Repository.getInstance().sendQuestion(username,toUsername,question))
           functionsController.questionSentSuccessfully();
       else
           functionsController.invalidUsername();
    }

    @Override
    public void viewInbox(String username) {
        Stack<String>inbox=Repository.getInstance().viewInbox(username);
        if(inbox!=null)
            functionsController.printInbox(inbox);
        else
            functionsController.inboxEmpty();
    }

    @Override
    public void viewChat(String username) {
        LinkedHashMap<Account,String> chat =Repository.getInstance().viewChat(username);
        if(chat!=null)
            functionsController.printChat(username,chat);
        else
            functionsController.inboxEmpty();
    }

    @Override
    public void reply(String username, int key, String question) {
         Repository.getInstance().reply(username,key,question);
         functionsController.replySentSuccessfully();
    }

}