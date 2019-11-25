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
package com.bridgelabz.stockaccountmanagement.model;

public class CompanyDetails {
	/*
	 * PRIVATE INSTANCE VARIABLE
	 */
	private String companyName;
	private long shares;
	private long pricePerShares;

	/*
	 * TO STRING METHOD
	 */
	@Override
	public String toString() {
		return "CompanyDetails [companyName=" + companyName + ", shares=" + shares + ", pricePerShares="
				+ pricePerShares + "]";
	}

	/*
	 * SETTER GETTER
	 */
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getShares() {
		return shares;
	}

	public void setShares(long shares) {
		this.shares = shares;
	}

	public long getPricePerShares() {
		return pricePerShares;
	}

	public void setPricePerShares(long price) {
		this.pricePerShares = price;
	}

}
