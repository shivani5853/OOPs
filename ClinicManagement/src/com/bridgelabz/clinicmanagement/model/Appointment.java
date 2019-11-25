/******************************************************************************

 *  Purpose: This programme is used to manage a list of Doctors associated with the Clinique. This also manages the list of patients who use the clinique. It manages Doctors by Name, Id, Specialization and Availability (AM, PM or both). It manages Patients by Name, ID, Mobile Number and Age. The Program allows users to search Doctor by name, id, Specialization or Availability. Also the programs
			allows users to search patient by name, mobile number or id.
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   20-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgelabz.clinicmanagement.model;

public class Appointment {

	/*
	 * INSTANCE VARIABLE
	 */
	String doctorName;
	int doctorId;
	String patientName;
	int patientId;
	String Availibility;
	String patientPhone;

	/*
	 * PARAMETRISED CONSTRUCTOR
	 */
	public Appointment(String doctorName, int doctorId, String patientName, int patientId, String patientPhone,
			String Availibility) {
		this.doctorName = doctorName;
		this.doctorId = doctorId;
		this.patientName = patientName;
		this.patientId = patientId;
		this.Availibility = Availibility;
		this.patientPhone = patientPhone;
	}

	/*
	 * SETTER AND GETTERS
	 */
	public String getAvailibility() {
		return Availibility;
	}

	public void setAvailibility(String Availibility) {
		this.Availibility = Availibility;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	/*
	 * TO STRING METHOD
	 */
	@Override
	public String toString() {
		return "Appointment [doctorName=" + doctorName + ", doctorId=" + doctorId + ", patientName=" + patientName
				+ ", patientId=" + patientId + ", Availibility=" + Availibility + ", patientPhone=" + patientPhone
				+ "]";
	}
}