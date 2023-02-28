package banking.admin;

import banking.dto.AccountDetails;

import java.util.HashMap;

public interface AdminViewToController {

    void viewData();

    void printData(AccountDetails accountDetails);

    void adminControls();

    void printNewUser(HashMap<String, AccountDetails>userName);

    void Success();


}