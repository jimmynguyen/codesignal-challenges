public class CubeWorld {
	private int[][] cubes;
	private int largestStructureVolume;

	public CubeWorld(int[][] cubes) {
		this.cubes = cubes;
		this.largestStructureVolume = this.computeLargestStructureVolume();
	}

	public int getLargestStructureVolume() {
		return this.largestStructureVolume;
	}

	private int computeLargestStructureVolume() {
		return -1;
	}
}
