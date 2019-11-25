/******************************************************************************

 *  Purpose: Clinic Management Interface
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   20-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgelabz.clinicmanagement.service;

public interface ClinicInf {

	/*
	 * METHODS OF CLINIC MANAGEMENT
	 */
	void doctorDetails();

	void readDoctorData(String key, String value, String choice);

	void readPatientData(String key, String value);

}
