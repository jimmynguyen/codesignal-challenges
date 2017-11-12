import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StructureTest {
	private static Cube connectedCube1, connectedCube2, notConnectedCube;
	private Structure structure;

	@BeforeAll
	static void setUpBeforeAll() {
		connectedCube1 = new Cube(new int[] {1, 1, 1, 2});
		connectedCube2 = new Cube(new int[] {2, 2, 2, 2});
		notConnectedCube = new Cube(new int[] {3, 3, 3, 2});
	}

	@BeforeEach
	void setUp() {
		structure = new Structure(new Cube(new int[] {0, 0, 0, 2}));
	}

	@Test
	void when_getCubes_for_valid_then_returnCubes() {
		assertEquals(1, structure.getCubes().size());
	}

	@Test
	void when_addCube_for_connectedCube_then_addCube() {
		structure.addCube(connectedCube1);
		assertEquals(2, structure.getCubes().size());
	}

	@Test
	void when_addCube_for_notConnectedCube_then_doNotAddCube() {
		structure.addCube(notConnectedCube);
		assertEquals(1, structure.getCubes().size());
	}

	@Test
	void when_isAnyConnected_for_connectedCube_then_returnTrue() {
		// check that "any" is working by adding another cube
		structure.addCube(connectedCube1);
		assertTrue(structure.isAnyConnected(connectedCube2));
	}

	@Test
	void when_isAnyConnected_for_notConnectedCube_then_returnFalse() {
		// check that "any" is working by adding another cube
		structure.addCube(connectedCube1);
		assertFalse(structure.isAnyConnected(notConnectedCube));
	}
}