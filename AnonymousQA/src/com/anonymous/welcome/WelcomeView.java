package com.anonymous.welcome;

import com.anonymous.functions.FunctionsView;

import com.anonymous.register.RegisterView;

import java.util.Scanner;

public class WelcomeView implements WelcomeViewToController {
    private final WelcomeControllerToView welcomeController;
    private final Scanner input=new Scanner(System.in);
    WelcomeView() {
        welcomeController = new WelcomeController(this);
    }

    public static void main(String[] args) {
        WelcomeView welcomeView=new WelcomeView();
        welcomeView.create();
    }
    public void create(){
        try {

            boolean flag;
            do {
                System.out.format("%50s", "Hi There!, Welcome to Sayat!\n\n\n");
                System.out.println("1. Register account\n");
                System.out.println("2. Login\n");
                System.out.println("3. Post Messages anonymously");
                int choice = input.nextInt();
                welcomeController.checkUserChoice(choice);
                System.out.println("Do you want to continue?");
                flag = input.nextBoolean();
            } while (flag);
        }
        catch (Exception e){
            System.out.println("Invalid input");
            create();
        }
    }

    public void guestLogin(){
            input.nextLine();
            System.out.println("Enter username to send:");
            String toUsername=input.nextLine();
            System.out.println("Enter your question");
            String question=input.nextLine();
            welcomeController.guestLogin(toUsername,question);

    }

    @Override
    public void questionSentSuccessfully() {
        System.out.println("Question sent successfully");
    }

    @Override
    public void invalidUsername() {
        System.out.println("Invalid Username");
    }

    @Override
    public void valid(String username) {
        System.out.println("\n-------------------");
        System.out.println("Howdy!  "+username);
        FunctionsView functionsView=new FunctionsView();
        functionsView.create(username);

    }

    @Override
    public void invalid() {
        System.out.println("Invalid credentials");create();
    }

    @Override
    public void newUser() {
        RegisterView registerView=new RegisterView();
        registerView.create();
    }

    @Override
    public void attemptToLogin() {
        input.nextLine();
        System.out.println("Enter your userName");
        String username=input.nextLine();
        System.out.println("Enter your Password:");
        String passWord=input.nextLine();
        welcomeController.verifycredentials(username,passWord);
    }
}
