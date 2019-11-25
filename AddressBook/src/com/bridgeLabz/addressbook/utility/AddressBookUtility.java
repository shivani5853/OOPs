/******************************************************************************
 *  Purpose: Address Book Utility
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   19-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgeLabz.addressbook.utility;

/*
 * IMPORT STATEMENTS
 */
import java.util.Random;
import java.util.Scanner;

public class AddressBookUtility {

	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();

	public AddressBookUtility() {
	}

	/*
	 * Return Input Integer
	 */
	public static int inputInteger() {
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Invalied Input");
		}
		return 0;
	}

//		try {
//	    
//	        return Integer.parseInt(scanner.nextLine().trim());
//	    
//		}
//		catch (Exception e) {
//	        System.out.println("Invalied Input");
//		}
//		return 0;
//	}
	/*
	 * Return Input Long
	 */
	public static long inputLong() {
		try {
			return scanner.nextLong();
		} catch (Exception e) {
			System.out.println("Invalied Input");
		}
		return 0;
	}

	/*
	 * Return Input Double
	 */
	public static double inputDouble() {
		try {
			return scanner.nextDouble();
		} catch (Exception e) {
			System.out.println("Invalied Input");
		}
		return 0.0;
	}

	/*
	 * Return Input String
	 */
	public static String inputString() {
		try {
			return scanner.next();
		} catch (Exception e) {
			System.out.println("Invalied Input");
		}
		return null;
	}

	/*
	 * Return Input String
	 */
	public static String inputStringLine() {
		try {
			return scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Invalied Input");
		}
		return null;
	}

	/*
	 * Return Input Float
	 */
	public static float inputFloat() {
		try {
			return scanner.nextFloat();
		} catch (Exception e) {
			System.err.println("Invalied Input");
		}
		return 0L;
	}

	/*
	 * Return Input Boolean
	 */
	public static boolean inputBoolean() {
		try {
			return scanner.nextBoolean();
		} catch (Exception e) {
			System.err.println("Invalied Input");
		}
		return false;
	}
//public static void main(String[] args) {
//	System.out.println("Enter the value");
//	String v=inputString();
//	String a=inputStringLine();
//	System.out.println(" "+a);
//}

	public static int inputIntegerOne() {
		try {

			return Integer.parseInt(scanner.nextLine());

		} catch (Exception e) {
			System.out.println("Invalied Input");
		}
		return 0;
	}
}
