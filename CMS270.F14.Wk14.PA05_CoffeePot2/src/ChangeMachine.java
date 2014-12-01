import java.util.Scanner;

/*
 *  ChangeMachine.java
 *  
 *  Scot Andre      sandre@rollins.edu
 *  Juan Recinos    jrecinos@rollins.edu
 *  Katie Shiver    kshiver@rollins.edu
 *  Patrick Skelly  pskelly@rollins.edu
 *  
 *  Coffee Pot Project
 *  Dr. Carrington
 *  CMS270.H1
 *  Fall 2014
 *
 */

public class ChangeMachine {
	private int nickels = 0;
	private int dimes = 0;
	private int quarters = 0;
	private int dollars = 0;
	private int cashBalance = 0;
	private int rCardBalance = 0;
	private int moneyInserted = 0;
	private int totalPurchase = 0;
	private boolean payWithRCard = false;

	public ChangeMachine() {
		nickels = 40;
		dimes = 50;
		quarters = 40;
		dollars = 20;
		cashBalance = nickels * 5 + dimes * 10 + quarters * 25 + dollars * 100;
	}

	public void selectPaymentType() {
		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
		while (choice != 1 && choice != 2) {
			System.out.println("How would you like to pay for your selection?");
			System.out.println("1. Cash");
			System.out.println("2. rCard");
			choice = keyboard.nextInt();
		}
		if (choice == 1) {
			setPaymentToCash();
		} else {
			setPaymentToRCard();
		}
	}

	public void setPaymentToRCard() {
		payWithRCard = true;
	}

	public void setPaymentToCash() {
		payWithRCard = false;
	}

	/**
	 * @return true if rCard payment type is selected, false if otherwise
	 */
	public boolean getPaymentType() {
		if (payWithRCard) {
			return true;
		} else {
			return false;
		}
	}

	public void insertNickel() {
		moneyInserted += 5;
		nickels++;
	}

	public void insertDime() {
		moneyInserted += 10;
		dimes++;
	}

	public void insertQuarter() {
		moneyInserted += 25;
		quarters++;
	}

	public void insertDollar() {
		moneyInserted += 100;
		dollars++;
	}

	public void checkOut() {
		if (payWithRCard) {
			rCardBalance += totalPurchase;
		} else {
			moneyInserted -= totalPurchase;
			makeChange(moneyInserted);
			cashBalance += totalPurchase;
			totalPurchase = 0;
		}
	}

	public void returnNickel(int numToReturn) {
		moneyInserted -= numToReturn * 5;
		nickels--;
	}

	public void returnDime(int numToReturn) {
		moneyInserted -= numToReturn * 10;
		dimes--;
	}

	public void returnQuarters(int numToReturn) {
		moneyInserted -= numToReturn * 25;
		quarters--;
	}

	public void returnDollars(int numToReturn) {
		moneyInserted -= numToReturn * 100;
		dollars--;
	}

	public int checkInsertedMoney() {
		return moneyInserted;
	}

	public boolean hasPaidEnough(int totalBill) {
		if (payWithRCard || moneyInserted >= totalBill) {
			return true;
		} else {
			return false;
		}
	}

	public int getTotalBankBalance() {
		return (cashBalance + rCardBalance);
	}

	public int getRCardBalance() {
		return rCardBalance;
	}

	public int getCashBalance() {
		return cashBalance;
	}

	public int getTotalPurchase() {
		return totalPurchase;
	}

	public void makeChange(int change) {
		int balance = change;
		int dollarsReturned = 0;
		int quartersReturned = 0;
		int dimesReturned = 0;
		int nickelsReturned = 0;

		// calculate number of dollars to return
		// out of dollars - return quarters instead
		dollarsReturned = change / 100;
		if (dollars <= dollarsReturned) {
			balance -= dollars * 100;
			returnDollars(dollars);
		} else {
			balance -= dollarsReturned * 100;
			returnDollars(dollarsReturned);
		}

		// calculate number of quarters to return
		// out of quarters - return dimes and nickels instead
		quartersReturned = balance / 25;
		if (quarters <= quartersReturned) {
			balance -= quarters * 25;
			returnQuarters(quarters);
		} else {
			balance -= quartersReturned * 25;
			returnQuarters(quartersReturned);
		}

		// calculate number of dimes to return
		// out of dimes - return nickels instead
		dimesReturned = balance / 10;
		if (dimes <= dimesReturned) {
			balance -= dimes * 10;
			returnDime(dimes);
		} else {
			balance -= dimesReturned * 10;
			returnDime(dimesReturned);
		}

		// calculate number of nickels to return
		nickelsReturned = balance / 5;
		if (nickelsReturned > nickels) {
			System.out.println("Sorry, I can't return that much!");
			returnNickel(nickels);
		} else {
			returnNickel(nickelsReturned);
		}
	}
}
