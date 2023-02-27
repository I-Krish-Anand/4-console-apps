package com.anonymous.functions;

import com.anonymous.dto.Account;

import java.util.LinkedHashMap;
import java.util.Scanner;

import java.util.Stack;

import java.util.TreeMap;

public class FunctionsView implements FunctionsViewToController {
    private final FunctionsControllerToView functionsController;

    private final Scanner input=new Scanner(System.in);

    public FunctionsView() {
        functionsController = new FunctionsController(this);
    }

    public void create(String username){
        homePage(username);
    }

    public void homePage(String username){
        try {

            boolean toContinue = false;
            do {
                System.out.println("1. Send Messages anonymously");
                System.out.println("2. View your Unread Messages");
                System.out.println("3 View and reply to your Stalkers");
                System.out.println("Enter your choice:");
                int choice = input.nextInt();
                functionsController.checkUserChoice(choice, username);
                System.out.println("Do you wan to continue?");
                toContinue = input.nextBoolean();
            } while (toContinue);
        }
        catch ( Exception e){
            System.out.println("Invalid Input");
            homePage(username);
        }
    }

    @Override
    public void printInbox(Stack<String> inbox) {

        System.out.println("----> Inbox<----");
        while (!inbox.isEmpty()){
            System.out.println(inbox.pop());
        }
    }

    @Override
    public void printChat(String username, LinkedHashMap<Account, String> chat) {
        try {

            int i = 1;
            for (String question : chat.values())
                System.out.println(i++ + " " + question);
            System.out.println("Choose SN0 number to reply:");
            int serialNo = input.nextInt();
            input.nextLine();
            System.out.println("Enter your reply:");
            String myReply = input.nextLine();
            functionsController.reply(username, serialNo, myReply);
        }
        catch (Exception e) {
            System.out.println("Invalid input");
            printChat(username,chat);
        }

    }


    @Override
    public void inboxEmpty() {
        System.out.println("Your Inbox is empty!");
    }

    public void sendQuestion(String username){

        input.nextLine();
        System.out.println("Enter username to send:");
        String toUsername=input.nextLine();
        System.out.println("Enter your question");
        String question=input.nextLine();
        functionsController.sendQuestion(username,toUsername,question);

    }

    @Override
    public void questionSentSuccessfully() {
        System.out.println("Question Sent Successfully");
    }

    @Override
    public void replySentSuccessfully() {
        System.out.println("Reply Sent Successfully");
    }

    @Override
    public void invalidUsername() {
        System.out.println("Invalid Recipient address, Kindly re-check");
    }
}