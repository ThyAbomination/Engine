import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Entity {
	private Vector 	position = Vector.of(0, 0), 
					velocity = Vector.of(0, 0);
	private double speed;

	private BufferedImage image;
	
	public Entity(BufferedImage image){
		this.image = image;
	}
	public void moveInDirection(Vector vector){
	
		Vector destination = Vector.add(this.position, vector);
		moveTowards(destination);
	}
	
	public void moveTowards(Vector destination){
		Vector difference = Vector.subtract(destination, position);
		Vector unit = Vector.asUnit(difference);
		Vector movement = Vector.multiply(unit, speed);
		
		this.velocity = Vector.add(velocity, movement);
		
		this.update();
	}
	
	public void update(){
		this.position = Vector.add(position, velocity);
		this.velocity = Vector.of(0,0);	
	}
	public void renderUsing(Graphics2D gfx){
		gfx.drawImage(image, (int) this.position.getX(), (int) this.position.getY(), null);
	}

}
