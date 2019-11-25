/******************************************************************************

 *  Purpose: Stock Account Management Problem
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   20-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgelabz.stockaccountmanagement.repository;

/*
 * IMPORT STATEMENTS
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.stockaccountmanagement.model.CompanyDetails;
import com.bridgelabz.stockaccountmanagement.utility.StockUtility;

public class StockData {

	public static void writeJson() throws IOException {

		/*
		 * CREATING JSON ARRAY
		 */
		JSONArray array = new JSONArray();

		System.out.println("Enter how many company information you have\n");
		int choice = StockUtility.inputInteger();
		StockUtility.checkNumber(choice);

		while (choice != 0) {
			CompanyDetails d = new CompanyDetails();
			JSONObject obj = new JSONObject();

			System.out.println("Enter the Stock Name\n");
			String stockName = StockUtility.inputString();
			d.setCompanyName(stockName);
			obj.put("companyName", d.getCompanyName());

			System.out.println("Enter Quantity oof Shares\n");
			long shares = StockUtility.inputLong();
			d.setShares(shares);
			obj.put("shares", d.getShares());

			System.out.println("Enter price per shares\n");
			long pricePerShares = StockUtility.inputLong();
			d.setPricePerShares(pricePerShares);
			obj.put("pricePerShares", d.getPricePerShares());

			array.add(obj);
			choice--;
			try (FileWriter file = new FileWriter("jsonstock/Stock.json")) {

				file.write(array.toJSONString());
				file.flush();

				System.out.println("Data Added Sucessfully");
			}
		}
	}

	public static void readJson() {
		JSONParser parse = new JSONParser();
		try {
			FileReader reader = new FileReader("jsonstock/Stock.json");

			Object obj = parse.parse(reader);
			System.out.println(obj);

		} catch (Exception e) {
			System.out.println("Something went wrong\nPlease Enter Correct Value");
			return;
		}

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

	public static void main(String[] args) throws IOException {
		writeJson();
		readJson();
	}
}