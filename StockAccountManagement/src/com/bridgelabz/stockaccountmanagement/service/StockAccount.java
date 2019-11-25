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
package com.bridgelabz.stockaccountmanagement.service;

/*
 * IMPORT STATEMENTS
 */
import java.util.List;
import com.bridgelabz.stockaccountmanagement.model.CompanyDetails;

public interface StockAccount {
	
	/*
	 * methods
	 */
	public long value(List<CompanyDetails> company);

	public void buy(String sharesName);

	public void sell(String sharesName);

	public void save(String file, String sharesName);

	public void display();
}
