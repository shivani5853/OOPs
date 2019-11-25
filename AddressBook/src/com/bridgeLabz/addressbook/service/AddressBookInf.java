/******************************************************************************

 *  Purpose: Create a JSON file having Inventory Details for Rice, Pulses and Wheats with properties name, weight, price per kg. 

 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   18-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgeLabz.addressbook.service;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.bridgeLabz.addressbook.model.Person;

public interface AddressBookInf {

	public void addList() throws ParseException, IOException;

	public void delete();

	public void edit();

	public void sortByFirstName();

	public void sortByLastName();

	public void sortByZip();

	public void sortByEmail();

	public void display();
	
	void create() throws IOException;

	void save();

}
