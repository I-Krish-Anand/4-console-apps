package banking.admin;

import banking.dto.AccountDetails;

public interface AdminControllerToView {

    void checkChoice(int choice);

    void viewData(String CIFnumber);

    void addUser(AccountDetails accountDetails);

    void removeUser(AccountDetails accountDetails);

}