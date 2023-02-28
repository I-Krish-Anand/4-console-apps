package banking.Register;

import banking.dto.AccountDetails;

import java.util.Scanner;

public class RegisterView implements RegisterViewToController {

    private String name;

    private String address;

    private String phoneNo;

    private String username;

    private String password;

    private double amount;
    private final RegisterControllerToView registerController;

    private final Scanner input=new Scanner(System.in);

    public RegisterView() {
        registerController = new RegisterController(this);
    }

    public void create(){
       getUserDetails();
    }
    void getUserDetails(){

        System.out.print("Enter name : ");
        name = input.nextLine();
        System.out.print("Enter address : ");
        address = input.nextLine();
        System.out.print("Enter contact number : ");
        phoneNo = input.nextLine();
        getUserCredentials();
    }
    void getUserCredentials(){
        System.out.println("Set username : ");
        username = input.next();
        registerController.validateUserName(username);
        setPassword();
        setInitialDeposit();
    }
    void setPassword(){
        boolean toContinue;
        do {
            System.out.println("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) :");
            password = input.next();
            toContinue=registerController.validatePassword(password);
        }while (!toContinue);
    }

    void setInitialDeposit(){
        System.out.print("Enter initial deposit : ");
        amount=input.nextDouble();
        createAccount(name,address,phoneNo,username,password,amount);
    }

    void createAccount(String name,String address,String phoneNo,String username,String password,double amount){
        registerController.createAccount(name,address,phoneNo,username,password,amount);
    }

    @Override
    public void userNameAlreadyExists() {
        System.out.println("Username Already Exists, Set a unique username");
        getUserCredentials();
    }

    @Override
    public void invalidPasswordCombination() {
        System.out.println("Invalid password combination, try again :");
    }

    @Override
    public void accountCreatedSuccessfully(AccountDetails accountDetails) {
        System.out.println("----->ACCOUNT SENT FOR VALIDATION<-----");
        System.out.println(accountDetails.getAccountHolderName());

    }


}