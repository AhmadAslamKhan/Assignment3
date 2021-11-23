package assignment;

import java.io.*;
import java.util.*;

public class Input {
	
	Vector<String> vect = new Vector<String>();
	String fname;
	int count;
	
	public Input() {
		count=0;
		fname=null;
	}
	
	public void insert(String filename) {
		
		try {
			fname=filename;
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				
				String[] tokens = line.split("\\ ");
				
				for (String w : tokens) {
					vect.add(w);
					count++;
					}
			}
			
			myReader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Custom Exception: An error occurred.");
			e.printStackTrace();
		} 
	}
	public int search(String w) {
		
		int wcount=0;
	
		for (int i=0;i<vect.size();i++){
        	if(vect.get(i).equals(w)) {
        		wcount++;
        	}
        }
		return wcount;
	}
	public void display() {
	
		System.out.println("The Sentence elements for " + fname + " are:");
		System.out.println("");
 
        for (int i=0;i<vect.size();i++){
        	System.out.println(vect.get(i));
        }
        System.out.println("");
	}
}
