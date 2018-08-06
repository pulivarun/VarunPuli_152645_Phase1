package com.cg.WalletApplication.pl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.WalletApplication.Exception.BankException;
import com.cg.WalletApplication.Exception.IBankException;
import com.cg.WalletApplication.service.IWalletService;
import com.cg.WalletApplication.service.WalletServiceImpl;

public class WalletUi {
	static IWalletService iWalletService = new WalletServiceImpl();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int choice;
		try {
			do {
				chooseOperation();
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					addCustomer();

					break;
				case 2:

					showBalance();
					break;
				case 3:
					depositAmount();
					break;
				case 4:
					withdrawAmount();
					break;
				case 5:
					fundTransfer();
					break;
				case 6:
					printTransactions();

					break;
				case 7:
					scanner.close();
					System.exit(0);
					break;
				default:
					System.out.println("Enter your choice correctly");
					break;

				}
			} while (choice != 7);
		} catch (InputMismatchException exception) {
			try {
				throw new BankException(IBankException.inputMismatch);
			} catch (BankException e) {
				System.out.println(e.getMessage());
				scanner.next();
			}
		}
	}

	private static void chooseOperation() {
		System.out.println("Enter 1 to Create Account");
		System.out.println("Enter 2 to show balance");
		System.out.println("Enter 3 to deposit amount");
		System.out.println("Enter 4 to withdraw amount");
		System.out.println("Enter 5 for fund transfer");
		System.out.println("Enter 6 to print your transactions");
		System.out.println("Enter 7 to exit the application");

	}

	private static void addCustomer() {
		
	}

	private static void showBalance() {
		
	}

	private static void depositAmount() {
		

	}

	private static void withdrawAmount() {
		

	}

	private static void printTransactions() {
		

	}

	private static void fundTransfer() {
	}

}
