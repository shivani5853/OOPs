/******************************************************************************

 *  Purpose: Determines Stock Account Management
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   26-10-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgelabz.stockaccountmanagement.service.serviceimplementation;

/*
 * IMPORT STATEMENTS
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bridgelabz.stockaccountmanagement.model.CompanyDetails;
import com.bridgelabz.stockaccountmanagement.model.StockDetails;
import com.bridgelabz.stockaccountmanagement.model.StockTrader;
import com.bridgelabz.stockaccountmanagement.service.StockAccount;
import com.bridgelabz.stockaccountmanagement.utility.LinkedList;
import com.bridgelabz.stockaccountmanagement.utility.Stack;
import com.bridgelabz.stockaccountmanagement.utility.StockUtility;

public class StockImplementation implements StockAccount {
	StockUtility utility = new StockUtility();
	long share;
	Date date = new Date();

	public static List<CompanyDetails> companyList = new ArrayList<>();
	public static List<StockTrader> traderList = new ArrayList<>();
	public static List<StockDetails> stockDetailsList = new ArrayList<>();

	long currentAmount;

	/*
	 * Purpose : Finding total value of share
	 */
	public long valueOf(List<CompanyDetails> company) {
		long value = totalValuesOfShares(company);
		return value;
	}

	public long totalValuesOfShares(List<CompanyDetails> company) {
		return 0;
	}

	/*
	 * Purpose : Buy shares from the user from particular company.
	 */
	public void buy(String name) {
		System.out.println("Enter the amount");
		addMoney();
		System.out.println("Available Balanced" + currentAmount);
		StockTrader stocktrader = new StockTrader();
		CompanyDetails companyDetails = new CompanyDetails();
		long amountOne = currentAmount;
		if (amountOne > 0) {
			System.out.println("Enter the Name Of the Stock");
			String stockName = utility.inputString();

			companyDetails.setCompanyName(stockName);

			StockTrader trader = new StockTrader();

			for (CompanyDetails companyDetailsTwo : companyList) {

				if (stockName.equalsIgnoreCase(companyDetails.getCompanyName())) {
					System.out.println("Enter How many quantity you want");
					long quantity = utility.inputLong();
					long shareValue = companyDetails.getPricePerShares() * quantity;
					if (shareValue < amountOne) {
						amountOne = amountOne - shareValue;
						stocktrader.setCash(amountOne);

					} else if (shareValue == amountOne) {
						System.out.println("Please Update Amount\nAmount Not same as Buying Price");
					} else {
						System.out.println("Less Amount Available");
					}
				} else {
					System.out.println("Company Not present");
				}
			}
		}
		System.out.println(currentAmount);
	}

//		System.out.println("Enter the symbol");
//		String symbol = utility.inputString();
//		System.out.println("Enter the Amount");
//		long amount = utility.inputInteger();
//		
//		share = 0;
//		StockDetails stockDetails=new StockDetails();
//
//		int symbolCheck = 0;
//		int amountSmall = 0;
//		for (CompanyDetails company : companyList) {
//			if (company.getCompanyName().equals(symbol)) {
//				if (amount >= company.getPricePerShares()) {
//					amountSmall++;
//					if (!traderList.isEmpty()) {
//						for (StockTrader c : traderList)
//						{
//							currentAmount=c.getCash();
//							
//							if (c.getSymbole().equals(symbol)) {
//								amountSmall++;
//								symbolCheck++;
//								c.setCash(c.getCash() - amount);
//								//customerLoop.setSymbol(symbol);
//								c.setShraresQuantity(c.getShraresQuantity());
//							}
//						}
//					}
//					if(symbolCheck==0) {
//						amountSmall++;
//						StockTrader trader=new StockTrader();
//						trader.setCash(currentAmount - amount);
//						trader.setSymbole(symbol);
//						trader.setShraresQuantity(amount / company.getPricePerShares());
//						companyList.add(trader);
//					}
//					LinkedQueue<String> queue = new LinkedQueue<String>();
//					shareIncreaseDecrease = amount / c.getPricePerShares();
//					c.setSharesAvailable(c.getSharesAvailable() - shareIncreaseDecrease);
//					queue.add(date.toString());
//					System.out.println("\n\t\t\tTransaction Started");
//					transaction.setBuySell("Buy");
//					transaction.setName(name);
//					transaction.setSymbol(symbol);
//					transaction.setDate(date.toString());
//					transactionList.add(transaction);
//					queue.remove();
//					System.out.println("\n\t\t\tTransaction Stopped");
//				}
//			}
//		}
//		if (amountSmall == 0) {
//			System.out.println("\n\t\t\tYour Balance is low\n\t\t\tPlease Add money");
//		}

	/*
	 * Purpose : Sell the shares that the customer has.
	 */
	public void sell(String name) {
//		System.out.println("\n\t\t\tEnter the symbol");
//		String symbol = utility.inputString();
//		System.out.println("\n\t\t\tEnter the Amount");
//		long amount = utility.inputInteger();
//		Transaction transaction = new Transaction();
//		shareIncreaseDecrease = 0;
//		for (Customer customer : customerList) {
//			if (customer.getSymbol().equals(symbol)) {
//				if (customer.getAmount() >= amount) {
//					for (Company company : companyList) {
//						if (company.getCompany().equals(symbol)) {
//							company.setSharesAvailable(
//									company.getSharesAvailable() + (amount / company.getPricePerShare()));
//							customer.setAmount(customer.getAmount() + amount);
//							customer.setShares(customer.getShares() - (amount / company.getPricePerShare()));
//							LinkedQueue<String> queue = new LinkedQueue<String>();
//							queue.add(date.toString());
//							System.out.println("\n\t\t\tTransaction Started");
//							transaction.setBuySell("Sell");
//							transaction.setName(name);
//							transaction.setSymbol(symbol);
//							transaction.setDate(date.toString());
//							transactionList.add(transaction);
//							queue.remove();
//							System.out.println("\n\t\t\tTransaction Stopped");
//						}
//					}
//				} else {
//					System.out.println("\n\t\t\tEntered amount is greater than your balance amount");
//				}
//			} else {
//				System.out.println("\n\t\t\tNo such company Found");
//			}
//		}
	}

	/*
	 * Purpose : Displays the List of Companies
	 */
	public void printReport() {
		for (CompanyDetails c : companyList) {
			System.out.println(c.toString());
		}
	}

	/*
	 * Purpose : Creates file for n user
	 * 
	 * @throws IOException
	 */
	public void create() throws IOException {
		StockUtility utility = new StockUtility();
		System.out.println("New Account Name");
		String newFile = utility.inputString();
		File file = new File("jsonstock/" + newFile + ".txt");
		if (file.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}
	}

	/*
	 * Method to check Address
	 */
	public static boolean checkAddress(String newFileName) {
		File f = new File("Stock/");
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				if (file.getName().equals(newFileName + ".txt")) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * 
	 * Purpose : Saves List in file
	 * 
	 * @param file is the name of file in which data is to be saved
	 * 
	 * @param T is the list in which data is there
	 */
	public <T> void saveInFile(String file, List<T> T) {
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter("jsonstock/" + file));
			br.write(file);
			System.out.println("Saved");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Purpose : Reads data from file
	 * 
	 * @param file is the name of the file from where data is read
	 * 
	 * @throws Exception
	 */
	public static void read(String NewStockName) throws Exception {
		File fileOne = new File("jsonstock/" + NewStockName);
		if (fileOne.equals(NewStockName)) {
			System.out.println("Account already exists");
		} else if (fileOne.createNewFile()) {
			System.out.println("File is created Sucessfully");
		} else {
			System.out.println("File already exists");
		}

	}

	/*
	 * Displays customer list
	 */
	public void printCustomer() {
		for (StockTrader trader : traderList) {
			System.out.println(trader.toString());
		}
		long amount = 0;
		for (StockTrader traderOne : traderList) {
			amount = traderOne.getCash();
		}
		System.out.println("Balance : " + amount);
	}

	/*
	 * Purpose : Displays transaction list
	 */
	public void printTransaction() {
		Stack<String> stack = new Stack<String>();
		for (StockDetails details : stockDetailsList) {
			stack.push(details.toString());
		}
		stack.display();
	}

	/*
	 * Purpose : Adds money in User Account
	 * 
	 * @return
	 */
	public boolean addMoney() {
		currentAmount = StockUtility.inputInteger();
		boolean result = StockUtility.checkNumber(currentAmount);
		if (result) {
			System.out.println("Amount Added SucessFully\nAvailable Balance " + currentAmount);
			return true;
		}
		return false;
	}

	/*
	 * Purpose : Save menu for different list
	 */
	@Override
	public void save(String file, String name) {
		int loopSave = 0;
		while (loopSave != 4) {
			System.out.println("_________________________\n" + "|       Save Menu        |\n"
					+ "|      -----------       |\n" + "|  1. Save Company       |\n" + "|  2. Save User          |\n"
					+ "|  3. Save Transaction   |\n" + "|  4. Exit               |\n" + "|________________________|\n");
			int choiceSave = utility.inputIntegerOne();
			switch (choiceSave) {
			case 1:
				saveInFile(file, companyList);
				break;
			case 2:
				saveInFile(name, traderList);
				break;
			case 3:
				saveInFile("Transaction", traderList);
				break;
			case 4:
				loopSave = 4;
				System.out.println("Save Menu closed\n");
				break;
			default:
				loopSave = 0;
				System.out.println("Something went wrong\nSave Menu closed\n");
				break;
			}
		}
	}

	/*
	 * Purpose : Add or remove company from company list
	 */
	public void addRemoveCompany() {
		LinkedList<CompanyDetails> list = new LinkedList<CompanyDetails>();

		System.out.println("Enter ID");
		String id = StockUtility.inputString();
		System.out.println("Enter password");
		String password = StockUtility.inputString();
		if (id.equals("123") && password.equals("123")) {

			for (CompanyDetails company : companyList) {
				list.add(company);
			}
			list.display();
		} else {
			System.out.println("Incorrect Id/Passwprd");
			return;
		}
		int loopAdd = 0;
		while (loopAdd == 0) {
			System.out.println("______________________________\n" + "|  Company Add & Remove Menu  |\n"
					+ "| --------------------------- |\n" + "|         1. Add              |\n"
					+ "|         2. Remove           |\n" + "|         3. Save             |\n"
					+ "|         4. Exit             |\n" + "|_____________________________|\n");
			int choice = StockUtility.inputInteger();
			switch (choice) {
			case 1:
				CompanyDetails company = new CompanyDetails();

				System.out.println("Enter the company name");
				String name = StockUtility.inputString();
				company.setCompanyName(name);

				System.out.println("Enter Share Available");
				long shares = StockUtility.inputInteger();
				company.setShares(shares);

				System.out.println("Enter price per share");
				long price = utility.inputInteger();
				company.setPricePerShares(price);

				list.add(company);
				companyList.add(company);
				System.out.println("\n");
				list.display();
				break;
			case 2:
				System.out.println("Enter the name of company to remove");
				int i = 1;
				for (CompanyDetails company2 : companyList) {
					System.out.println(" " + i + " for " + company2.getCompanyName());
					i++;
				}
				System.out.println("Enter your choice to remove company");
				int removeChoice = utility.inputInteger();

				companyList.remove(removeChoice - 1);
				list.display();
				break;
			case 3:
				saveInFile("Company", companyList);
				break;
			case 4:
				loopAdd = 1;
				System.out.println("Add & Remove menu closed");
				break;
			default:
				loopAdd = 1;
				System.out.println("Something went wrong\nAdd & Remove menu closed");
				break;
			}
		}
	}

	/*
	 * Close
	 */
	public void close() {
		traderList.clear();
	}

	@Override
	public long value(List<CompanyDetails> company) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}
