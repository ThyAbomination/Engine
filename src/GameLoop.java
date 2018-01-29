
public class GameLoop implements Runnable{

	private Game game;
	private GameCanvas gameCanvas;

	
	public GameLoop(Game game, GameCanvas gc){
		this.game = game;
		this.gameCanvas = gc;
	}
	@Override
	public void run() {
	
		int fps = 30;
		int msPerFrame = 1000/fps;
		int nanoSecond = 1000000000;
		
		while(game.isRunning()){
			long start = System.nanoTime();
			game.update();
			gameCanvas.render();
			long end = System.nanoTime();
			long timeTaken = end - start;
			Long msTaken = timeTaken / nanoSecond;
			long sleepTime = msPerFrame - msTaken;
			
				if(sleepTime > 0) {
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
	}
}
