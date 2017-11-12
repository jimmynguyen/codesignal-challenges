import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CubeTest {
	private static Cube cube, connectedCube, notConnectedCube;

	@BeforeAll
	static void setUp() {
		cube = new Cube(new int[] {0, 0, 0, 2});
		connectedCube = new Cube(new int[] {1, 1, 1, 2});
		notConnectedCube = new Cube(new int[] {2, 2, 2, 2});
	}

	@Test
	void when_getBottomLeftCorner_for_valid_then_returnBottomLeftCorner() {
		assertArrayEquals(cube.getBottomLeftCorner(), new int[] {0, 0, 0});
	}

	@Test
	void when_getTopRightCorner_for_valid_then_returnTopRightCorner() {
		assertArrayEquals(cube.getTopRightCorner(), new int[] {2, 2, 2});
	}

	@Test
	void when_isConnected_for_valid_then_returnTrue() {
		assertTrue(cube.isConnected(connectedCube));
	}

	@Test
	void when_isConnected_for_invalid_then_returnFalse() {
		assertFalse(cube.isConnected(notConnectedCube));
	}
}
