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

public class StockTrader {

	/*
	 * PRIVATE INSTANCE VARIABLE
	 */
	private String stockName;
	private String symbole;
	private long shraresQuantity;
	private long cash;

	/*
	 * SETTER AND GETTERS
	 */
	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public long getShraresQuantity() {
		return shraresQuantity;
	}

	public void setShraresQuantity(long l) {
		this.shraresQuantity = l;
	}

	public long getCash() {
		return cash;
	}

	public void setCash(long l) {
		this.cash = l;
	}

	/*
	 * TO STRING METHOd
	 */
	@Override
	public String toString() {
		return "StockTrader [stockName=" + stockName + ", symbole=" + symbole + ", shraresQuantity=" + shraresQuantity
				+ ", cash=" + cash + "]";
	}

}
