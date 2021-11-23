package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VocabThread extends Thread {
	String[] args;
	BST objec = new BST();
	public VocabThread(String[] argss,BST objecc) {
		
		args=argss;
		objec=objecc;
	}
	
	@Override
	public void run() {
		
		
		try {
			File myObj = new File(args[0]);
			Scanner myReader = new Scanner(myObj);
			
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				objec.root=objec.insert(objec.root, data);
			}
			
			myReader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Custom Exception: An error occurred.");
			e.printStackTrace();
		}    
		
	}
}
