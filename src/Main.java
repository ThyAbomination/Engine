import java.awt.EventQueue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws IOException, InvocationTargetException, InterruptedException {
	int width = 350, height = 350;
	
	Game game = new Game(width, height);
	GameCanvas canvas = new GameCanvas(game, width, height);
	
	EventQueue.invokeAndWait(() -> new GameFrame(canvas).setVisible(true));
	GameLoop loop = new GameLoop(game, canvas);
	loop.run();
	}

}
