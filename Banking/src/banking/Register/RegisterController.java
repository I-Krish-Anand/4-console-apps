package banking.Register;

import banking.dto.AccountDetails;

public class RegisterController implements RegisterControllerToView, RegisterControllerToModel {
    private final RegisterViewToController registerView;
    private final RegisterModelToController registerModel;

    RegisterController(RegisterView registerView) {
        this.registerView = registerView;
        registerModel = new RegisterModel(this);
    }

    @Override
    public void validateUserName(String userName) {
        registerModel.validateUserName(userName);
    }

    @Override
    public boolean validatePassword(String password) {
        if(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}")))) {
            registerView.invalidPasswordCombination();
            return false;
        }
        return true;
    }

    @Override
    public void createAccount(String name, String address, String phoneNo, String username, String password, double amount) {
        registerModel.createAccount(name,address,phoneNo,username,password,amount);
    }

    @Override
    public void userNameAlreadyExists() {
        registerView.userNameAlreadyExists();
    }

    @Override
    public void accountCreatedSuccessfully(AccountDetails accountDetails) {
        registerView.accountCreatedSuccessfully(accountDetails);
    }
}