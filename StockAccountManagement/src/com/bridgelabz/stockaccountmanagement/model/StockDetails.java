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

public class StockDetails {

	/*
	 * PRIVATE INSTANCE VARIABLE
	 */
	private String stockBuySell;
	private String symbole;
	private String stockName;
	private String date;

	/*
	 * SETTERS AND GETTERS
	 */
	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public String getStockBuySell() {
		return stockBuySell;
	}

	public void setStockBuySell(String stockBuySell) {
		this.stockBuySell = stockBuySell;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getDate() {
		return date;
	}

	/*
	 * TO STRING METHOD
	 */
	@Override
	public String toString() {
		return "StockDetails [stockBuySell=" + stockBuySell + ", symbole=" + symbole + ", stockName=" + stockName
				+ ", date=" + date + "]";
	}

	public void setDate(String date) {
		this.date = date;
	}

}
