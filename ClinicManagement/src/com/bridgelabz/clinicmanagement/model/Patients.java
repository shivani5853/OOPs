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

public class Patients {

	/*
	 * PRIVATE INSTANCE VARIABLE
	 */
	private String patientName;
	private String id;
	private long mobile;
	private int age;

	/*
	 * SETTERS AND GETTERS
	 */
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * TO STRING METHOD
	 */
	@Override
	public String toString() {
		return "Patients [patientName=" + patientName + ", id=" + id + ", mobile=" + mobile + ", age=" + age + "]";
	}

}