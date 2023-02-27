package com.anonymous.repository;

import com.anonymous.dto.Account;

import java.util.*;

public class Repository {

    private static Repository repository;

    HashMap<String,Account> accountDetailsHashMap=new HashMap<>();

    private Repository(){ }

    public static Repository getInstance(){
        if(repository==null) {
            repository = new Repository();
            repository.initialSetup();
        }
        return repository;
    }

    private void initialSetup(){
        accountDetailsHashMap.put("krish",new Account("krish anand","krish@gmail.com","krish","krish123@S"));
        accountDetailsHashMap.put("kohli",new Account("virat kohli","virat@gmail.com","kohli","kohli123@S"));

    }
    public boolean validateUserName(String userName) {
        return !accountDetailsHashMap.containsKey(userName);
    }
    public boolean verifyCredentials(String username,String password){

        return accountDetailsHashMap.containsKey(username) && accountDetailsHashMap.get(username).getPassword().equals(password);
    }
    public void createAccount(String name, String email, String username, String password) {
        Account account=new Account(name,email,username,password);
        accountDetailsHashMap.put(username,account);
    }
    public boolean sendQuestion(String username, String toUsername, String question) {

        for(Map.Entry<String,Account>senderEntry:accountDetailsHashMap.entrySet()) {

            if (senderEntry.getKey().equals(username)) {
                for (Map.Entry<String, Account> entry : accountDetailsHashMap.entrySet()) {
                    if (entry.getKey().equals(toUsername)) {
                        entry.getValue().getChat().put(senderEntry.getValue(), question + " Posted on:" + new Date());
                        return true;
                    }
                }
            }
        }
         return false;
    }
    public Stack<String> viewInbox(String username) {

        for(Map.Entry<String,Account>entry:accountDetailsHashMap.entrySet()){

            if(entry.getKey().equals(username) && !entry.getValue().getInbox().isEmpty())
                return entry.getValue().getInbox();

        }
        return null;
    }
    public boolean guestLogin(String username, String question){

        for(Map.Entry<String,Account>entry:accountDetailsHashMap.entrySet()){
            if(entry.getKey().equals(username)){
                entry.getValue().getInbox().add(question+" Posted on:"+new Date());
                return true;
            }
        }
        return false;

    }
    public LinkedHashMap<Account,String> viewChat(String username) {

        for(Map.Entry<String,Account>entry:accountDetailsHashMap.entrySet()){

            if(entry.getKey().equals(username) && !entry.getValue().getChat().isEmpty())
                return entry.getValue().getChat();
        }
        return null;

    }

    public void reply(String username, int key, String question)
    {
       for(Map.Entry<String,Account> accountEntry:accountDetailsHashMap.entrySet()){

           if(accountEntry.getKey().equals(username))
           {
             int index=1;
             LinkedHashMap<Account,String> linkedHashMap=accountEntry.getValue().getChat();
             for(Map.Entry<Account,String> entry:linkedHashMap.entrySet())
             {
                 if(index==key)
                 {
                     entry.getKey().getChat().put(accountEntry.getValue(),question+"  posted on:"+new Date());
                     linkedHashMap.remove(entry.getKey());
                     return;
                 }
                 index++;
             }
           }
       }
    }
}
