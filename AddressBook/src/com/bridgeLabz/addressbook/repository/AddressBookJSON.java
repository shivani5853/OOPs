/******************************************************************************

 *  Purpose: The software to be designed is a program that can be used to maintain an address book. An address book
			holds a collection of entries, each recording a person's first and last names, address, city, state, zip, and
			phone number.
			
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   18-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgeLabz.addressbook.repository;

/*
 * 	IMPORT STATEMENTS
 */
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
import com.bridgeLabz.addressbook.utility.AddressBookUtility;

public class AddressBookJSON {
	static AddressBookUtility utility = new AddressBookUtility();
	static List<Person> personList = new ArrayList<Person>();

	public static void writeJson() throws IOException, ParseException {

		// First Employee
//	        JSONObject employeeDetails = new JSONObject();
//	        employeeDetails.put("firstName","Shivani");
//	        employeeDetails.put("lastName", "kumari");
//	        employeeDetails.put("website", "howtodoinjava.com");
//	         
//	        JSONObject employeeObject = new JSONObject();
//	        employeeObject.put("employee", employeeDetails);
//	         
//	        //Second Employee
//	        JSONObject employeeDetails2 = new JSONObject();
//	        employeeDetails2.put("firstName", "Brian");
//	        employeeDetails2.put("lastName", "Schultz");
//	        employeeDetails2.put("website", "example.com");
//	         
//	        JSONObject employeeObject2 = new JSONObject();
//	        employeeObject2.put("employee", employeeDetails2);
//	         
//	        JSONObject employeeDetails3 = new JSONObject();
//	        employeeDetails3.put("firstName", "Brian");
//	        employeeDetails3.put("lastName", "Schultz");
//	        employeeDetails3.put("website", "example.com");
//	         
//	        JSONObject employeeObject3 = new JSONObject();
//	        employeeObject3.put("employee", employeeDetails3);
//	         
//	        //Add employees to list
//	        JSONArray employeeList = new JSONArray();
//	        employeeList.add(employeeObject);
//	        employeeList.add(employeeObject2);
//	        employeeList.add(employeeObject3);

//		AddressBookImplementation addressImp=new AddressBookImplementation();

		JSONArray personJsonArray = new JSONArray();

		System.out.println("You have any person Information...\n" + "\nYES-How many Person information\nNo-Press 0");
		int choice = utility.inputInteger();
		while (choice != 0) {
			JSONObject personObject = new JSONObject();

			System.out.println("Enter the First name");
			personObject.put("firstName", utility.inputString());

			System.out.println("Enter the Last Name");
			personObject.put("lastName", utility.inputString());

			System.out.println("Enter the email id");
			personObject.put("emailId", utility.inputString());

			System.out.println("Enter Phone Number:");
			personObject.put("phoneNo", utility.inputString());

			System.out.println("Enter City:");
			personObject.put("city", utility.inputString());

			System.out.println("Enter State:");
			personObject.put("state", utility.inputString());

			System.out.println("Enter ZIP/PIN Code:");
			personObject.put("zip", utility.inputString());

			JSONObject personObjectOne = new JSONObject();
			personObjectOne.put("person", personObject);

			personJsonArray.add(personObjectOne);
//		personJsonArray.add(addressImp.addList());
			choice--;

			// Write JSON file
			try (FileWriter file = new FileWriter("/home/admin1/Downloads/BridgeLabz/AddressBook.json")) {

				file.write(personJsonArray.toJSONString());
				file.flush();

			}
		}
	}

//	public static void readJson() throws org.json.simple.parser.ParseException {
//	        //JSON parser object to parse read file
//	        JSONParser ObjectParser = new JSONParser();
//	         
//	        try (FileReader reader = new FileReader("/home/admin1/Downloads/BridgeLabz/AddressBook.json"))
//	        {
//	            //Read JSON file
//	            Object obj = ObjectParser.parse(reader);
//	 
////	            JSONArray personList = (JSONArray) obj;
//	         
////	            System.out.println("Data Present\n"+personList);
//	            
////	            parsePersonObject(personList);
//	            //Iterate over person array
////	            personList.forEach( per ->parsePersonObject((JSONObject)per));
//	            
////	            JSONArray array = ...;
////
////	            array.forEach(item -> { JSONObject obj = (JSONObject) item;
////	                parse(obj);
////	            });
//	 
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//		
//		}

//	    private static void parsePersonObject(JSONArray personList) 
//	    {
//	    	for (int i = 0; i < personList.size(); i++) {
//				System.out.println(personList(i));
//			}
//	    }

	public static JSONArray readDemo() {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		JSONArray string = new JSONArray();
		try (FileReader reader = new FileReader("/home/admin1/Downloads/BridgeLabz/AddressBook.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray employeeList = (JSONArray) obj;
			string = (JSONArray) obj;
			personList = string;

			// Iterate over employee array
			employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;

	}

	public static void parseEmployeeObject(JSONObject person) {
		// Get employee object within list
		JSONObject personObject = (JSONObject) person.get("person");

		// Get employee first name
		String firstName = (String) personObject.get("firstName");
		System.out.println(firstName);

		// Get employee last name
		String lastName = (String) personObject.get("lastName");
		System.out.println(lastName);

		String email = (String) personObject.get("emailId");
		System.out.println(email);
		// Get employee website name

		String zip = (String) personObject.get("zip");
		System.out.println(zip);

		String phoneNo = (String) personObject.get("phoneNo");
		System.out.println(phoneNo);

		String city = (String) personObject.get("city");
		System.out.println(city);

		String state = (String) personObject.get("state");
		System.out.println(state);

	}

	public static void main(String[] args) throws ParseException, IOException {
		writeJson();
		readDemo();
	}
}
