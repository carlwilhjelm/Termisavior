package javagame;

public class BulletList {
	Bullet first, last;
	int spawnTime;
	
	public BulletList () {
		first = null;
		last = null;
		spawnTime = 5;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void add(Bullet x) {
		if (first == null) {
			first = x;
			last = x;
		}
		//the latest bullet will always be the last
		else {
		x.prev = last;
		last.next = x;
		last = x;
		}
	}
	
	public void remove(Bullet x) {
		
		//if this is the last bullet
		if(x.next == null) {
			//if this is also the first bullet set first to null
			if (x.prev == null) {
				first = null;
				return;
			}
			//otherwise set the second to last bullet to last
			else {
				last = x.prev;
				last.next = null;
			}
			return;
		}
		
		//if this is the first bullet set the next bullet to first and set its prev to null
		if(x.prev == null) {
			first = x.next;
			first.prev = null;
			return;
		}
		
		x.prev.next = x.next;
		x.next.prev = x.prev;
	}
}


