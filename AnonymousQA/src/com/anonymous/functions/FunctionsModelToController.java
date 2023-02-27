package com.anonymous.functions;

public interface FunctionsModelToController {

    void sendQuestion(String username, String question, String s);

    void viewInbox(String username);

    void viewChat(String username);

    void reply(String username,int key,String question);


}