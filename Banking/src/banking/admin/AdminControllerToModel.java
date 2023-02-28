package banking.admin;

import banking.dto.AccountDetails;

import java.util.HashMap;

public interface AdminControllerToModel {

    void printData(AccountDetails accountDetails);

    void printNewUser(HashMap<String, AccountDetails>userName);

    void Success();


}