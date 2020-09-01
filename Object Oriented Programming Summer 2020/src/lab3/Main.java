package lab3;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		HolidayAccount[] accounts;
		int i, size;
		String name;
		
		size = 4;
		
		//construct the accounts
		accounts = new HolidayAccount[size];
		for (i = accounts.length-1; i >= 0; i--) {
			name = "user" + i;
			accounts[i] = new HolidayAccount(name);
		}
		
		//print the accounts in the original order
		for (i = 0; i < accounts.length; i++) {
			System.out.println(accounts[i].getAccountID() + "\t" + accounts[i].getHolder());
		}
		
		System.out.println("\n\n");
		
		//sort the accounts
		Arrays.sort(accounts);
		
		//print the accounts in the sorted order
		for (i = 0; i < accounts.length; i++) {
			System.out.println(accounts[i].getAccountID() + "\t" + accounts[i].getHolder());
		}
	}
	
}
