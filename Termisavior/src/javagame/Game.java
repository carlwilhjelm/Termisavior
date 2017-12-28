package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Game extends StateBasedGame {
	
	public static final String gameName = "Termisavior";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int xRange = 640;
	public static final int yRange = 530;
	
	public Game(String gameName) throws SlickException{
		super(gameName);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu);
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		//create game window in try catch 
		try {
			appgc = new AppGameContainer(new Game(gameName));
			//set size of window, y, x, fullscreen?
			appgc.setDisplayMode(xRange, yRange, false);
			appgc.start();
			
		}catch(SlickException e) {
			e.printStackTrace();
		}

	}

}