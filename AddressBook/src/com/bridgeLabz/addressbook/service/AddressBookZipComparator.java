/******************************************************************************
 *  Purpose: Address Book Problem
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   19-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgeLabz.addressbook.service;

import java.util.Comparator;

import com.bridgeLabz.addressbook.model.Person;

public class AddressBookZipComparator implements Comparator<Person> {

	@Override
	public int compare(Person personOne, Person personTwo) {
		if (personOne.getZip() == personTwo.getZip())
			return 0;
		else {
			if (personOne.getZip() > personTwo.getZip()) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}
