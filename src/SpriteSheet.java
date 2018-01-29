import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private Map<String, BufferedImage> images;
	
	private SpriteSheet(Map<String, BufferedImage> images){


	}
public BufferedImage get(String key){return this.images.get(key);}

public static SpriteSheet cut(String fileName, int spriteWidth, int spriteHeight) throws IOException{ 
	
	BufferedImage sheet = ImageIO.read(SpriteSheet.class.getResourceAsStream(fileName));
	
	Map<String, BufferedImage> images = new HashMap();
	
	int columns = sheet.getWidth() / spriteHeight;
    int rows = sheet.getHeight() / spriteWidth;
	
	for(int column = 0; column <= columns;++column){
		for(int row = 0; row <= rows; ++row){
			BufferedImage image = sheet.getSubimage(row * spriteWidth, column * spriteHeight, spriteWidth, spriteHeight);
			

		String key = Integer.toString(column + row * columns);
		images.put(key, image);
		}
	}
	
	return new SpriteSheet(images);
	//test
	}
}
