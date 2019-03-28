import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StructureTest {
	private static int[] connectedCube, notConnectedCube;
	private Structure structure;

	@BeforeAll
	static void setUpBeforeAll() {
		connectedCube = new int[] {1, 1, 1, 2};
		notConnectedCube = new int[] {3, 3, 3, 2};
	}

	@BeforeEach
	void setUp() {
		structure = new Structure(new int[] {0, 0, 0, 2});
	}

	@Test
	void when_getCubes_for_valid_then_returnCubes() {
		int id;
		Set<Integer> cubes = new HashSet<>();
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++) {
					id = Cube.getId(i, j , k);
					if (!cubes.contains(id))
						cubes.add(id);
				}
		assertEquals(cubes, structure.getCubes().keySet());
	}

	@Test
	void when_getVolume_for_valid_then_returnVolume() {
		assertEquals(8, structure.getVolume());
	}

	@Test
	void when_addCube_for_valid_then_addCube() {
		structure.addCube(connectedCube);
		assertEquals(15, structure.getVolume());
	}

	@Test
	void when_isConnected_for_connectedCube_then_returnTrue() {
		assertTrue(structure.isConnected(connectedCube));
	}

	@Test
	void when_isConnected_for_notConnectedCube_then_returnFalse() {
		assertFalse(structure.isConnected(notConnectedCube));
	}
}