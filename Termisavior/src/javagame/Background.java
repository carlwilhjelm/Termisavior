package javagame;

public class Background {
	Node first;
	Node current;
	
	public Background (String firstIn, String...imageNames) {
		first = new Node(firstIn);
		current = first;
		for (String str : imageNames) {
			current.next = new Node(str);
			current = current.next;
		}
		current.next = first;
	}
	
	public String next() {
		current = current.next;
		return current.val;
	}

}
