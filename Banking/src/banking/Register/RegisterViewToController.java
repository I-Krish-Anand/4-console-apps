package banking.Register;

import banking.dto.AccountDetails;

public interface RegisterViewToController {

    void userNameAlreadyExists();

    void invalidPasswordCombination();

    void accountCreatedSuccessfully(AccountDetails accountDetails);

}