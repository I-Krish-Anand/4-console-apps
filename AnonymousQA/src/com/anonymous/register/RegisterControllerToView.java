package com.anonymous.register;

public interface RegisterControllerToView {

    void validateUserName(String userName);

    boolean validatePassword(String password);

    void createAccount(String name, String email, String username, String password);

}