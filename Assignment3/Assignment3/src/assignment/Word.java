package assignment;

import assignment.BST.Node;

public class Word {

	static class Node{
		String word;
		int count;
		
		Node next;
	}
	
	Node head;
	
	public Word() {
		head=null;
	}
	public Node newNode(String data)
	{
	    Node temp = new Node();
	   
	    temp.word = data;
	    temp.count=1;
	   
	    temp.next = null;
	   
	    return temp;
	}
	public Node search(Node head, String w) {
		
		if (head == null) { 
			Node newnode = newNode(w);
			head = newnode;
            return head; 
        } 
		else if (head.word.equals(w)){
			head.count+=1;
			return head;
		}
		if (!head.word.equals(w)) {
			head.next = search(head.next, w);
		}
		
		return head;
		
	}
	public void Display(Node head) {
		while (head!=null) {
			System.out.println("Word: " + head.word);
			System.out.println("Count: " + head.count);
			head=head.next;
		}
	}

}






