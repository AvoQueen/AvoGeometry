package avogeom;

import javafx.scene.paint.Color;

public abstract class VisibleGeometry {
	public static final Color c = Color.BLACK;
	protected Type type = Type.UNDEFINED;

	public abstract void show();

	public abstract int dimensions();

	public Type getType(int typeIndex) {
		try {
			return Type.values()[typeIndex];
		} catch (ArrayIndexOutOfBoundsException e) {
			return Type.UNDEFINED;
		}
	}
	
	public Type getType() {
		return type;
	}

	public enum Type {
		POINT, MULTIPOINT, LINE, MULTILINE, POLYGON, MULTIPOLYGON, UNDEFINED
	}
}
