package com.anonymous.welcome;

public interface WelcomeViewToController {

    void newUser();

    void attemptToLogin();

    void create();

    void valid(String username);

    void invalid();

    void guestLogin();

    void questionSentSuccessfully();

    void invalidUsername();
}