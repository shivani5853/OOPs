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
package com.bridgeLabz.addressbook.service.serviceImplementation;

/*
 * IMPORT STATEMENTS
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeLabz.addressbook.model.Person;
import com.bridgeLabz.addressbook.repository.AddressBookJSON;
import com.bridgeLabz.addressbook.service.AddressBookInf;
import com.bridgeLabz.addressbook.utility.AddressBookUtility;

public class AddressBookImplementation implements AddressBookInf {

	private static final Person Person = null;

	static List<Person> personList = new ArrayList<Person>();

	JSONObject jsonObject = new JSONObject();
	static AddressBookUtility utility = new AddressBookUtility();

//	public static void main(String[] args) throws ParseException, IOException {
//		AddressBookImplementation a = new AddressBookImplementation();
//		a.addPerson();
//		a.add();
//
//	}

	/*
	 * Add Person
	 */
	public static Person addPerson() {

		Person person = new Person();

		System.out.println("Enter person Information\n");
		System.out.println("Enter the First name:");
		person.setFirstName(utility.inputStringLine());

		System.out.println("Enter the LastName:");
		person.setLastName(utility.inputStringLine());

		System.out.println("Enter Phone Number:");
		person.setPhoneNumber(utility.inputLong());

		System.out.println("Enter City:");
		person.setCity(utility.inputString());

		System.out.println("Enter State:");
		person.setState(utility.inputString());

		System.out.println("Enter ZIP/PIN Code:");
		person.setZip(utility.inputInteger());

		return person;
	}

	/*
	 * method to add person in the list
	 */
	public List<Person> add() throws ParseException, IOException {
		try {
			AddMore();
		} catch (Exception e) {
		}
		personList.add(AddMore());
		for (Person P : personList) {
			System.out.println(P.toString());
		}
		return personList;
	}

	/*
	 * Method to add person in the person list
	 */
	@Override
	public void addList() throws ParseException, IOException {
		AddressBookJSON.writeJson();

	}

	/*
	 * Method to add another Person
	 */
	public static Person AddMore() throws ParseException, IOException {
		try (FileReader reader = new FileReader("jsonFolder/a.json")) {
			JSONArray jsonArrayNew = new JSONArray();
			JSONParser ObjectParser = new JSONParser();
			JSONArray jsonArrayOld = new JSONArray();

			Object obj = ObjectParser.parse(reader);
			jsonArrayOld.add(obj);

			AddressBookJSON.writeJson();
			try (FileReader readerOne = new FileReader("jsonFolder/a.json")) {
				Object objOne = ObjectParser.parse(readerOne);
				jsonArrayNew.add(objOne);

				jsonArrayNew.add(jsonArrayOld);
				FileWriter file = new FileWriter("jsonFolder/a.json");
				file.write(jsonArrayNew.toJSONString());
				file.flush();

				System.out.println("Data added Sucessfully!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Person;
	}

	/*
	 * Method to delete the information of the person
	 */
	@Override
	public void delete() {
		System.out.println("Enter the name whose data to be deleted");
		String userInputName = utility.inputStringLine();
		int count = 0;
		List<Person> removelist = new ArrayList<Person>();
		for (Person personName : personList) {
			if (userInputName.equalsIgnoreCase(personName.getFirstName())) {
				System.out.println("Data Removed SucessFully");
				removelist.add(personName);
				count++;
			}
		}
		personList.removeAll(removelist);
		if (count == 0) {
			System.out.println("No Such Result Found!!!");
		}

	}

	/*
	 * Method to Edit information of the person
	 */
	@Override
	public void edit() {
		int count = 0;
		System.out.println("Enter first name");
		String firstName = utility.inputString();
		JSONArray string = AddressBookJSON.readDemo();
		personList = string;
		System.out.println(personList);
		for (Person P : personList) {
			if (firstName.equals(P.getFirstName())) {
				count++;
				System.out.println("1. To edit Address\n2. To edit Phone Number\n");
				int editChoice = utility.inputInteger();
				switch (editChoice) {
				case 1:
					editAddressPhone(P, 1);
					break;
				case 2:
					editAddressPhone(P, 2);
					break;
				default:
					System.out.println("Something went wrong\n" + "Try again later");
				}
			}
		}
	}

	public void editAddressPhone(Person p, int i) {

	}

	public void editFirstName(Person person, int i) {
		System.out.println("Enter the Old First name");
		String oldFirstName = utility.inputString();
		System.out.println("Enter the new FirstName");
		String newFirstName = utility.inputString();
		if (oldFirstName.equalsIgnoreCase(person.getFirstName())) {
			if (oldFirstName.equalsIgnoreCase(newFirstName)) {
				System.out.println("Your Old First Name and New First Name is Same!!!!");
			} else {
				String oldName = person.getFirstName();
				oldName = newFirstName;
				person.setFirstName(oldName);
				System.out.println("First Name Change SucessFully " + "\nNew First Name " + person.getFirstName());

			}
		}
	}

	/*
	 * Method to sort the person information by First name
	 */
	@Override
	public void sortByFirstName() {
		// TODO Auto-generated method stub

	}

	/*
	 * Method to sort the Person information by Last Name
	 */
	@Override
	public void sortByLastName() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sortByEmail() {

	}

	/*
	 * method to display records
	 */
	@Override
	public void display() {

		for (Person person : personList) {
			System.out.println(person);
		}
	}

	/*
	 * Method to write in the Json File
	 */
	public static void write() throws ParseException, IOException {
		AddressBookJSON addressJson = new AddressBookJSON();

		AddressBookJSON.writeJson();

	}

	/*
	 * Method to read the Information from File
	 */
	public static JSONArray read() throws ParseException {
		JSONParser ObjectParser = new JSONParser();
		JSONArray string = AddressBookJSON.readDemo();
		personList = string;
		try (FileReader reader = new FileReader("jsonFolder/a.json")) {
			// Read JSON file
			Object obj = ObjectParser.parse(reader);

			string = (JSONArray) obj;
			System.out.println("personList");
			personList = string;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return string;

	}

	/*
	 * method to create file
	 */
	@Override
	public void create() throws IOException {
		System.out.println("Enter the name of address book");
		String NewAddressBookName = AddressBookUtility.inputString();
		File file = new File("jsonFolder/" + NewAddressBookName + ".json");
		if (file.createNewFile()) {
			System.out.println("File is created Sucessfully");
		} else {
			System.out.println("File already exists");
		}

	}

	/*
	 * method to save
	 */
	@Override
	public void save() {
		try {
			AddressBookJSON.writeJson();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		System.out.println("Saved");
	}

	@Override
	public void sortByZip() {
		// TODO Auto-generated method stub

	}

}
