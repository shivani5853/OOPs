/******************************************************************************

 *  Purpose: Clinic Management 
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   20-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgelabz.clinicmanagement.repository;

/*
 * IMPORT STATEMENTS
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.clinicmanagement.model.DoctorDetails;

public class CliniqueRepository {

	/*
	 * METHOD TO WRITE DATA
	 */
	public static void writeData(String filePath, JSONArray jsonArray) {
		try (FileWriter fileWriter = new FileWriter(filePath)) {
			fileWriter.write(jsonArray.toJSONString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * METHOD TO READ DATA
	 */
	public static JSONArray readData(String filePath) {
		JSONArray jsonArray;
		try (FileReader fileReader = new FileReader(filePath)) {
			JSONParser jsonParser = new JSONParser();
			jsonArray = (JSONArray) jsonParser.parse(fileReader);
			return jsonArray;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	public static void writeData(String doctor, JSONArray jsonArray) {
//		try (FileWriter fileWriter = new FileWriter(filePath)) {
//			fileWriter.write(jsonArray.toJSONString());
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}		
//	}

}
