package tests;

import java.util.Date;

import Model.Transaction;

public class TransactionTest {
		public static void main(String[] args) {
		        // Creating a Date object for the account opening date
		        Date transaction_date = new Date(); // This will use the current date

		        // Creating an instance of the Account class
		        Transaction testTransaction = new Transaction("12345678", 50.00, transaction_date);

		        // Printing the account details
		        System.out.println(testTransaction);
		    }
		}
