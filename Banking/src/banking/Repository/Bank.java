package banking.Repository;
import banking.dto.AccountDetails;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private HashMap<String, AccountDetails>accountDetailsHashMap=new HashMap<>();

    private final HashMap<String, AccountDetails>newUser=new HashMap<>();

    private final HashMap<String,String> admin=new HashMap<>();

    private static Bank bank;

    private Bank(){}


    public static Bank getInstance(){
        if(bank==null) {
            bank = new Bank();
            bank.initialSetup();
        }
        return bank;
    }

    public int verifyCredentials(String username,String password){

        if(admin.containsKey(username) && admin.get(username).equals(password))
            return 1;
        if(accountDetailsHashMap.containsKey(username) && accountDetailsHashMap.get(username).getPassword().equals(password))
            return 2;
        else
            return  3;
    }
    public boolean validateUserName(String userName) {
        return !accountDetailsHashMap.containsKey(userName);
    }
    public AccountDetails createAccount(String name, String address, String phoneNo, String username, String password, double amount) {
        AccountDetails accountDetails=new AccountDetails(name,address,phoneNo,username,password,amount, LocalDate.now());
        newUser.put(username,accountDetails);
        accountDetails.getDepositHistory().add(NumberFormat.getCurrencyInstance().format(amount) + " credited to your account. Balance - " + NumberFormat.getCurrencyInstance().format(accountDetails.getBalance()) + " as on " + new Date());
        return accountDetails;
    }

    public String deposit(String username, double amount, Date date) {

         for(Map.Entry<String,AccountDetails>entry:accountDetailsHashMap.entrySet()) {
             if(entry.getKey().equals(username)) {
                 entry.getValue().setBalance(entry.getValue().getBalance() + amount);
                 entry.getValue().getDepositHistory().add((NumberFormat.getCurrencyInstance().format(amount) + " credited to your account. Balance - " + NumberFormat.getCurrencyInstance().format(entry.getValue().getBalance()) + " as on " + date));
                 return entry.getValue().getDepositHistory().get(entry.getValue().getDepositHistory().size()-1);
             }
         }
         return "";
    }

    public String withdraw(String username, double amount, Date date) {
        for(Map.Entry<String,AccountDetails>entry:accountDetailsHashMap.entrySet()) {
            if(entry.getKey().equals(username)) {

                if(entry.getValue().getBalance()-amount<500)
                    return null;
                entry.getValue().setBalance(entry.getValue().getBalance()-amount);
                entry.getValue().getDepositHistory().add((NumberFormat.getCurrencyInstance().format(amount) + " debited from your account. Balance - " + NumberFormat.getCurrencyInstance().format(entry.getValue().getBalance()) + " as on " + date));
                return entry.getValue().getDepositHistory().get(entry.getValue().getDepositHistory().size()-1);
            }
        }
        return null;
    }

    private void initialSetup(){
        bank.accountDetailsHashMap.put("krish",new AccountDetails("krish anand","anna nagar","6382076392","krish","krish123@S",10000,LocalDate.now()));
        bank.accountDetailsHashMap.put("bala",new AccountDetails("bala","anna nagar","6382076392","bala","brish123@S",10000,LocalDate.now()));
        bank.admin.put("admin","admin");
    }
    public String transfer(String username, String payeeName, String CIFNumber, double amount, Date date) {


        for(Map.Entry<String,AccountDetails>nominee:accountDetailsHashMap.entrySet()) {

            if(nominee.getKey().equals(username)) {
                AccountDetails accountDetails=nominee.getValue();
                if((accountDetails.getBalance()-amount)<500)
                    return null;

                for(Map.Entry<String,AccountDetails>entry:accountDetailsHashMap.entrySet()) {
                    if (entry.getValue().getUsername().equals(payeeName) && entry.getValue().getCIFNumber().equals(CIFNumber)) {

                        accountDetails.setBalance(accountDetails.getBalance() - amount);
                        entry.getValue().setBalance(entry.getValue().getBalance() + amount);
                        accountDetails.getDepositHistory().add(NumberFormat.getCurrencyInstance().format(amount) + " transferred from your account to CIF NO: " + CIFNumber + ". Balance - " + NumberFormat.getCurrencyInstance().format(accountDetails.getBalance()) + " as on " + date);
                        entry.getValue().getDepositHistory().add(NumberFormat.getCurrencyInstance().format(amount) + " credited to  your account from CIF NO: " + accountDetails.getCIFNumber() + ". Balance - " + NumberFormat.getCurrencyInstance().format(entry.getValue().getBalance()) + " as on " + date);
                        return accountDetails.getDepositHistory().get(accountDetails.getDepositHistory().size()-1);
                    }
                }
            }
        }
        return null;
    }
    public ArrayList<String> getTransactionHistory(String username) {
        for(Map.Entry<String,AccountDetails>entry:accountDetailsHashMap.entrySet()) {
            if(entry.getKey().equals(username)) {
                return entry.getValue().getDepositHistory();
            }
        }
        return null;
    }
    public AccountDetails viewData(String CIFnumber) {

        for(Map.Entry<String,AccountDetails>entry:accountDetailsHashMap.entrySet()) {
            if(entry.getValue().getCIFNumber().equals(CIFnumber)) {
                return entry.getValue();
            }
        }
        return null;
    }
    public HashMap<String,AccountDetails> validateCustomer() {
        return newUser;
    }

    public void addUser(AccountDetails accountDetails){
       accountDetailsHashMap.put(accountDetails.getUsername(),accountDetails);
       newUser.remove(accountDetails.getUsername());
    }

    public void removeUser(AccountDetails accountDetails) {
       newUser.remove(accountDetails.getUsername());
    }

    public AccountDetails viewPassbok(String username) {

        for(Map.Entry<String,AccountDetails>entry:accountDetailsHashMap.entrySet()) {
            if(entry.getValue().getUsername().equals(username)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
