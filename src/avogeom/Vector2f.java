package avogeom;

public class Vector2f extends Coordinate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Vector2f(double x, double y) {
		super(x, y);
	}

	public Vector2f(Coordinate c) {
		super(c);
	}

	public Vector2f add(Coordinate c) {
		x += c.x;
		y += c.y;
		return this;
	}

	public Vector2f sub(Coordinate c) {
		x -= c.x;
		y -= c.y;
		return this;
	}

	public Vector2f mult(Coordinate c) {
		x *= c.x;
		y *= c.y;
		return this;
	}

	public Vector2f div(Coordinate c) {
		x /= c.x;
		y /= c.y;
		return this;
	}
	
	public Vector2f add(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2f sub(double x, double y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector2f mult(double x, double y) {
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector2f div(double x, double y) {
		this.x /= x;
		this.y /= y;
		return this;
	}

	public static Vector2f add(Coordinate c1, Coordinate c2) {
		return new Vector2f(c1.x + c2.x, c1.y + c2.y);
	}

	public static Vector2f sub(Coordinate c1, Coordinate c2) {
		return new Vector2f(c1.x - c2.x, c1.y - c2.y);
	}

	public static Vector2f mult(Coordinate c1, Coordinate c2) {
		return new Vector2f(c1.x * c2.x, c1.y * c2.y);
	}

	public static Vector2f div(Coordinate c1, Coordinate c2) {
		return new Vector2f(c1.x / c2.x, c1.y / c2.y);
	}
	
	public double crossP(Coordinate c) {
		return this.x * c.y - this.y * c.x;
	}
	
	public double dotP(Coordinate c) {
		return x * c.x + y * c.y;
	}
	
	@Override
	public Vector2f copy() {
		return new Vector2f(x, y);
	}
}
