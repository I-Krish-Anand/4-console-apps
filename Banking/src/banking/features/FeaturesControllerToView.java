package banking.features;

import banking.dto.AccountDetails;

import java.util.Date;

public interface FeaturesControllerToView {

    void checkChoice(int choice, String username);

    void deposit(String username, double amount, Date date);

    void withdraw(String username, double amount, Date date);

    void transfer(String username, String payeeName, String CIFNumber,double amount, Date date);

}