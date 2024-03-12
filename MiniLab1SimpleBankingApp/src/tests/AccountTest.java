package tests;

import Model.Account;
import java.util.Date;

public class AccountTest {

	public static void main(String[] args) {
		Date today = new Date();
		today.setHours(0);
		Account testAccount = new Account("40374765", "quigley", "savings", today);
		
		System.out.println(testAccount);
	}
}
