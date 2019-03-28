import java.util.ArrayList;
import java.util.List;

public class CubeWorld {
	public static int getLargestStructureVolume(int[][] cubes) {
		List<Structure> structures = new ArrayList<>();
		List<Structure> connectedStructures = new ArrayList<>();
		boolean isAnyConnected;
		for (int i = 0; i < cubes.length; i++) {
			isAnyConnected = false;
			connectedStructures.clear();
			for (Structure structure : structures) {
				if (structure.isConnected(cubes[i])) {
					isAnyConnected = true;
					structure.addCube(cubes[i]);
					connectedStructures.add(structure);
				}
			}
			if (!isAnyConnected) {
				structures.add(new Structure(cubes[i]));
			}
			if (connectedStructures.size() > 1) {
				Structure structure = connectedStructures.get(0);
				for (int j = 1; j < connectedStructures.size(); j++) {
					structure.getCubes().putAll(connectedStructures.get(j).getCubes());
				}
			}
		}
		return structures.stream().map(Structure::getVolume).mapToInt(Integer::intValue).max().getAsInt();
	}
}
