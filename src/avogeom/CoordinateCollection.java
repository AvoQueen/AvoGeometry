package avogeom;

import java.util.Arrays;

public class CoordinateCollection {
	public Coordinate[] coordinates;

	public CoordinateCollection(Coordinate... coordinates) {
		this.coordinates = coordinates;
	}

	public CoordinateCollection() {
		this.coordinates = new Coordinate[] {};
	}

	public CoordinateCollection(double[] coordinates) {
		this.coordinates = new Coordinate[(int) coordinates.length / 2];

		for (int i = 0; i < coordinates.length; i += 2) {
			this.coordinates[i / 2] = new Coordinate(coordinates[i], coordinates[i + 1]);
		}
	}

	public CoordinateCollection(double[][] coordinates) {
		this.coordinates = new Coordinate[coordinates.length];

		for (int i = 0; i < coordinates.length; i++) {
			this.coordinates[i] = new Coordinate(coordinates[i][0], coordinates[i][1]);
		}
	}

	public int amount() {
		return coordinates.length;
	}

	public double[][] toArray_double() {
		double[][] result = new double[coordinates.length][2];

		for (int i = 0; i < coordinates.length; i++) {
			result[i][0] = coordinates[i].x;
			result[i][1] = coordinates[i].y;
		}
		return result;
	}

	public double[] toArray() {
		double[] result = new double[coordinates.length * 2];

		for (int i = 0; i < coordinates.length; i++) {
			result[i * 2] = coordinates[i].x;
			result[i * 2 + 1] = coordinates[i].y;
		}
		return result;
	}

	public Coordinate[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinate[] coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coordinates);
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
		CoordinateCollection other = (CoordinateCollection) obj;
		if (!Arrays.equals(coordinates, other.coordinates))
			return false;
		return true;
	}
}
