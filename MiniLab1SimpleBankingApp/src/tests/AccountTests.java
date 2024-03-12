package tests;
 
import Model.Account;
import Utils.TestUtils;
 
public class AccountTests {
 
    /**
     * Test the constructor of Account by using all its getter methods
     */
    public static void testConstructor() {
        // Setup
        double initialBalance = 100.0;
        Account account = new Account(initialBalance);
 
        // Verify
        if (account.getBalance() == initialBalance) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "Test Constructor - Passed" + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "Test Constructor - Failed" + TestUtils.TEXT_COLOR_RESET);
        }
    }
 
    /*
     * Test all the setter methods of Account
     */
    public static void testSetters() {
        // Setup
        double initialBalance = 100.0;
        Account account = new Account(initialBalance);
 
        // Exercise
        double newBalance = 150.0;
        account.setBalance(newBalance);
 
        // Verify
        if (account.getBalance() == newBalance) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "Test Setters - Passed" + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "Test Setters - Failed" + TestUtils.TEXT_COLOR_RESET);
        }
    }
 
    public static void main(String[] args) {
        testConstructor();
        testSetters();
    }
}