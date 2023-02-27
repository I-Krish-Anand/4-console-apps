package com.anonymous.dto;

import java.util.*;

public class Account {

    private String name;

    private String email;

    private String username;

    private String password;

    Stack<String> inbox=new Stack<>();

    LinkedHashMap<Account,String> chat=new LinkedHashMap<>();

    public Account(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Stack<String> getInbox() {
        return inbox;
    }

    public void setInbox(Stack<String> inbox) {
        this.inbox = inbox;
    }

    public LinkedHashMap<Account, String> getChat() {
        return chat;
    }

    public void setChat(LinkedHashMap<Account, String> chat) {
        this.chat = chat;
    }
}
