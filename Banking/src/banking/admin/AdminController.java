package banking.admin;

import banking.dto.AccountDetails;

import java.util.HashMap;

public class AdminController implements AdminControllerToView, AdminControllerToModel {
    private final AdminViewToController adminView;
    private final AdminModelToController adminModel;

    AdminController(AdminView adminView) {
        this.adminView = adminView;
        adminModel = new AdminModel(this);
    }

    @Override
    public void checkChoice(int choice) {
        switch (choice){
            case 1 -> adminView.viewData();

            case 2 -> adminModel.validateCustomer();

            default -> {
                System.out.println("Invalid choice");
                adminView.adminControls();
            }


        }
    }

    @Override
    public void viewData(String CIFnumber) {
        adminModel.viewData(CIFnumber);
    }

    @Override
    public void addUser(AccountDetails accountDetails) {
        adminModel.addUser(accountDetails);
    }

    @Override
    public void removeUser(AccountDetails accountDetails) {
        adminModel.removeUser(accountDetails);
    }

    @Override
    public void printData(AccountDetails accountDetails) {
        adminView.printData(accountDetails);
    }

    @Override
    public void printNewUser(HashMap<String, AccountDetails> userName) {
        adminView.printNewUser(userName);
    }

    @Override
    public void Success() {
        adminView.Success();
    }
}