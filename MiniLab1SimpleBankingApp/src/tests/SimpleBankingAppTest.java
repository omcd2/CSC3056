package tests;
 
import app.SimpleBankingApp;
import Utils.TestUtils;
 
 
public class SimpleBankingAppTest {
 
    public static void testLoadData() {
        SimpleBankingApp.loadUserData();
        SimpleBankingApp.loadAccountData();
 
        // Verify user and account data is loaded correctly
        assertEquals(3, SimpleBankingApp.users.size(), 5);
        assertEquals(4, SimpleBankingApp.accounts.size(), 5);
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadUserData and loadAccountData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
    }
 
    public static void testDeposits() {
        double balanceBefore = SimpleBankingApp.getBalance("5495-1234");
        double depositAmount = 50.21;
 
        SimpleBankingApp.addTransaction("5495-1234", depositAmount);
        double balanceAfter = SimpleBankingApp.getBalance("5495-1234");
 
        assertEquals(balanceBefore + depositAmount, balanceAfter, 0.01);
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
 
        // Teardown
        SimpleBankingApp.addTransaction("5495-1234", -depositAmount);
    }
 
    public static void testAddTransactionWithdrawals() {
        double balanceBefore = SimpleBankingApp.getBalance("5495-1234");
        double withdrawalAmount = 30.00;
 
        SimpleBankingApp.addTransaction("5495-1234", -withdrawalAmount); // Withdrawal
 
        double balanceAfter = SimpleBankingApp.getBalance("5495-1234");
        assertEquals(balanceBefore - withdrawalAmount, balanceAfter, 0.01);
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "testAddTransactionWithdrawals: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
 
        // Teardown
        SimpleBankingApp.addTransaction("5495-1234", withdrawalAmount); // Undo withdrawal
    }
 
    private static void assertEquals(double d, double balanceAfter, double e) {
		// TODO Auto-generated method stub
		
	}
 
	public static void main(String[] args) {
        testLoadData();
        testDeposits();
        testAddTransactionWithdrawals();
    }
}

