package javagame;

public class Node {
	String val;
	Node next;
	
	Node(String valIn){
		val = valIn;
		next = null;
	}
	
	Node(String valIn, Node nextIn){
		val = valIn;
		next = nextIn;
	}

}
