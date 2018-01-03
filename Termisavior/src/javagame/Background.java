package javagame;

public class Background {
	int current, totalImages;
	
	public Background(int n) {
	current = 0;
	totalImages = n;	
	}
	
	public int next() {
		if (++current == totalImages) current = 0;
		return current;
	}
	
	public int current() {
		return current;
	}

}
