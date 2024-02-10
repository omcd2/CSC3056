package app;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import Model.Account;
import Model.Transaction;
import Model.User;
 
public class SimpleBankingApp {
    public static Vector<User> users = new Vector<User>();
    public static Vector<Account> accounts = new Vector<Account>();
    public static Vector<Transaction> transactions = new Vector<Transaction>();
 
    public static void loadUserData() {
        users.add(new User("mike", "my_passwd", "Mike", "Smith", "07771234567"));
        users.add(new User("james.cameron@gmail.com", "angel", "James", "Cameron", "07777654321"));
        users.add(new User("julia.roberts@gmail.com", "change_me", "Julia", "roberts", "07770123456"));
    }
 
    public static void loadAccountData() {
        try {
            accounts.add(new Account("5495-1234", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"), 0));
            accounts.add(new Account("5495-1239", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"), 0));
            accounts.add(new Account("5495-1291", "mike", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2019"), 0));
            accounts.add(new Account("5495-6789", "David.McDonald@gmail.com", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"), 0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    public static void addTransaction(String accountNumber, double amount) {
        Account account = null;
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                account = acc;
                break;
            }
        }
        
        if (account != null) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            transactions.add(new Transaction(accountNumber, amount, Calendar.getInstance().getTime()));
        } else {
            System.out.println("Error: Account not found.");
        }
    }
 
    public static double getBalance(String accountNumber) {
        double balance = 0;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                balance = account.getBalance();
                for (Transaction transaction : transactions) {
                    if (transaction.getAccount_number().equals(accountNumber)) {
                        balance += transaction.getAmount();
                    }
                }
                break;
            }
        }
        return balance;
    }
 
    public static void main(String[] args) {
        loadUserData();
        loadAccountData();
    }
}
   