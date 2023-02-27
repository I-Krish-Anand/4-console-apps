package com.anonymous.register;

import com.anonymous.repository.Repository;

public class RegisterModel implements RegisterModelToController {
    RegisterControllerToModel registerController;

    RegisterModel(RegisterController registerController) {
        this.registerController = registerController;
    }

    @Override
    public void validateUserName(String userName) {

        boolean flag= Repository.getInstance().validateUserName(userName);
        if(!flag)
            registerController.userNameAlreadyExists();
    }

    @Override
    public void createAccount(String name, String email, String username, String password) {
        Repository.getInstance().createAccount(name, email, username, password);
        registerController.accountCreatedSuccessfully();
    }


}