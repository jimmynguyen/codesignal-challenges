import java.util.ArrayList;
import java.util.List;

public class Structure {
	private List<Cube> cubes;

	public Structure(Cube cube) {
		this.cubes = new ArrayList<>();
		this.addCube(cube);
	}

	public List<Cube> getCubes() {
		return this.cubes;
	}

	public void addCube(Cube cube) {
		if (this.cubes.isEmpty())
			this.cubes.add(cube);
		else {
			// check if cube is connected
			if (this.isAnyConnected(cube))
				this.cubes.add(cube);
		}
	}

	public boolean isAnyConnected(Cube cube) {
		return this.cubes.stream().filter(c -> c.isConnected(cube)).findAny().isPresent();
	}
}
