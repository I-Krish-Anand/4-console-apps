package com.anonymous.functions;

import com.anonymous.dto.Account;

import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.TreeMap;

public interface FunctionsControllerToModel {

    void questionSentSuccessfully();

    void replySentSuccessfully();

    void invalidUsername();

    void printInbox(Stack<String> inbox);

    void printChat(String username, LinkedHashMap<Account, String> chat);

    void inboxEmpty();

}