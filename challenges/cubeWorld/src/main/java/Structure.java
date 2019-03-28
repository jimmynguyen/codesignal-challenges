import java.util.HashMap;
import java.util.Map;

public class Structure {
	private Map<Integer, Cube> cubes;

	public Structure() {
		cubes = new HashMap<>();
	}

	public Structure(int[] cube) {
		this();
		addCube(cube);
	}

	public void addCube(int[] cube) {
		int x = cube[0];
		int y = cube[1];
		int z = cube[2];
		int r = cube[3];
		int id;
		for (int k = z; k < z+r; k++)
			for (int j = y; j < y+r; j++)
				for (int i = x; i < x+r; i++) {
					id = Cube.getId(i, j, k);
					if (!cubes.containsKey(id))
						cubes.put(id, new Cube(i, j, k));
				}
	}

	public Map<Integer, Cube> getCubes() {
		return cubes;
	}

	public int getVolume() {
		return cubes.size();
	}

	public boolean isConnected(int[] cube) {
		int x = cube[0];
		int y = cube[1];
		int z = cube[2];
		int r = cube[3];
		int id;
		for (int k = z; k < z+r; k++)
			for (int j = y; j < y+r; j++)
				for (int i = x; i < x+r; i++) {
					id = Cube.getId(i, j, k);
					if (cubes.containsKey(id))
						return true;
				}
		return false;
	}
}
