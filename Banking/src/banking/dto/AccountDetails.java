package banking.dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class AccountDetails {

    private String accountHolderName;

    private String address;

    private final String  BANK_ID="YB00202300";

    private static int accNo;

    private String phoneNumber;

    private String CIFNumber;

    private String username;

    private String password;

    private double balance;

    private LocalDate date;

    private ArrayList<String>DepositHistory=new ArrayList<>();

    protected AccountDetails(){}

    public AccountDetails(String accountHolderName, String address, String phoneNumber, String username, String password, double balance,LocalDate date) {
        accNo++;
        this.accountHolderName = accountHolderName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.date=date;
        CIFNumber=BANK_ID+accNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<String> getDepositHistory() {
        return DepositHistory;
    }

    public void setDepositHistory(ArrayList<String> depositHistory) {
        DepositHistory = depositHistory;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBANK_ID() {
        return BANK_ID;
    }

    public static int getAccNo() {
        return accNo;
    }

    public static void setAccNo(int accNo) {
        AccountDetails.accNo = accNo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCIFNumber() {
        return CIFNumber;
    }

    public void setCIFNumber(String CIFNumber) {
        this.CIFNumber = CIFNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
