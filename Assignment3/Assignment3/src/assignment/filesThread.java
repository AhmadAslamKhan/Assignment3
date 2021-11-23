package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class filesThread extends Thread {

	int fileno;
	String[] args;
	BST objec = new BST();
	Input[] input1;
	Word wobj;
	public filesThread(int fn,String[] argss,BST objecc) {
		fileno=fn;
		objec=objecc;
		input1 = new Input[fileno];
		wobj = new Word();
		args=argss;
	}
	@Override
	public void run() {
	
		
		
		
		for(int i=0;i<fileno;i++) {
			input1[i]=new Input();
		}
		
		for(int i=0;i<fileno;i++) {
			input1[i].insert(args[i+1]);
		}
		
	}
	
	public void Wordmatch() {
		
					
		for(int i=0;i<fileno;i++) {
			try {
				File myObj = new File(args[i+1]);
				Scanner myReader = new Scanner(myObj);
				
				while (myReader.hasNextLine()) {
					String line = myReader.nextLine();
					
					String[] tokens = line.split("\\ ");
					
					for (String w : tokens) {
						if( objec.search(objec.root, w) ) {
							wobj.head=wobj.search(wobj.head,w);
						}
					}
				}
				
				myReader.close();
			} 
			catch (FileNotFoundException e) {
				System.out.println("Custom Exception: An error occurred.");
				e.printStackTrace();
			} 
		}
	}
	
	public void display() {
		
		for(int i=0;i<fileno;i++) {
			input1[i].display();
		}
	}
	public void worddisplay() {
		Wordmatch();
		wobj.Display(wobj.head);
		
	}
	
	public void WordCount() {
		int wcount=0;
		//Wordmatch();
		Scanner sin= new Scanner(System.in);
		
		System.out.print("Enter a word you want to search: ");  
		String word= sin.nextLine();
		System.out.println("");
		
		System.out.println("The Word To be found is: " + word);
		for(int i=0;i<fileno;i++) {
			wcount=input1[i].search(word);
			System.out.println("File: " + args[i+1]);
			System.out.println("Count: " + wcount);
	}
		
	}
}
