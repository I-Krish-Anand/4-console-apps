package banking.Register;

public interface RegisterControllerToView {

    void validateUserName(String userName);

    boolean validatePassword(String password);

    void createAccount(String name,String address,String phoneNo,String username,String password,double amount);

}