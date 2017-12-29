package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.Image;

public class Jesus {
	int x, y, xMax, yMax, xMin, yMin;
	double slope;
	Node image;
	
	public Jesus(int xMaxIn, int yMaxIn, 
				int xMinIn, int yMinIn) throws SlickException{
		xMax = xMaxIn;
		yMax = yMaxIn;
		xMin = xMinIn;
		yMin = yMinIn;
		slope = (double)(yMax - yMin)/(xMax - xMin);
		System.out.println(slope);
		x = (xMax + xMin)/2;
		y = (yMax + yMin)/2;
		Node jesusA = new Node("res/jesusA.png");
		Node jesusB = new Node("res/jesusB.png", jesusA);
		jesusA.next = jesusB;
		image = jesusA;
		
	}
	
	public void setPos(int i) {
		if (i < 0) {
			x += 2;
			if(x > xMax) x = xMax;
		}
		else {
		x -= 2;
		if(x < xMin) x = xMin;
		}
		
		if (x%7 == 0) {
			image = image.next;
		}
		if(x > xMin) y = (int)((x-xMin)*slope + yMin);
		if(y < yMin) y = yMin;
		if(y > yMax) y = yMax;
	}
}
