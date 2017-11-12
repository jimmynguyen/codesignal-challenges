public class Cube {
	private int[] bottomLeftCorner;
	private int[] topRightCorner;

	public Cube(int[] cube) {
		int x = cube[0];
		int y = cube[1];
		int z = cube[2];
		int r = cube[3];
		this.bottomLeftCorner = new int[] {x, y, z};
		this.topRightCorner   = new int[] {x+r, y+r, z+r};
	}

	public int[] getBottomLeftCorner() {
		return this.bottomLeftCorner;
	}

	public int[] getTopRightCorner() {
		return this.topRightCorner;
	}

	public boolean isConnected(Cube cube) {
		return this.isInRange(cube.getBottomLeftCorner()) || this.isInRange(cube.getTopRightCorner());
	}

	private boolean isInRange(int[] corner) {
		boolean isXInRange = this.bottomLeftCorner[0] < corner[0] && corner[0] < this.topRightCorner[0];
		boolean isYInRange = this.bottomLeftCorner[1] < corner[1] && corner[1] < this.topRightCorner[1];
		boolean isZInRange = this.bottomLeftCorner[2] < corner[2] && corner[2] < this.topRightCorner[2];
		return isXInRange && isYInRange && isZInRange;
	}
}
