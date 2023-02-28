package banking.features;

import banking.dto.AccountDetails;

import java.util.ArrayList;

public interface FeaturesControllerToModel {

    void depositSuccess(String display);

    void withdrawalSuccess(String username);

    void invalidPayeeDetails();

    void transactionSuccess(String display);

    void printHistory(ArrayList<String> history);


}