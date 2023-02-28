package banking.Register;

public interface RegisterModelToController {

    void validateUserName(String userName);

    void createAccount(String name,String address,String phoneNo,String username,String password,double amount);

}