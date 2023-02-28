package banking.features;

import banking.dto.AccountDetails;

import java.util.ArrayList;
import java.util.Date;

public class FeaturesController implements FeaturesControllerToView, FeaturesControllerToModel {
    private FeaturesViewToController featuresView;
    private FeaturesModelToController featuresModel;

    FeaturesController(FeaturesView featuresView) {
        this.featuresView = featuresView;
        featuresModel = new FeaturesModel(this);
    }

    @Override
    public void checkChoice(int choice, String username) {
        switch (choice){
            case 1-> featuresView.deposit(username);

            case 2-> featuresView.transfer(username);

            case 3-> featuresView.withdraw(username);

            case 4->  featuresModel.getTransactionHistory(username);

            case 5-> featuresModel.viewPassbok(username);

            default -> {
                System.out.println("Invalid choice try again");
                featuresView.create(username);
            }
        }
    }

    @Override
    public void deposit(String username, double amount, Date date) {
        featuresModel.deposit(username,amount,date);
    }

    @Override
    public void withdraw(String username, double amount, Date date) {
         if(amount>10000)
            featuresView.withdrawalLimitReached();
        else
            featuresModel.withdraw(username,amount,date);
    }

    @Override
    public void transfer(String username, String payeeName, String CIFNumber, double amount, Date date) {

        if(amount>50000)
            featuresView.transactionLimitReached();
        else
            featuresModel.transfer(username,payeeName,CIFNumber,amount,date);
    }

    @Override
    public void depositSuccess(String display) {
        featuresView.depositSuccess(display);
    }

    @Override
    public void withdrawalSuccess(String display) {
        featuresView.withdrawalSuccess(display);
    }

    @Override
    public void invalidPayeeDetails( ) {
          featuresView.invalidPayeeDetails();
    }

    @Override
    public void transactionSuccess(String display) {
            featuresView.transactionSuccess(display);
    }

    @Override
    public void printHistory(ArrayList<String> history) {
        featuresView.printHistory(history);
    }

    @Override
    public void printData(AccountDetails accountDetails) {
        featuresView.printData(accountDetails);
    }
}