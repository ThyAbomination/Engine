import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class GameCanvas extends Canvas{

	private Game game;
	private int w, h;
	public GameCanvas(Game game, int w, int h){
		this.game = game;
		this.w = w;
		this.h = h;
		setPreferredSize(new Dimension(w, h));
		addKeyListener(game);
	}
	public void render(){
		BufferStrategy buffer = getBufferStrategy();
		Graphics2D graphics = (Graphics2D) buffer.getDrawGraphics();
		clear(graphics);
		game.renderUsing(graphics);

		graphics.dispose();
		buffer.show();
	}
	private void clear(Graphics2D gfx){
		gfx.setColor(Color.LIGHT_GRAY);
		gfx.fillRect(0, 0, w, h);
	}
	
}
