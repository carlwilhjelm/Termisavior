package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	Image face;
	int faceX = 0;
	int faceY = 0;
	
	public Menu(int state) {
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//face = new Image("res/cthulu.PNG");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.fillOval(75, 100, 100, 100);
		g.drawString("Play Now!", 80, 70);
		//g.drawImage(face, faceX, faceY);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		/*
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		if((xpos > 75 && xpos < 175) && (ypos > 160 && ypos < 260)) {
			if(input.isMouseButtonDown(0)) {
				sbg.enterState(1);
			}
		}
		*/
		if(input.isKeyDown(input.KEY_SPACE)) {
			sbg.enterState(1);
		}
		
		
	}
	
	public int getID() {
		return 0;
	}

}
