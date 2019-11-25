/******************************************************************************

 *  Purpose: Stock Account Management Main Class
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   20-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgelabz.stockaccountmanagement.controller;

/*
 * IMPORT STATEMENT
 */
import java.util.Date;

import com.bridgelabz.stockaccountmanagement.service.serviceimplementation.StockImplementation;
import com.bridgelabz.stockaccountmanagement.utility.StockUtility;

public class ContollerMain {
	public static void main(String[] args) throws Exception {

		StockImplementation stockAccountImp = new StockImplementation();// Creating Object Of StockImplementation class
		Date date = new Date();// creating Date class Object
		System.out.println(date.toString());
		StockImplementation stockAccount = new StockImplementation();
		String file = "Company";
		String name;
		int count = 0;
		int choice = 0;
		while (choice != 3) {
			System.out.println("________________________________\n" + "|         Stock Manager          |\n"
					+ "|        ---------------         |\n" + "|   1. Open Existing Account     |\n"
					+ "|   2. Add & Remove Company      |\n" + "|   3. Exit                      |\n"
					+ "|________________________________|\n");
			count = StockUtility.inputInteger();

			switch (count) {
			case 1:
				stockAccountImp.close();
				int choiceOne = 0;
				System.out.println("Enter the name of account");
				String NewStockName = StockUtility.inputString();
				StockImplementation.read(NewStockName);

				choiceOne = 0;
				while (choiceOne != 6) {
					System.out.println("______________________\n" + "|Menu                 |\n"
							+ "|---------            |\n" + "|1. Add Amount        |\n" + "|2. Buy Shares        |\n"
							+ "|3. Sell Shares       |\n" + "|4. Save Account      |\n" + "|5. Print Report      |\n"
							+ "|6. Exit              |\n" + "|_____________________|");
					System.out.println("Enter your choice");

					int ch = StockUtility.inputInteger();

					switch (ch) {
					case 1:
						System.out.println("Enter the amount");
						boolean result = stockAccountImp.addMoney();
						if (result == false) {
							choiceOne++;
						}
						break;
					case 2:
						stockAccount.buy(NewStockName);
						break;
					case 3:
						stockAccount.sell(NewStockName);
						break;
					case 4:
						stockAccount.save(file, NewStockName);
						break;
					case 5:
						int loopDisplay = 0;
						while (loopDisplay != 4) {
							System.out.println("_______________________________________\n"
									+ "|            Display Menu              |\n"
									+ "|           --------------             |\n"
									+ "|  1. To display company               |\n"
									+ "|  2. To display current Customer      |\n"
									+ "|  3. To display Transaction           |\n"
									+ "|  4. Exit                             |\n"
									+ "|______________________________________|\n");
							int choiceDisplay = StockUtility.inputInteger();
							switch (choiceDisplay) {
							case 1:
								stockAccount.printReport();
								break;
							case 2:
								stockAccount.printCustomer();
								break;
							case 3:
								stockAccount.printTransaction();
								break;
							case 4:
								loopDisplay = 4;
								System.out.println("Display menu closed");
								break;
							default:
								loopDisplay = 0;
								System.out.println("Something went wrong\nDisplay menu closed");
								break;
							}
						}

						break;
					case 6:
						System.out.println("Menu closed...!!!");
						choiceOne = 6;
						break;
					default:
						System.out.println("Something went wrong\nMenu closed");
						choiceOne = 0;
						break;
					}
				}
				break;
			case 2:
				stockAccount.addRemoveCompany();
				break;
			case 3:
				System.out.println("System closed\nThank You");
				choice = 3;
				break;
			default:
				System.out.println("Something went wrong\nThank You");
				choice = 0;
				break;
			}
		}
	}
}
