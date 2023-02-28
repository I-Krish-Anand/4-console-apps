package banking.features;

import banking.Repository.Bank;
import banking.dto.AccountDetails;

import java.util.ArrayList;
import java.util.Date;

public class FeaturesModel implements FeaturesModelToController {
    FeaturesControllerToModel featuresController;

    FeaturesModel(FeaturesController featuresController) {
        this.featuresController = featuresController;
    }

    @Override
    public void deposit(String username, double amount, Date date) {
        String display=Bank.getInstance().deposit(username,amount,date);
        featuresController.depositSuccess(display);
    }

    @Override
    public void withdraw(String username, double amount, Date date) {
        String display=Bank.getInstance().withdraw(username,amount,date);
        if(display!=null)
        featuresController.withdrawalSuccess(display);
    }

    @Override
    public void transfer(String username, String payeeName, String CIFNumber, double amount, Date date) {
       String display=Bank.getInstance().transfer(username,payeeName,CIFNumber,amount,date);
       if(display!=null)
           featuresController.transactionSuccess(display);
       else
           featuresController.invalidPayeeDetails();
    }

    @Override
    public void getTransactionHistory(String username) {
        ArrayList<String>history=Bank.getInstance().getTransactionHistory(username);
        if(history!=null)
            featuresController.printHistory(history);

    }

    @Override
    public void viewPassbok(String username) {
        AccountDetails accountDetails=Bank.getInstance().viewPassbok(username);
        if(accountDetails!=null)
            featuresController.printData(accountDetails);
    }


}