package lab3;

import java.text.*;

@SuppressWarnings("rawtypes")
public class HolidayAccount implements Comparable{

	private double balance;
	private final int accountNumber;
	private NumberFormat accountFormatter;
	private String holder;
	
	private static int nextAccountNumber;
	
	//constuctor with name of account holder
	public HolidayAccount(String holder) {
		this.holder = holder;
		
		accountNumber = nextAccountNumber;
		nextAccountNumber++;
		
		accountFormatter = NumberFormat.getInstance();
		accountFormatter.setMinimumIntegerDigits(10);
		accountFormatter.setMaximumIntegerDigits(10);
		accountFormatter.setGroupingUsed(false);
		
		setBalance(0.0);
	}
	
	//Compare the account number on this account to the account number on a given account
	@Override
	public int compareTo(Object other) {
		int relation;
		HolidayAccount otherAcc = (HolidayAccount) other;
		
		relation = 0;
		if (this.accountNumber < otherAcc.accountNumber)
			relation = -1;
		else if (this.accountNumber > otherAcc.accountNumber)
			relation = 1;
		
		return relation;
	}
	
	//deposit money into this account
	public String deposit(double amount) {
		double temp;
		NumberFormat moneyFormatter;
		String message;
		
		temp = getBalance();
		message = "";
		if (amount <= 0.0)
			message = "Deposits should be positive";
		else {
			moneyFormatter = NumberFormat.getCurrencyInstance();
			message = "Deposited " + moneyFormatter.format(amount);
			temp += amount;
		}
		
		setBalance(temp);
		
		return message;
	}
	
	
	//get ID associated with this account
	public String getAccountID() {
		String s;
		
		s = "HA-" + getAccountNumber();
		
		return s;
	}
	
	//get the number associated with this account
	public String getAccountNumber() {
		String s;
		
		s = accountFormatter.format(accountNumber);
		
		return s;
	}
	
	
	//get the current balance
	public double getBalance() {
		return balance;
	}
	
	//get a textual description of the current balance
	public String getBalanceMessage() {
		NumberFormat moneyFormatter;
		String s;
		
		moneyFormatter = NumberFormat.getCurrencyInstance();
		s = "Balance: " + moneyFormatter.format(getBalance());
		
		return s;
	}
	
	//get the name of the account holder
	public String getHolder() {
		return holder;
	}
	
	//set the current balance
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
