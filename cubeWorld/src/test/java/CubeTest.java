import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeTest {
	private static Cube cube;

	@BeforeAll
	static void setUp() {
		cube = new Cube(0, 1, 2);
	}

	@Test
	void when_getId_for_valid_then_returnId() {
		assertEquals(String.format("0,1,2").hashCode(), cube.getId());
	}

	@Test
	void when_staticGetId_for_valid_then_returnId() {
		assertEquals(String.format("0,1,2").hashCode(), Cube.getId(0, 1, 2));
	}

	@Test
	void when_getX_for_valid_then_returnX() {
		assertEquals(0, cube.getX());
	}

	@Test
	void when_getY_for_valid_then_returnY() {
		assertEquals(1, cube.getY());
	}

	@Test
	void when_getZ_for_valid_then_returnZ() {
		assertEquals(2, cube.getZ());
	}
}
