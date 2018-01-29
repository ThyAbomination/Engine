
public final class Vector {

	private final double x, y, magnitude;
	
	private Vector(double x, double y){
		
		this.x = x;
		this.y = y;
		
		magnitude = Math.sqrt(x * x + y * y);
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public static Vector add(Vector first, Vector second){
		return new Vector(first.x + second.x, first.y + second.y);
	}
	
	public static Vector subtract(Vector first, Vector second){
		return new Vector(first.x - second.x, first.y - second.y);
	}

	public static Vector multiply(Vector vector, double scalar){
		return new Vector(vector.x * scalar, vector.y * scalar);
	}
	
	public static Vector asUnit(Vector vector){
		return new Vector(vector.x / vector.magnitude, vector.y / vector.magnitude);
	}
	public static Vector of(double x, double y){
		return new Vector(x, y);
	}
	
}
