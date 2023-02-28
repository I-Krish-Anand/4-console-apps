package banking.features;

import java.util.Date;

public interface FeaturesModelToController {

    void deposit(String username, double amount, Date date);

    void withdraw(String username, double amount, Date date);

    void transfer(String username, String payeeName, String CIFNumber,double amount, Date date);

    void getTransactionHistory(String username);

    void viewPassbok(String username);

}