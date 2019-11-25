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
package com.bridgelabz.clinicmanagement.service.serviceimplementation;

/*
 * IMPORT STATEMENT
 */
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.clinicmanagement.controller.ClinicController;
import com.bridgelabz.clinicmanagement.model.DoctorDetails;
import com.bridgelabz.clinicmanagement.model.Patients;
import com.bridgelabz.clinicmanagement.repository.CliniqueRepository;
import com.bridgelabz.clinicmanagement.service.ClinicInf;
import com.bridgelabz.clinicmanagement.utility.ClinicManagementUtility;

public class ClinicManagementImplementation implements ClinicInf {

	/*
	 * CREATING JSON OBJECT AND JSON ARRAY
	 */
	JSONArray jsonArray = new JSONArray();
	JSONObject jsonObjectOne = new JSONObject();

	/*
	 * DECLARE PATH
	 */
	static String doctor = "src/jsonfolder/Doctor.json";
	static String patient = "src/jsonfolder/Patient.json";

	/*
	 * METHOD TO TAKE DOCTOR DETAILS
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void doctorDetails() {

		jsonArray = CliniqueRepository.readData(doctor);

		/*
		 * CREATING JSON OBJECT
		 */
		JSONObject jsonObjectOne = new JSONObject();
		DoctorDetails doctorDetails = new DoctorDetails();

		System.out.println("Enter Doctor Name");
		String doctorName = ClinicManagementUtility.inputString();

		/*
		 * CHECKING STRING ONLY METHOD
		 */
		if (ClinicManagementUtility.isStringOnlyAlphabet(doctorName)) {
			doctorDetails.setDoctorName(doctorName);
		}

		/*
		 * CHECKING STRING ONLY METHOD
		 */
		System.out.println("Enter Doctor Specialization");
		String specialization = ClinicManagementUtility.inputString();
		if (ClinicManagementUtility.isStringOnlyAlphabet(specialization)) {
			doctorDetails.setSpecialization(specialization);
		}

		/*
		 * CHECKING STRING ONLY METHOD
		 */
		System.out.println("Enter Doctor Availability");
		String availability = ClinicManagementUtility.inputString();
		if (ClinicManagementUtility.isStringOnlyAlphabet(availability)) {
			doctorDetails.setAvailability(availability);
		}

		doctorDetails.setDoctorId(ClinicManagementUtility.doctorId());
		doctorDetails.setNumberOfPatients(0);

		/*
		 * GETTING THE DATA
		 */
		jsonObjectOne.put("Id", doctorDetails.getDoctorId());
		jsonObjectOne.put("Name", doctorDetails.getDoctorName());
		jsonObjectOne.put("Specialization", doctorDetails.getSpecialization());
		jsonObjectOne.put("Availability", doctorDetails.getAvailability());
		jsonObjectOne.put("Patients", doctorDetails.getNumberOfPatients());

		jsonArray.add(jsonObjectOne);

//		CliniqueRepository.writeData(doctor, jsonArray);

		System.out.println(jsonArray);
		CliniqueRepository.writeData(doctor, jsonArray);

	}

	/*
	 * Reads doctor's data from json file
	 */
	@Override
	public void readDoctorData(String key, String value, String choice) {

		/*
		 * adds json data to json array
		 */
		jsonArray = (JSONArray) CliniqueRepository.readData(doctor);

		/*
		 * iterator to iterate json data
		 */
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject, lastJasonObject = null;

		/*
		 * iterates over json array
		 */
		while (iterator.hasNext()) {
			/*
			 * checks if data given by user matches with any json object
			 */
			if ((jsonObject = (JSONObject) iterator.next()).get(key).equals(value)) {
				lastJasonObject = jsonObject;
				System.out.println("\nDoctor Information:");
				System.out.println("ID: " + jsonObject.get("Id") + "\t");
				System.out.println("Name: " + jsonObject.get("Name") + "\t");
				System.out.println("Specialization: " + jsonObject.get("Specialization") + "\t");
				System.out.println("Availability: " + jsonObject.get("Availability") + "\t");
				System.out.println("Number of Patients: " + jsonObject.get("Patients") + "\n");

				System.out.println("Do you want to take an appointment?[y/n]");
				String response = ClinicManagementUtility.inputString().toLowerCase();
				if (response.equals("y")) {
					makeAppointment(lastJasonObject);
				} else {
					ClinicController.menu();
				}
			}
		}
		System.out.println("Enter valid Doctor " + key);
		ClinicController.doctorChoice(choice);
	}

	/*
	 * METHOD TO TAKE APPOINTMENT
	 */
	private void makeAppointment(JSONObject doctorJsonObject) {
		String doctorId = (String) doctorJsonObject.get("Id");
		long patients = (long) doctorJsonObject.get("Patients");
		if (patients >= 5) { // doctor is busy
			System.out.println("Sorry!!! Doctor is busy today. Make an appointment tomorrow.");
			ClinicController.menu();
		} else {
			String id = ClinicManagementUtility.patientId();
			// updates patient json file
			patientDetailsNew(id, doctorId);
			doctorJsonObject.put("Patients", patients + 1);
			updateDoctorData(doctorJsonObject);
			System.out.println("Congratulation You got an appointment. Your Patient ID is " + id + "\n");
			ClinicController.menu();
		}

	}

	/*
	 * METHOD TO UPDATE DOCTORE DATE
	 */
	private void updateDoctorData(JSONObject doctorJsonObject) {

		jsonArray = CliniqueRepository.readData(doctor);

		JSONArray updatedArray = new JSONArray();
		Iterator iterator = jsonArray.iterator();

		// iterates over array
		while (iterator.hasNext()) {
			JSONObject object = (JSONObject) iterator.next();
			if (object.get("Id").equals(doctorJsonObject.get("Id"))) {
				updatedArray.add(doctorJsonObject);
			} else {
				updatedArray.add(object);
			}
		}

		CliniqueRepository.writeData(doctor, updatedArray);

	}

	/*
	 * METHOD TO PATIENT DETAILS
	 */
	@SuppressWarnings("unchecked")
	public void patientDetailsNew(String id, String doctorId) {

		JSONArray jsonArray = CliniqueRepository.readData(patient);

		Patients patientDetails = new Patients();
		System.out.println("Enter Patient Name");
		String patientName = ClinicManagementUtility.inputString();
		if (ClinicManagementUtility.isStringOnlyAlphabet(patientName)) {
			patientDetails.setPatientName(patientName);
		}

		System.out.println("Enter Mobile Number");
		String mobile = ClinicManagementUtility.inputString();
		if (ClinicManagementUtility.mobileNumberValidator(mobile)) {
			System.out.println("Mobile :" + mobile);
			patientDetails.setMobile(Long.parseLong(mobile));
		}

		System.out.println("Enter Age");
		int age = ClinicManagementUtility.inputInteger();
		patientDetails.setAge(age);

		patientDetails.setId(ClinicManagementUtility.patientId());

		jsonObjectOne.put("Id", patientDetails.getId());
		jsonObjectOne.put("Name", patientDetails.getPatientName());
		jsonObjectOne.put("Mobile", patientDetails.getMobile());
		jsonObjectOne.put("Age", patientDetails.getAge());
		jsonObjectOne.put("Doctor Id", doctorId);

		jsonArray.add(jsonObjectOne);

		CliniqueRepository.writeData(patient, jsonArray);
	}

	/*
	 * METHOD TO READ PATIENTS DATA
	 */
	@Override
	public void readPatientData(String key, String value) {
		jsonArray = CliniqueRepository.readData(patient);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject;
		while (iterator.hasNext()) {
			if ((jsonObject = (JSONObject) iterator.next()).containsValue(value)) {
				System.out.println("\nPatient Information:");
				System.out.println("ID: " + jsonObject.get("Id") + "\t");
				System.out.println("Name: " + jsonObject.get("Name") + "\t");
				System.out.println("Mobile Number: " + jsonObject.get("Mobile") + "\t");
				System.out.println("Age: " + jsonObject.get("Age") + "\n");
			}
		}
		ClinicController.menu();
	}

}