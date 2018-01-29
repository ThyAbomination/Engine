import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Game implements KeyListener{
	
	private int width, height;
	private Entity player;

	private boolean running = true;
	private boolean[] keys = new boolean[300];
	
	public Game(int width, int height) throws IOException{
		this.width = width;
		this.height = height;
		
		SpriteSheet sheet = SpriteSheet.cut("EmmySS.png", 16, 16);
	    this.player = new Entity(sheet.get("0"));
	}
	public void update(){
		if(keys[KeyEvent.VK_UP]) {
		    player.moveInDirection(Vector.of(0, 1));
		}
		if(keys[KeyEvent.VK_DOWN]) {
		    player.moveInDirection(Vector.of(0,-1));
		}
		if(keys[KeyEvent.VK_LEFT]) {
		    player.moveInDirection(Vector.of(1, 0));
		}
		if(keys[KeyEvent.VK_RIGHT]) {
		    player.moveInDirection(Vector.of(-1, 0));
		}
		player.update();
		
	}
	public void renderUsing(Graphics2D g){
		
	}
	public boolean isRunning(){
		return running;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = true;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = false;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
