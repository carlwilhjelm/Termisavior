package javagame;

public class Corpses {
	Spider first, last;
	private static int count;
	private static final int maxCount = 20;
	
	   public Corpses () {
	      first = null;
	      last = null;
	      count = 0;
	   }
		
	   public boolean isEmpty() {
	      return first == null;
	   }
	   
	   public void add(Spider x) {
		   if (first == null) { 
			   first = x;
			   last = x;
			   count = 1;
			   return;
		   }
		   last.next = x;
		   last = x;
		   count++;
	   }
	   
	   public void remove() {
		   first = first.next;
		   count--;
	   }
	   
	   public void cleanUp() {
		   if (count > maxCount) remove();
	   }
}
