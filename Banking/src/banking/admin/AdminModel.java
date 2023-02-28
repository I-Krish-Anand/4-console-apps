package banking.admin;

import banking.Repository.Bank;
import banking.dto.AccountDetails;

import java.util.HashMap;

public class AdminModel implements AdminModelToController {
    AdminControllerToModel adminController;

    AdminModel(AdminController adminController) {
        this.adminController = adminController;
    }

    @Override
    public void viewData(String CIFnumber) {
        AccountDetails accountDetails= Bank.getInstance().viewData(CIFnumber);
        if(accountDetails!=null)
            adminController.printData(accountDetails);
    }

    @Override
    public void validateCustomer() {
       HashMap<String,AccountDetails> newUser= Bank.getInstance().validateCustomer();
       adminController.printNewUser(newUser);
    }

    @Override
    public void addUser(AccountDetails accountDetails) {
        Bank.getInstance().addUser(accountDetails);
        adminController.Success();
    }

    @Override
    public void removeUser(AccountDetails accountDetails) {
        Bank.getInstance().removeUser(accountDetails);
    }


}