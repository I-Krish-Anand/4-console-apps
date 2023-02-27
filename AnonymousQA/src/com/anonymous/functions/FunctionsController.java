package com.anonymous.functions;

import com.anonymous.dto.Account;

import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.TreeMap;

public class FunctionsController implements FunctionsControllerToView, FunctionsControllerToModel {
    private final FunctionsViewToController functionsView;
    private final FunctionsModelToController functionsModel;

    FunctionsController(FunctionsView functionsView) {
        this.functionsView = functionsView;
        functionsModel = new FunctionsModel(this);
    }

    @Override
    public void checkUserChoice(int choice, String username) {
        switch (choice){
            case 1-> functionsView.sendQuestion(username);

            case 2-> functionsModel.viewInbox(username);

            case 3-> functionsModel.viewChat(username);

            default -> {
                System.out.println("Invalid choice try again");
                 functionsView.homePage(username);
            }
        }
    }

    @Override
    public void sendQuestion(String username, String toUsername, String question) {
        functionsModel.sendQuestion(username, toUsername,question);
    }



    @Override
    public void printChat(String username, LinkedHashMap<Account, String> chat) {
        functionsView.printChat(username,chat);
    }

    @Override
    public void inboxEmpty() {
        functionsView.inboxEmpty();
    }

    @Override
    public void reply(String username,int key, String question) {
        functionsModel.reply(username,key,question);
    }

    @Override
    public void questionSentSuccessfully() {
        functionsView.questionSentSuccessfully();
    }

    @Override
    public void replySentSuccessfully() {
        functionsView.replySentSuccessfully();
    }

    @Override
    public void invalidUsername() {
         functionsView.invalidUsername();
    }

    @Override
    public void printInbox(Stack<String> inbox) {
        functionsView.printInbox(inbox);
    }




}