package com.anonymous.functions;

public interface FunctionsControllerToView {

    void checkUserChoice(int choice, String username);

    void sendQuestion(String username, String toUsername, String question);

    void reply(String username,int key,String question);





}