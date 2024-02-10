package tests;

import java.util.Date;

import Model.Account;

public class AccountTest {
	public static void main(String[] args) {
	        // Creating a Date object for the account opening date
	        Date account_opening_date = new Date(); // This will use the current date

	        // Creating an instance of the Account class
	        Account testAccount = new Account("12345678", "Orlaith", "Standard", account_opening_date);

	        // Printing the account details
	        System.out.println(testAccount);
	    }
	}