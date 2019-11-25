/******************************************************************************

 *  Purpose: Address Book Main class
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   20-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgeLabz.addressbook.controller;

/*
 * IMPORT STATEMENTS
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.bridgeLabz.addressbook.model.Person;
import com.bridgeLabz.addressbook.service.AddressBookInf;
import com.bridgeLabz.addressbook.service.AddressBookNameComparator;
import com.bridgeLabz.addressbook.service.AddressBookZipComparator;
import com.bridgeLabz.addressbook.service.serviceImplementation.AddressBookImplementation;
import com.bridgeLabz.addressbook.utility.AddressBookUtility;

public class ControllerMain {
	public static void main(String[] args) throws IOException, ParseException {
		AddressBookImplementation addressImp = new AddressBookImplementation();
		AddressBookUtility utility = new AddressBookUtility();

		AddressBookNameComparator addressNameComparator = new AddressBookNameComparator();
		AddressBookZipComparator addressBookZipComparator = new AddressBookZipComparator();

		Person personOne = new Person();
		Person personTwo = new Person();

		int choice = 0;
		int choiceOne = 0;

		while (choice == 0) {
			System.out.println(
					"Address Book\n" + "------------------\n " + "1. Create new Address Book And Open Address Book\n "
							+ "2. Save Address Book\n " + "3. Close Address Book\n");
			System.out.println("Enter the Choice\n");
			String userFile = "";
			choice = utility.inputIntegerOne();
			switch (choice) {
			case 1:
				int temp = 0;
				if (temp == 0) {
					addressImp.create();
					int i = 0;
					while (i == 0) {
						System.out.println("___________________\n" + "|       Menu       |\n" + "|      ------      |\n"
								+ "| 1. Add           |\n" + "| 2. Edit          |\n" + "| 3. Remove        |\n"
								+ "| 4. Sort By Name  |\n" + "| 5. Sort By Zip   |\n" + "| 6. Display       |\n"
								+ "| 7. Exit          |\n" + "|__________________|");
						System.out.println("Enter the Menu Choice");
						choiceOne = AddressBookUtility.inputInteger();
						switch (choiceOne) {

						case 1:
							AddressBookImplementation.AddMore();
							break;
						case 2:
							addressImp.edit();
							break;
						case 3:
							addressImp.delete();
							break;
						case 4:

							addressNameComparator.compare(personOne, personTwo);
							break;
						case 5:
							addressBookZipComparator.compare(personOne, personTwo);
							break;
						case 6:
							addressBookZipComparator.compare(personOne, personTwo);
							break;

						case 7:
							System.out.println("Traversing to Main Menu");
							i = 1;
							break;

						default:
							System.out.println("Wrong data recieved\n");
							i = 1;
							break;
						}
					}
				} else {
					System.out.println("Entered filename doesn't exist");
				}
				break;
			case 2:
				addressImp.save();
				break;
			case 3:
				System.out.println("Closing Address Book...!\nThank You");
				choice = 1;
				break;
			default:
				System.out.println("Sorry, Something went wrong...!\n" + "Address Book closed\nThank You\n");
				choice = 0;
				break;
			}
		}
	}
}
