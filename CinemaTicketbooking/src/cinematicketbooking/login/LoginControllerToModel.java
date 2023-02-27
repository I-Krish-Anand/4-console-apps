package cinematicketbooking.login;

import java.text.ParseException;

public interface LoginControllerToModel {

    void loginSuccess(String username);

    void loginFailure();

    void adminLoginSuccess(String username);

}