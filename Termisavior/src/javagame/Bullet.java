package javagame;

public class Bullet {
	int x, y, xMin;
	Bullet prev;
	Bullet next;
	public static final int dx = 16;
	public static final int dy = 16;
	
	Bullet(int xInit, int yInit) {
		x = xInit;
		y = yInit;
		prev = null;
		next = null;
	}
	
	public void moveL() {
		x -= 8;
	}
	
	public boolean collision(int xIn, int yIn,
							int dxIn, int dyIn) {
		
			//left side of bullet is to the right of the left side of the spider
		if (x - dx > xIn - dxIn &&
			//right side of bullet is to the left of the right side of the spider
			x + dx < xIn + dxIn &&
			//top side of the bullet is under the top side of the spider
			y - dy > yIn - dyIn &&
			//bottom side of the bullet is above the bottom side of the spider
			y + dy < yIn + dyIn)
			return true;
		return false;
	}

}
