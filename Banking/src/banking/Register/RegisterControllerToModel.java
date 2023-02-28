package banking.Register;

import banking.dto.AccountDetails;

public interface RegisterControllerToModel {

    void userNameAlreadyExists();

    void accountCreatedSuccessfully(AccountDetails accountDetails);

}