package banking.admin;

import banking.dto.AccountDetails;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminView implements AdminViewToController {
    private final AdminControllerToView adminController;

    private final Scanner input=new Scanner(System.in);

    public AdminView() {
        adminController = new AdminController(this);
    }

    public static void main(String[] args) {
        AdminView adminView=new AdminView();
        adminView.create();
    }
    public void create(){
        System.out.println("Welcome admin!");
        adminControls();
    }
     public void adminControls(){
        try {
            boolean toContinue=false;
            do {
                System.out.println("1. View Customer Data\n2. Validate new User");
                int choice = input.nextInt();
                adminController.checkChoice(choice);
                System.out.println("Do you Want to Continue? true/False");
                toContinue=input.nextBoolean();
            }while (toContinue);
        }
        catch (Exception e){
            System.out.println("Invalid Input");
            adminControls();
        }
     }

    @Override
    public void printNewUser(HashMap<String, AccountDetails> newName)
    {

       for(Map.Entry<String,AccountDetails> entry:newName.entrySet()) {
           System.out.println("    ACC HOLDER NAME:"+entry.getValue().getAccountHolderName());
           System.out.println("    PHONE NUMBER:"+entry.getValue().getPhoneNumber());
           System.out.println("APPROVE USER? True/False");
           if(input.nextBoolean())
               adminController.addUser(entry.getValue());
           else
               adminController.removeUser(entry.getValue());
       }
    }

    @Override
    public void Success() {
        System.out.println("Successfully Updated");
    }

    @Override
    public void viewData() {
        System.out.println("Enter Customer CIF Number");
        String CIFnumber=input.next();
        adminController.viewData(CIFnumber);

    }

    @Override
    public void printData(AccountDetails accountDetails) {

        System.out.println("              ACCOUNT DETAILS");
        System.out.println("    ACC HOLDER NAME:"+accountDetails.getAccountHolderName());
        System.out.println("    PHONE NUMBER:"+accountDetails.getPhoneNumber());
        System.out.println("    CUSTOMER CONTACT ADDRESS:"+accountDetails.getAddress());
        System.out.println("    CIF NO:"+accountDetails.getCIFNumber());
        System.out.println("    ACC OPENED ON:"+accountDetails.getDate());
    }
}