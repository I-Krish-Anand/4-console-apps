package com.anonymous.register;



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
    public void createAccount(String name, String email, String username, String password) {
        registerModel.createAccount(name, email, username, password);
    }

    @Override
    public void userNameAlreadyExists() {
        registerView.userNameAlreadyExists();
    }

    @Override
    public void accountCreatedSuccessfully() {
        registerView.accountCreatedSuccessfully();
    }
}