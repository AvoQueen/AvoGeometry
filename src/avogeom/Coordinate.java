package avogeom;

import java.io.Serializable;
import debug_scene.DebugScene;
import javafx.scene.shape.ArcType;

public class Coordinate extends VisibleGeometry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int X = 0;
	public static final int Y = 1;

	protected double x;
	protected double y;

	public Coordinate(double x, double y) {
		this.type = Type.POINT;
		this.x = x;
		this.y = y;
	}

	public Coordinate(Coordinate c) {
		this.type = Type.POINT;
		this.x = c.x;
		this.x = c.y;
	}

	public Coordinate copy() {
		return new Coordinate(x, y);
	}

	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void set(Coordinate c) {
		x = c.x;
		y = c.y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double distance(Coordinate c) {
		double dx = x - c.x;
		double dy = y - c.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double distance(double x, double y) {
		double dx = this.x - x;
		double dy = this.y - y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double distanceSq(Coordinate c) {
		double dx = x - c.x;
		double dy = y - c.y;
		return dx * dx + dy * dy;
	}

	public double distanceSq(double x, double y) {
		double dx = this.x - x;
		double dy = this.y - y;
		return dx * dx + dy * dy;
	}

	public double getOrdinate(int ordinateIndex) {
		switch (ordinateIndex) {
		case X:
			return x;
		case Y:
			return y;
		}
		throw new IllegalArgumentException("Invalid ordinate index: " + ordinateIndex);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public void show() {
		DebugScene.ctx.setFill(c);
		DebugScene.ctx.fillArc(x, y, 2, 2, 0, 360, ArcType.CHORD);
	}

	@Override
	public int dimensions() {
		return 0;
	}

	public void log() {
		System.out.println("( X:" + x + " | Y:" + y + " )");
	}

	@Override
	public String toString() {
		return "( X:" + x + " | Y:" + y + " )";
	}

}
