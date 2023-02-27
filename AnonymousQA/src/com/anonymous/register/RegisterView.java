package com.anonymous.register;


import java.util.Scanner;

public class RegisterView implements RegisterViewToController {

    private String name;

    private String email;

    private String username;

    private String password;

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
        System.out.print("Enter Email id: ");
        email = input.nextLine();
        getUserCredentials();
    }
    void getUserCredentials(){
        System.out.println("Set username : ");
        username = input.next();
        registerController.validateUserName(username);
        setPassword();
        createAccount(name,email,username,password);
    }
    void setPassword(){
        boolean toContinue;
        do {
            System.out.println("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) :");
            password = input.next();
            toContinue=registerController.validatePassword(password);
        }while (!toContinue);
    }


    void createAccount(String name,String email,String username,String password){
        registerController.createAccount(name,email,username,password);
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
    public void accountCreatedSuccessfully() {
        System.out.println("Account created Successfully");
    }


}