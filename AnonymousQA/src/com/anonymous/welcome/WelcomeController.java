package com.anonymous.welcome;

public class WelcomeController implements WelcomeControllerToView, WelcomeControllerToModel {
    private final WelcomeViewToController welcomeView;
    private final WelcomeModelToController welcomeModel;

    WelcomeController(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
        welcomeModel = new WelcomeModel(this);
    }

    @Override
    public void checkUserChoice(int choice) {
        switch (choice){

            case 1: welcomeView.newUser();
                    break;

            case 2: welcomeView.attemptToLogin();
                    break;

            case 3: welcomeView.guestLogin();
                    break;

            default: System.out.println("Invalid Choice, Enter again");

        }
    }

    @Override
    public void verifycredentials(String username, String password) {
        welcomeModel.verifycredentials(username,password);
    }

    @Override
    public void guestLogin(String username, String question) {
        welcomeModel.guestLogin(username,question);
    }

    @Override
    public void questionSentSuccessfully() {
        welcomeView.questionSentSuccessfully();
    }

    @Override
    public void invalidUsername() {
        welcomeView.invalidUsername();
    }

    @Override
    public void valid(String username) {
        welcomeView.valid(username);
    }

    @Override
    public void invalid() {
        welcomeView.invalid();
    }
}