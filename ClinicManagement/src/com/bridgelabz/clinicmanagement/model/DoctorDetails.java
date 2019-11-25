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

public class DoctorDetails {

	/*
	 * PRIVATE INSTANCE VARIABLE
	 */
	private String doctorName;
	private String doctorId;
	private String specialization;
	private String availability;
	private long numberOfPatients;

	/*
	 * GETTER SETTER OF THE PRIVATE INSTANCE VARIABLE
	 */
	public long getNumberOfPatients() {
		return numberOfPatients;
	}

	public void setNumberOfPatients(long numberOfPatients) {
		this.numberOfPatients = numberOfPatients;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/*
	 * TO STRING METHOD
	 */
	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", doctorId=" + doctorId + ", specialization=" + specialization
				+ ", availability=" + availability + ", numberOfPatients=" + numberOfPatients + "]";
	}
}