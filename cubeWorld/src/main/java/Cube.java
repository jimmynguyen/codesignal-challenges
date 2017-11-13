public class Cube {
	private int id;
	private int x;
	private int y;
	private int z;

	public Cube(int x, int y, int z) {
		this.id = Cube.getId(x, y, z);
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public static int getId(int x, int y, int z) {
		return String.format("%d,%d,%d", x, y, z).hashCode();
	}
}
