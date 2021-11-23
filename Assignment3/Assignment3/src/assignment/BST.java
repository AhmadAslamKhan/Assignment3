package assignment;

import java.util.*;

public class BST {

	
	static class Node {
	    String word;
	    Node left;
	    Node right;
	}
	Node root;
	int count;
	
	public BST() {
		root=null;
		count=0;
	}
	
	public Node newNode(String data)
	{
	    Node temp = new Node();
	   
	    temp.word = data;
	   
	    temp.left = null;
	    temp.right = null;
	   
	    return temp;
	}
	   
	public Node insert(Node root, String word)
	{
		Node newnode = newNode(word);
		if (root == null) { 
            root = newnode; 
            count++;
            return root; 
        } 
		int comp = root.word.compareTo(word);
        if (comp>0)
            root.left = insert(root.left, word); 
        else if (comp<0)
            root.right = insert(root.right, word); 
          // return pointer
        return root;
	}
	public void Inorder(Node root)
	{
	    if (root == null)
	        return;
	    else {
	        Inorder(root.left);
	        System.out.print( root.word +" ");
	        Inorder(root.right);
	    }
	}
	
	boolean search(Node root, String word)  { 
        root = search_Recursive(root, word); 
        if (root!= null)
            return true;
        else
            return false;
    } 
    Node search_Recursive(Node root, String word)  { 
        if (root==null || word.compareTo(root.word)==0) 
            return root; 
         
        int comp = word.compareTo(root.word);
        if (comp<0) 
            return search_Recursive(root.left, word); 

        return search_Recursive(root.right, word); 
    } 
}





