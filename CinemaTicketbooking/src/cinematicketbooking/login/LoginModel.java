package cinematicketbooking.login;

import cinematicketbooking.repository.TicketRepository;

import java.text.ParseException;

public class LoginModel implements LoginModelToController {
    private final LoginControllerToModel loginController;

    LoginModel(LoginController loginController) {
        this.loginController = loginController;
    }
    public void checkCredentials(String username,String password)  {
            int choice= TicketRepository.getInstance().checkCredentials(username,password);
            switch (choice)
            {
                case 1 -> adminLoginSuccess(username);
                case 2 -> loginSuccess(username);
                default-> loginFailure();
            }
    }
    private void loginSuccess(String username)  {
         loginController.loginSuccess(username);
    }
    private void loginFailure(){
         loginController.loginFailure();
    }

    private void adminLoginSuccess(String username){
        loginController.adminLoginSuccess(username);
    }
}