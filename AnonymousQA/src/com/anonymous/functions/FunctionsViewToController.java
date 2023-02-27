package com.anonymous.functions;

import com.anonymous.dto.Account;

import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.TreeMap;

public interface FunctionsViewToController {

    void sendQuestion(String username);

    void questionSentSuccessfully();

    void replySentSuccessfully();

    void invalidUsername();

    void homePage(String username);

    void printInbox(Stack<String> inbox);

    void printChat(String username, LinkedHashMap<Account, String> chat);

    void inboxEmpty();

}