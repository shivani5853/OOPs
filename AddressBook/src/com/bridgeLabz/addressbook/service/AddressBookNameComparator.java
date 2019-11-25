/******************************************************************************

 *  Purpose: Address Book 
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   20-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgeLabz.addressbook.service;

/*
 * IMPORT STATEMENTS
 */
import java.util.Comparator;

import com.bridgeLabz.addressbook.model.Person;

public class AddressBookNameComparator implements Comparator<Person> {

	public int compare(Person personOne, Person personTwo) {

		if (personOne.getFirstName().equals(personTwo.getFirstName()))
			return 0;
		else {
			if (personOne.getFirstName().compareTo(personTwo.getFirstName()) > 0) {
				return 1;
			} else {
				return -1;
			}
		}

	}

}