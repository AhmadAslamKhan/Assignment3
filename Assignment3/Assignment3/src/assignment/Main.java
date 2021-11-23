package assignment;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exceptions
	{
		//------------------------------------------Threads------------------------------------------------------
		BST objec = new BST();
		VocabThread vc=new VocabThread(args,objec);
		
		vc.start();
		
		int fileno=(args.length)-1;
		
		filesThread ft=new filesThread(fileno,args,objec);
		ft.start();
		
		//--------------------------------------------------Displaying Main Menu---------------------------------------------
		System.out.println("Main Menu:"); 
		System.out.println("(1)Display number and name of files entered");  
		System.out.println("(2)Display BST for the Vocabulary File"); 
		System.out.println("(3)Display Vectors build from the Input Files"); 
		System.out.println("(4)View matching Words and its Frequence"); 
		System.out.println("(5)Searching a query");
		System.out.println("(6)Exit");  
		
		Scanner scanint = new Scanner(System.in);
		System.out.print("Option: ");
		int choice = scanint.nextInt();
		System.out.print("\n");
		
		if (choice==0 || choice>6){
			throw new Exceptions("Invalid option: Please Restart the Program");
		}
		if (choice==1)
		{
			int size = args.length;
			if (size==0){
				throw new Exceptions("No Files Passed as argument");
			}
			System.out.println("The Number of files Input: " + size);
			for (int i=0;i<args.length;i++)
			{
				System.out.println("File Name: " + args[i]);
			}
		}
		else if (choice==2)
		{
			System.out.println("Inorder Display:");
			System.out.println("");
			objec.Inorder(objec.root);
		}
		else if (choice==3)
		{
			ft.display();
		}
		else if (choice==4)
		{
			ft.worddisplay();
		}
		else if (choice==5)
		{
			ft.WordCount();
		}
		else if (choice==6)
		{
			System.out.println("Thank You for using our System");
		}
		
	}
}