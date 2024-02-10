package tests;

import app.SimpleBankingApp;
import Utils.TestUtils;

public class SimpleBankingAppTest {

    public static void testLoadData() {
        SimpleBankingApp.loadUserData();
        SimpleBankingApp.loadAccountData();

        // Verify user and account data is loaded correctly
        if (SimpleBankingApp.users.size() == 3)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadUserData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadUserData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

        if (SimpleBankingApp.accounts.size() == 4)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadAccountData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadAccountData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
    }

    public static void testDeposits() {
        double balanceBefore = SimpleBankingApp.getBalance("5495-1234");
        double depositAmount = 50.21;

        SimpleBankingApp.addTransaction("5495-1234", depositAmount);
        double balanceAfter = SimpleBankingApp.getBalance("5495-1234");

        assert balanceBefore + depositAmount == balanceAfter;
        if (balanceBefore + depositAmount == balanceAfter)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
        else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED XXX: balanceBefore + depositAmount != balanceAfter");
            System.out.format("testDeposits: balanceBefore = %.2f ; depositAmount = %.2f ; balanceAfter = %.2f %s\n",
                    balanceBefore, depositAmount, balanceAfter, TestUtils.TEXT_COLOR_RESET);
        }

        // Teardown
        SimpleBankingApp.addTransaction("5495-1234", -depositAmount);
    }

    public static void testAddTransactionWithdrawals() {
        double balanceBefore = SimpleBankingApp.getBalance("5495-1234");
        double withdrawalAmount = 30.0;

        SimpleBankingApp.addTransaction("5495-1234", -withdrawalAmount);

        double balanceAfter = SimpleBankingApp.getBalance("5495-1234");
        assert balanceBefore - withdrawalAmount == balanceAfter;
        if (balanceBefore - withdrawalAmount == balanceAfter) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "testAddTransactionWithdrawals: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "testAddTransactionWithdrawals: TC1 FAILED XXX: balanceBefore - withdrawalAmount != balanceAfter");
            System.out.format("testAddTransactionWithdrawals: balanceBefore = %.2f ; withdrawalAmount = %.2f ; balanceAfter = %.2f %s\n",
                    balanceBefore, withdrawalAmount, balanceAfter, TestUtils.TEXT_COLOR_RESET);
        }

        // Teardown
        SimpleBankingApp.addTransaction("5495-1234", withdrawalAmount); // Undo withdrawal
    }

    public static void main(String[] args) {
        testLoadData();
        testDeposits();
        testAddTransactionWithdrawals();
    }
}
