import javax.swing.JFrame;

public class GameFrame extends JFrame {
	private GameCanvas gameCanvas;
	public GameFrame(GameCanvas gc){
		this.gameCanvas = gc;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.add(gc);
		this.pack();
	}
	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if(b) this.gameCanvas.createBufferStrategy(3);
	}
}
