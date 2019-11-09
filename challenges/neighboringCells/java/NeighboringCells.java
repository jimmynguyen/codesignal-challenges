import java.util.Arrays;
import java.util.stream.IntStream;

public class NeighboringCells {
	public static void main(String[] args) {
		int[][][] input0 = new int[][][] {{{0,0,0}, {0,0,0}, {0,0,0}}, {{0,0,0}}, {{0}, {0}, {0}, {0}}};
		int[][][] expectedOutput = new int[][][] {{{2,3,2}, {3,4,3}, {2,3,2}}, {{1,2,1}}, {{1}, {2}, {2}, {1}}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[][] actualOutput = neighboringCells(input0[i]);
			assert Arrays.deepEquals(actualOutput, expectedOutput[i]) : String.format("neighboringCells(%s) returned %s, but expected %s", Arrays.deepToString(input0[i]), Arrays.deepToString(actualOutput), Arrays.deepToString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[][] neighboringCells(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i-1 >= 0)
					matrix[i][j]++;
				if (i+1 < matrix.length)
					matrix[i][j]++;
				if (j-1 >= 0)
					matrix[i][j]++;
				if (j+1 < matrix[i].length)
					matrix[i][j]++;
			}
		}
		return matrix;
	}
}
