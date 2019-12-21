import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixTransposition {
	public static void main(String[] args) {
		int[][][] input0 = new int[][][] {{{1,1,3}, {2,1,1}}, {{1,1,1}, {0,0,0}}, {{1,3,4}}};
		int[][][] expectedOutput = new int[][][] {{{1,2}, {1,1}, {3,1}}, {{1,0}, {1,0}, {1,0}}, {{1}, {3}, {4}}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[][] actualOutput = matrixTransposition(input0[i]);
			assert Arrays.deepEquals(actualOutput, expectedOutput[i]) : String.format("matrixTransposition(%s) returned %s, but expected %s", Arrays.deepToString(input0[i]), Arrays.deepToString(actualOutput), Arrays.deepToString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[][] matrixTransposition(int[][] m) {
		int[][] t = new int[m[0].length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				t[j][i] = m[i][j];
			}
		}
		return t;
	}
}
