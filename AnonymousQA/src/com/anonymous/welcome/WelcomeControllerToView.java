package com.anonymous.welcome;

public interface WelcomeControllerToView {

     void checkUserChoice(int choice);

     void verifycredentials(String username,String password);

     void guestLogin(String username,String question);
}