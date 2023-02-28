package banking.admin;

import banking.dto.AccountDetails;

public interface AdminModelToController {


    void viewData(String CIFnumber);

    void validateCustomer();

    void addUser(AccountDetails accountDetails);

    void removeUser(AccountDetails accountDetails);




}