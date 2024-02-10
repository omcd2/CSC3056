package app;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.Random;
 
 
import Model.Account;
import Model.Transaction;
import Model.User;
 
public class SimpleBankingApp {
    public static Vector<User> users = new Vector<User>();
    public static Vector<Account> accounts = new Vector<Account>();
    public static Vector<Transaction> transactions = new Vector<Transaction>();
 
    public static void main(String[] args) {
        loadUserData();
        loadAccountData();
        System.out.println("Initial state after loading:");
        printAllAccountsBalances();
        addRandomTransaction();
        System.out.println("\nState after the 1st addTransaction:");
        printAllAccountsBalances();
        addRandomTransaction();
        addRandomTransaction();
        System.out.println("\nState after the 2nd and 3rd addTransaction:");
        printAllAccountsBalances();
    }
 
    public static void loadUserData() {
        User aUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
        users.add(aUser);
 
        aUser = new User("james.cameron@gmail.com", "angel", "James", "Cameron", "07777654321");
        users.add(aUser);
 
        aUser = new User("julia.roberts@gmail.com", "change_me", "Julia", "roberts", "07770123456");
        users.add(aUser);
    }
 
    public static void loadAccountData() {
        Account anAccount;
        try {
            anAccount = new Account("5495-1234", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
            accounts.add(anAccount);
 
            anAccount = new Account("5495-1239", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
            accounts.add(anAccount);
 
            anAccount = new Account("5495-1291", "mike", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2019"));
            accounts.add(anAccount);
 
            anAccount = new Account("5495-6789", "David.McDonald@gmail.com", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
            accounts.add(anAccount);
 
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    public static void addRandomTransaction() {
        Random random = new Random();
        Transaction transaction = new Transaction(accounts.get(random.nextInt(accounts.size())).getAccount_number(), 
                                                  random.nextDouble() * 1000, null); // Generate random amount
        transactions.add(transaction);
    }
 
    public static void printAllAccountsBalances() {
        System.out.println("Account balances for all accounts:");
        System.out.println(String.format("%-15s| %-10s", "Account Number", "Balance"));
        System.out.println("--------------------------");
 
        for (Account account : accounts) {
            double balance = getBalance(account.getAccount_number());
            System.out.println(String.format("%-15s| %-10.2f", account.getAccount_number(), balance));
        }
    }
 
    public static double getBalance(String accountNumber) {
        double balance = 0.0;
 
        for (Transaction transaction : transactions) {
            String transactionAccountNumber = transaction.getAccount_number();
            if (transactionAccountNumber != null && transactionAccountNumber.equals(accountNumber)) {
                balance += transaction.getTransaction_amount();
            }
        }
 
        return balance;
    }

	public static void addTransaction(String account_number, double d) {
		// TODO Auto-generated method stub
		
	}
}    