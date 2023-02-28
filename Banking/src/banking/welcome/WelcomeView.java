package banking.welcome;

import banking.Register.RegisterView;
import banking.admin.AdminView;
import banking.dto.AccountDetails;
import banking.features.FeaturesView;

import java.util.Scanner;

public class WelcomeView implements WelcomeViewToController {
    private final WelcomeControllerToView welcomeController;

    private final Scanner input=new Scanner(System.in);

    WelcomeView() {
        welcomeController = new WelcomeController(this);
    }

    public static void main(String[] args) {
        WelcomeView welcomeView=new WelcomeView();
        welcomeView.create();
    }
    public void create(){
        try {

            boolean flag;
            do {
                input.nextLine();
                System.out.format("%50s", "WELCOME TO YOUR BANK\n\n\n");
                System.out.println("1. Register account\n");
                System.out.println("2. Login\n");
                int choice = input.nextInt();
                welcomeController.checkUserChoice(choice);
                System.out.println("Do you want to continue?");
                flag = input.nextBoolean();
            } while (flag);
        }
        catch (Exception e){
            System.out.println("Input mismatch");
            create();
        }
    }

    @Override
    public void valid(String username) {
        System.out.println("\n-------------------");
        System.out.println("W  E  L  C  O  M  E  "+username);
        System.out.println("-------------------\n");
        FeaturesView featuresView=new FeaturesView();
        featuresView.create(username);
    }

    @Override
    public void adminControls() {
        AdminView adminView=new AdminView();
        adminView.create();
    }

    @Override
    public void invalid() {
        System.out.println("Invalid credentials");
    }

    @Override
    public void newUser() {
        RegisterView registerView=new RegisterView();
        registerView.create();
    }

    @Override
    public void attemptToLogin() {
        System.out.println("Enter your userName");
        String username=input.next();
        System.out.println("Enter your Password:");
        String passWord=input.next();
        welcomeController.verifycredentials(username,passWord);
    }
}