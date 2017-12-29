package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	Jesus j;
	Image backgroundImage, jesus, bulletImage, spiderImage;
	Background backgroundObj;
	Bullet currentB;
	Spider currentS;
	SpiderList spiList;
	BulletList bList;
	FPSCap c;
	
	//jesus x y constraints
	public static int jxMax = 570, jyMax = 450, jxMin = 443, jyMin = 240;
	//public static float slope = (float) 1.77;
	//spider x y constraints
	public static int sxMax = 500, syMax = 450, sxMin = 0, syMin = 300;
	//bullet x y constraints
	public static int bxMin = 0;
	//game time
	public static long gameTime = 0;
	
	
	public Play(int state) throws SlickException{
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		j = new Jesus(jxMax, jyMax, jxMin, jyMin);
		spiList = new SpiderList(sxMax);
		bList = new BulletList(bxMin);
		backgroundObj = new Background("res/backgroundPortalA.png", 
				"res/backgroundPortalB.png", "res/backgroundPortalC.png",
				"res/backgroundPortalD.png");
		backgroundImage = new Image(backgroundObj.next());
		bulletImage = new Image("res/bullet.png");
		spiderImage = new Image("res/spider.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		Input input = gc.getInput();
		g.drawString("This is the play state!", 100, 100);
		if (gameTime % 25 == 0) backgroundImage = new Image(backgroundObj.next());
		g.drawImage(backgroundImage, 0, 0);
		jesus = new Image(j.image.val);
		g.drawImage(jesus, j.x, j.y);
		
		if(!bList.isEmpty()) {
			currentB = bList.first;
			do {
				g.drawImage(bulletImage, currentB.x, currentB.y);
				currentB = currentB.next;
			} while (currentB != null);
		}
		
		if(!spiList.isEmpty()) {
			currentS = spiList.first;
			do {
				//pseudo random image change for spider
				if ((currentS.x + currentS.y) % 5 == 0) spiderImage = new Image(currentS.nextImage());
				g.drawImage(spiderImage, currentS.x, currentS.y);
				currentS = currentS.next;
			} while (currentS != null);
		}
		
		FPSCap.sync(60);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		//jesus
		if(input.isKeyDown(Input.KEY_UP)) j.setPos(1);
		if(input.isKeyDown(Input.KEY_DOWN)) j.setPos(-1);
		//bullet spawn and update
		bulletSpawn(input);
		//spider spawn and update
		spiderSpawn();
		
		Bullet i = bList.first;
		Spider j = spiList.first;
		
		//for each bullet
		while(i != null) {
			while (j != null) {
				//check for a collision with every spider
				if (i.collision(j.x, j.y, Spider.dx, Spider.dy)) {
					//if a collision occurs remove the bullet and spider
					spiList.remove(j);
					bList.remove(i);
					j = j.next;
					break;
				}
				j = j.next;
			}
			i = i.next;
			j = spiList.first;
		}
		gameTime++;
	}
	
	//bullet spawn and update
	private void bulletSpawn(Input inputIn) throws SlickException{
		//consider revising bullet time logic to allow for bullet creation at any value of gameTime but delay next possible value
		Input input = inputIn;
		if(input.isKeyDown(Input.KEY_SPACE) && gameTime % bList.spawnTime == 0) bList.add(new Bullet(j.x - 10, j.y + 20));
		
		//if list is empty logic wont work
		if(!bList.isEmpty()) {
			currentB = bList.first;
			do {
				currentB.moveL();
				if(currentB.x < bList.xMin) bList.remove(currentB);
				currentB = currentB.next;
			} while (currentB != null);
		}
	}
	
	//spider spawn and update
	private void spiderSpawn() throws SlickException{
		if(gameTime % spiList.spawnTime == 0) { 
			spiList.add(new Spider(sxMin, syMax, syMin));
		}
		if(!spiList.isEmpty()) {
			currentS = spiList.first;
			do {
				currentS.moveR();
				
				if(currentS.x > spiList.xMax) spiList.remove(currentS);
				currentS = currentS.next;
			} while (currentS != null);
		}
	}
	
	public int getID() {
		return 1;
	}
	
}