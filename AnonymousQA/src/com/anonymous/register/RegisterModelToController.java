package com.anonymous.register;

public interface RegisterModelToController {

    void validateUserName(String userName);

    void createAccount(String name, String email, String username, String password);



}