package banking.features;

import banking.dto.AccountDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FeaturesView implements FeaturesViewToController {
    private FeaturesControllerToView featuresController;

    private Scanner input=new Scanner(System.in);

    public FeaturesView() {
        featuresController = new FeaturesController(this);
    }

    public void create(String username){
        userHomempage(username);
    }

    public void userHomempage(String username){
     try {
         boolean flag;
         do {
             System.out.println("1. Deposit.");
             System.out.println("2. Transfer.");
             System.out.println("3. Withdraw.");
             System.out.println("4. View Transaction History");
             System.out.println("5. View Passbook");
             System.out.print("\nEnter your choice : ");
             int choice = input.nextInt();
             featuresController.checkChoice(choice, username);
             System.out.println("Do you want to continue?");
             flag = input.nextBoolean();
         } while (flag);
     }
     catch (Exception e){
         System.out.println("Invalid input");
         userHomempage(username);
     }

    }

    @Override
    public void deposit(String username) {
        System.out.print("Enter amount to deposit: ");
        double amount=input.nextDouble();
        featuresController.deposit(username,amount,new Date());
    }

    @Override
    public void withdraw(String username) {
        System.out.print("Enter amount to withdraw: ");
        double amount=input.nextDouble();
        featuresController.withdraw(username,amount,new Date());
    }

    @Override
    public void transfer(String username) {
        System.out.print("Enter Payee username: ");
        String payeeName=input.next();
        System.out.print("Enter Payee CIF Number: ");
        String payeeCIFNumber=input.next();
        System.out.print("Enter amount to transfer: ");
        double amount=input.nextDouble();
        featuresController.transfer(username,payeeName,payeeCIFNumber,amount,new Date());
    }


    public void depositSuccess(String display) {
        System.out.println(display);
    }

    @Override
    public void withdrawalSuccess(String display) {
        System.out.println(display);
    }

    @Override
    public void withdrawalFailed() {
        System.out.println("Insufficient balance to perform withdrawal");
    }

    @Override
    public void withdrawalLimitReached() {
        System.out.println("Withdrawal Limit Exceeded");
    }

    @Override
    public void transactionFailed() {
        System.out.println("Insufficient balance to perform transaction");
    }

    @Override
    public void transactionLimitReached() {
        System.out.println("Transaction Limit Exceeded");
    }

    @Override
    public void invalidPayeeDetails() {
        System.err.println("Insufficient Funds or Invalid Payee details!");
        System.out.println("Session Timed Out");
    }

    @Override
    public void transactionSuccess(String display) {
        System.out.println(display);
    }

    @Override
    public void printHistory(ArrayList<String> history) {
        System.out.println("\t\t\t\t TRANSACTION DETAILS");
        for(String temp:history){
            System.out.println(temp);
        }
    }

    @Override
    public void printData(AccountDetails accountDetails) {

        System.out.println("              ACCOUNT DETAILS");
        System.out.println("    ACC HOLDER NAME:"+accountDetails.getAccountHolderName());
        System.out.println("    PHONE NUMBER:"+accountDetails.getPhoneNumber());
        System.out.println("    CUSTOMER CONTACT ADDRESS:"+accountDetails.getAddress());
        System.out.println("    CIF NO:"+accountDetails.getCIFNumber());
        System.out.println("    ACC OPENED ON:"+accountDetails.getDate());
        System.out.println("    VIEW BALANCE:"+accountDetails.getBalance());
    }


}