package tests;

import java.util.Date;
import Model.Transaction;

public class TransactionTest {
	
	public static void main(String[] args) {
		Date today = new Date();
		Transaction testTransaction = new Transaction("40282837", 60.00, today);
		
		System.out.println(testTransaction);
	}
}
