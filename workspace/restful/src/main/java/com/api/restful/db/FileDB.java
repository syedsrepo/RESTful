package com.api.restful.db;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.LineNumberReader;

public class FileDB {
	
	public void addProfile(String profileName) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			File file = new File("C:\\git\\profiles.dat");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(profileName + "\n");

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	public int getCount() {
		int linenumber = 0;
		try{
    		File file =new File("C:\\git\\profiles.dat");
    		
    		if(file.exists()){    			
    		    FileReader fr = new FileReader(file);
    		    LineNumberReader lnr = new LineNumberReader(fr);
	            while (lnr.readLine() != null){
	            	linenumber++;
	            }	 
	            System.out.println("Total number of lines : " + linenumber);    	 
	            lnr.close();   	        
    		     
    		}else{
    			 System.out.println("File does not exists!");
    		}
    		
    	}catch(IOException e){
    		e.printStackTrace();
    	}
		return linenumber;
	}

	public static void main(String[] args) {
		FileDB file = new FileDB();
		file.addProfile("Salahuddin");
		file.getCount();
	}

}
