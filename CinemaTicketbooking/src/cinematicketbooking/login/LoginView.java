package cinematicketbooking.login;

import cinematicketbooking.admincontrols.AdminControlsView;
import cinematicketbooking.booktickets.BookTicketsView;

import java.util.Scanner;

public class LoginView implements LoginViewToController {
    private final LoginControllerToView loginController;
    private final Scanner input=new Scanner(System.in);

    LoginView() {
        loginController = new LoginController(this);
    }

    public static void main(String[] args)  {
        LoginView loginView=new LoginView();
        loginView.create();
    }

    public void create()  {
        getCredentials();
    }
    private void getCredentials()  {
           boolean flag = false;
           do {
               System.out.println("\t WELCOME TO PVR CINEMAS");
               System.out.println("Enter Username");
               String username = input.next();
               System.out.println("Enter Password");
               String password = input.next();
               loginController.checkCredentials(username, password);
               try {

                   System.out.println("Switch user?True/False");
                   flag = input.nextBoolean();
               }
               catch (Exception e){
                   System.out.println("Invalid Input");
                   getCredentials();
               }
           } while (flag);

    }

    /**
     *
     * @param username
     * navigates to user controls page
     */
    @Override
    public void loginSuccess(String username)  {
        System.out.println(username+""+": Logged In Successfully");
        BookTicketsView bookTicketsView = new BookTicketsView();
        bookTicketsView.create();

    }

    /**
     *
     * @param username
     *
     * navigates to admin login page
     */

    @Override
    public void adminLoginSuccess(String username) {
        AdminControlsView adminControlsView=new AdminControlsView();
        adminControlsView.create();
    }

    /**
     * login attempt failed
     */
    public void loginFailure(){
        System.out.println("Invalid Credentials");
        getCredentials();
    }
}