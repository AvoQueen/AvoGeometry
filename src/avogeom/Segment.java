package avogeom;

import debug_scene.DebugScene;

public class Segment extends VisibleGeometry {

	protected double ax, ay;
	protected double bx, by;

	public Segment(double ax, double ay, double bx, double by) {
		this.type = Type.LINE;

		this.ax = ax;
		this.ay = ay;
		this.bx = bx;
		this.by = by;
	}

	@Override
	public void show() {
		DebugScene.ctx.setStroke(c);
		DebugScene.ctx.strokeLine(ax, ay, bx, by);
	}

	@Override
	public int dimensions() {
		return 1;
	}

	public Coordinate getCenter() {
		return new Coordinate((ax + bx) / 2, (ay + by) / 2);
	}

	public Vector2f heading() {
		return new Vector2f(bx - ax, by - ay);
	}

	public Vector2f getStart() {
		return new Vector2f(ax, ay);
	}

	public Vector2f getEnd() {
		return new Vector2f(bx, by);
	}

	public Line getLine() {
		return new Line(ax, ay, bx, by);
	}

	public boolean intersects(Segment s) {
		final Vector2f start1 = getStart();
		final Vector2f dir1 = heading();
		
		final Vector2f start2 = s.getStart();
		final Vector2f dir2 = s.heading();

		double parameterA = (start2.crossP(dir2) - start1.crossP(dir2)) / dir1.crossP(dir2);
		double parameterB = (start1.crossP(dir1) - start2.crossP(dir1)) / dir2.crossP(dir1);

		return (parameterA > 0d && parameterA < 1d && parameterB > 0d && parameterB < 1d);
	}

	public boolean _intersects(Segment s) {

		double paramA = ((s.ax * (s.by - s.ay) - s.ay * (s.bx - s.ax)) - (ax * (s.by - s.ay) - ay * (s.bx - s.ax)))
				/ ((bx - ax) * (s.by - s.ay) - (by - ay) * (s.bx - s.ax));
		
		double paramB = ((ax * (by - ay) - ay * (bx - ax)) - (s.ax * (by - ay) - s.ay * (bx - ax)))
				/ ((s.bx - s.ax) * (by - ay) - (s.by - s.ay) * (bx - ax));
		
		return (paramA > 0d && paramA < 1d && paramB > 0d && paramB < 1d);
	}

}
