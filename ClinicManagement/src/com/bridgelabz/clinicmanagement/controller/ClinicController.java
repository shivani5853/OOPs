/******************************************************************************

 *  Purpose: Clinic Management Utility
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   21-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgelabz.clinicmanagement.controller;

/*
 * IMPORT STATEMENTS
 */
import com.bridgelabz.clinicmanagement.service.ClinicInf;
import com.bridgelabz.clinicmanagement.service.serviceimplementation.ClinicManagementImplementation;
import com.bridgelabz.clinicmanagement.utility.ClinicManagementUtility;

public class ClinicController {

	static ClinicInf service = new ClinicManagementImplementation();

	public static void main(String[] args) {

		menu();
	}

	/*
	 * METHOD TO DISPLAY MENU
	 */
	public static void menu() {
		System.out.println("Select option");
		System.out.println("1. Add Doctor Details");
		System.out.println("2. Search Doctor");
		System.out.println("3. Search Patient");
		System.out.println("4. Exit");

		String choice = ClinicManagementUtility.inputString();
		if (ClinicManagementUtility.intChecker(choice)) {
			switch (choice) {
			case "1":
				service.doctorDetails();
				menu();
				break;
			case "2":
				doctorInput();
				break;
			case "3":
				patientInput();
				break;
			case "4":
				ClinicManagementUtility.quit();
				System.out.println("Thanks!!! Have a nice Day ");
				break;
			default:
				System.out.println("Invalid option");
				menu();
				break;
			}
		} else {
			System.out.println("Enter numbers only");
			menu();
		}
	}

	/*
	 * METHOD TO TAKE DOCTOR INPUT
	 */
	private static void doctorInput() {
		System.out.println("Search doctor by:");
		System.out.println("1. Name");
		System.out.println("2. ID");
		System.out.println("3. Specialization");
		System.out.println("4. Availability");
		String choice = ClinicManagementUtility.inputString();
		if (ClinicManagementUtility.intChecker(choice)) {
			doctorChoice(choice);
		} else {
			System.out.println("Enter numbers only");
			doctorInput();
		}
	}

	/*
	 * METHOD TO TAKE DOCTORE CHOICE
	 */
	public static void doctorChoice(String choice) {
		switch (choice) {
		case "1":
			System.out.print("Enter name:");
			service.readDoctorData("Name", ClinicManagementUtility.inputString(), choice);
			break;
		case "2":
			System.out.print("Enter ID:");
			service.readDoctorData("Id", ClinicManagementUtility.inputString(), choice);
			break;
		case "3":
			System.out.print("Enter speacialization:");
			service.readDoctorData("Specialization", ClinicManagementUtility.inputString(), choice);
			break;
		case "4":
			System.out.print("Enter availability::");
			service.readDoctorData("Availability", ClinicManagementUtility.inputString(), choice);
			break;
		default:
			System.out.println("select valid option\n");
			doctorChoice(choice);
		}
	}

	/*
	 * METHOD TO TAKE PATIENT INPUT
	 */
	private static void patientInput() {
		System.out.println("Search patient by:");
		System.out.println("1. Name");
		System.out.println("2. ID");
		System.out.println("3. Mobile Number");
		String choice = ClinicManagementUtility.inputString();
		if (ClinicManagementUtility.intChecker(choice)) {
			patientChoice(choice);
		} else {
			System.out.println("Enter numbers only");
			doctorInput();
		}
	}

	private static void patientChoice(String choice) {
		switch (choice) {
		case "1":
			System.out.print("Enter name:");
			ClinicManagementUtility.inputString();
			service.readPatientData("Name", ClinicManagementUtility.inputString());
			break;
		case "2":
			System.out.print("Enter ID:");
			service.readPatientData("Id", ClinicManagementUtility.inputString());
			break;
		case "3":
			System.out.print("Enter mobile number:");
			service.readPatientData("Mobile", ClinicManagementUtility.inputString());
			break;
		default:
			System.out.println("Please select valid option");
			patientChoice(choice);
			break;
		}
	}

}
