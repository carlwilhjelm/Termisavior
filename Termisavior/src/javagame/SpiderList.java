package javagame;

public class SpiderList {
   Spider first, last;
	
   public SpiderList () {
      first = null;
      last = null;
   }
	
   public boolean isEmpty() {
      return first == null;
   }
	
   public void add(Spider x) {
      if (first == null) {
         first = x;
         last = x;
      }
      //the latest spider will always be the last
      else {
         x.prev = last;
         last.next = x;
         last = x;
      }
   }
	
   public Spider remove(Spider x) {
   	
   	//if this is the last spider
      if(x.next == null) {
      	//if this is also the first spider set the first spider to null
         if (x.prev == null) {
            first = null;
            return x;
         }
         //otherwise set the previous spider to last
         else {
            last = x.prev;
            last.next = null;
         }
         return x;
      }
   	//if this is the first spider set the next spider to first and set its prev to null
      if(x.prev == null) {
         first = x.next;
         first.prev = null;
         return x;
      }
   	
      x.prev.next = x.next;
      x.next.prev = x.prev;
      return x;
   }
}
