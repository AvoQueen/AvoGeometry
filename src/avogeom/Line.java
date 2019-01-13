package avogeom;

import debug_scene.DebugScene;

public class Line extends VisibleGeometry {

	public Vector2f start, end;

	public Line(double ax, double ay, double bx, double by) {
		this.type = Type.LINE;

		start = new Vector2f(ax, ay);
		end = new Vector2f(bx, by);
	}

	public void setStart(double x, double y) {
		start.x = x;
		start.y = y;
	}

	public void setStart(Vector2f v) {
		start = v.copy();
	}

	public void setEnd(double x, double y) {
		end.x = x;
		end.y = y;
	}

	public void setEnd(Vector2f v) {
		end = v.copy();
	}

	public Vector2f getStart() {
		return start;
	}

	public Vector2f getEnd() {
		return end;
	}

	public Segment getSegment() {
		return new Segment(start.x, start.y, end.x, end.y);
	}

	public Vector2f getCenter() {
		return new Vector2f((start.x + end.x) / 2, (start.y + end.y) / 2);
	}

	public void setCenter(double x, double y) {
		Vector2f currentCenter = getCenter();

		Vector2f centerToStart = Vector2f.sub(start, currentCenter);
		Vector2f centerToEnd = Vector2f.sub(end, currentCenter);

		start = centerToStart.add(x, y);
		end = centerToEnd.add(x, y);
	}

	public void setCenter(Vector2f v) {
		Vector2f currentCenter = getCenter();

		Vector2f centerToStart = Vector2f.sub(currentCenter, start);
		Vector2f centerToEnd = Vector2f.sub(currentCenter, end);

		start = centerToStart.add(v);
		end = centerToEnd.add(v);
	}

	public Vector2f heading() {
		return Vector2f.sub(end, start);
	}

	public boolean intersects(Line l) {
		final Vector2f dir1 = heading(), dir2 = l.heading();

		double parameterA = (l.start.crossP(dir2) - start.crossP(dir2)) / dir1.crossP(dir2);
		double parameterB = (start.crossP(dir1) - l.start.crossP(dir1)) / dir2.crossP(dir1);
		
		return (parameterA > 0d && parameterA < 1d && parameterB > 0d && parameterB < 1d);
	}

	public double getLenght() {
		double dx = start.x - end.x;
		double dy = start.y - end.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	@Override
	public void show() {
		DebugScene.ctx.setStroke(c);
		DebugScene.ctx.strokeLine(start.x, start.y, end.x, end.y);
	}

	@Override
	public int dimensions() {
		return 1;
	}
}
