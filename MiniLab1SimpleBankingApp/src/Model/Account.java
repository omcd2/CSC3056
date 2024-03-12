package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private String accountNumber;
    private String usernameOfAccountHolder;
    private String accountType; // "Standard" or "Saving"
    private Date accountOpeningDate;
    private double balance; // New field for balance

    public Account(String accountNumber, String usernameOfAccountHolder, String accountType, Date accountOpeningDate, double initialBalance) {
        this.accountNumber = accountNumber;
        this.usernameOfAccountHolder = usernameOfAccountHolder;
        this.accountType = accountType;
        this.accountOpeningDate = accountOpeningDate;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsernameOfAccountHolder() {
        return usernameOfAccountHolder;
    }

    public void setUsernameOfAccountHolder(String usernameOfAccountHolder) {
        this.usernameOfAccountHolder = usernameOfAccountHolder;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String formatOpeningDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(accountOpeningDate);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", usernameOfAccountHolder='" + usernameOfAccountHolder + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountOpeningDate=" + formatOpeningDate() +
                ", balance=" + balance +
                '}';
    }
}
