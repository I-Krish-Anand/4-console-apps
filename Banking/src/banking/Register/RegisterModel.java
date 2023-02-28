package banking.Register;

import banking.Repository.Bank;
import banking.dto.AccountDetails;

public class RegisterModel implements RegisterModelToController {
    RegisterControllerToModel registerController;

    RegisterModel(RegisterController registerController) {
        this.registerController = registerController;
    }

    @Override
    public void validateUserName(String userName) {

        boolean flag= Bank.getInstance().validateUserName(userName);
        if(!flag)
            registerController.userNameAlreadyExists();
    }

    @Override
    public void createAccount(String name, String address, String phoneNo, String username, String password, double amount) {
        AccountDetails accountDetails=Bank.getInstance().createAccount(name,address,phoneNo,username,password,amount);
        registerController.accountCreatedSuccessfully(accountDetails);
    }
}