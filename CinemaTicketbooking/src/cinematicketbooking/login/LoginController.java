package cinematicketbooking.login;

import java.text.ParseException;

public class LoginController implements LoginControllerToView, LoginControllerToModel {
    private final LoginViewToController loginView;
    private final LoginModelToController loginModel;

    LoginController(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel(this);
    }
    public void checkCredentials(String username,String password){
        loginModel.checkCredentials(username,password);
    }
    public void loginSuccess(String username) {
        loginView.loginSuccess(username);
    }
    public void loginFailure(){
        loginView.loginFailure();
    }

    @Override
    public void adminLoginSuccess(String username) {
        loginView.adminLoginSuccess(username);
    }
}