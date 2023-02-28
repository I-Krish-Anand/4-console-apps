package banking.features;

import banking.dto.AccountDetails;

import java.util.ArrayList;

public interface FeaturesViewToController {

    void create(String username);

    void deposit(String username);

    void withdraw(String username);

    void transfer(String username);

    void depositSuccess(String username);

    void withdrawalSuccess(String display);

    void withdrawalFailed();

    void withdrawalLimitReached();

    void transactionFailed();

    void transactionLimitReached();

    void invalidPayeeDetails();

    void transactionSuccess(String display);

    void printHistory(ArrayList<String> history);

    void printData(AccountDetails accountDetails);

}


