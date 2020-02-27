package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 *  IO
 *  -------------------
 *  
 *  
 *  sources
 *  -----
 *  
 *  	- std in / out
 *      - file
 *      - buffer
 *      - n/w sockets
 *      
 *      
 *  types
 *  -----    
 * 
 * 		=> 8-bit / byte           // ASCII
 *      => 16-bit / character     // Unicode
 * 
 * 
 *   IO classes
 *   -----------
 *   
 *    
 *    InputStream         ==> read 8-bit
 *    OutputStream        ==> write 16-bit 
 *    
 *    
 *    Reader              ==> read 16-bit
 *    Writer              ===> write 16-bit
 *    
 *    ----------------------------------------------
 *    
 *    e.g source : file
 *    
 *    8-bit
 *    	 	
 *    FileInputStream
 *    FileOutputStream
 *    
 *    16-bit
 *    
 *    FileReader
 *    FileWriter
 *    
 *     
 *    e.g source : buffer 
 *     
 *     8-bit
 *     
 *     BufferedInputStream
 *     BufferedOutputStream
 *    
 *    
 */

public class CsvFileReadEx {

	public static void main(String[] args) {

		String fileName = "user_credentials.csv";
		File file = new File(fileName);

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;

			List<String[]> lines = new ArrayList<String[]>();
			while ((line = br.readLine()) != null) {
				lines.add(line.split(","));
			}
			String[][] data = new String[lines.size()][0];
			Object[][] oa = lines.toArray(data);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
