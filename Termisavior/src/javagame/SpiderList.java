package javagame;

public class SpiderList {
	int xMax, spawnTime;
	Spider first, last;
	
	public SpiderList (int xMaxIn) {
		first = null;
		last = null;
		xMax = xMaxIn;
		spawnTime = 60;
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
	
	public void remove(Spider x) {
		
		//if this is the last spider
		if(x.next == null) {
			//if this is also the first spider set the first spider to null
			if (x.prev == null) {
				first = null;
				return;
			}
			//otherwise set the previous spider to last
			else {
				x.prev = last;
				last.next = null;
			}
			return;
		}
		//if this is the first spider set the next spider to first and set its prev to null
		if(x.prev == null) {
			first = x.next;
			first.prev = null;
			return;
		}
		
		x.prev.next = x.next;
		x.next.prev = x.prev;
	}
}
