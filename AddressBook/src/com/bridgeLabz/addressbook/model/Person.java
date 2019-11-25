/******************************************************************************

 *  Purpose: ADDRESS BOOK PROBLEM
 *  
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   18-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgeLabz.addressbook.model;

public class Person {

	/*
	 * PRIVATE INSTANCE VARIABLE
	 */
	private String FirstName;
	private String LastName;
	private long phoneNumber;
	private String city;
	private String state;
	private int zip;

	/*
	 * GETTER SETTER
	 */
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/*
	 * TO STRING METHOD
	 */
	@Override
	public String toString() {
		return "Person [FirstName=" + FirstName + ", LastName=" + LastName + ", phoneNumber=" + phoneNumber + ", city="
				+ city + ", state=" + state + ", zip=" + zip + "]";
	}

}
