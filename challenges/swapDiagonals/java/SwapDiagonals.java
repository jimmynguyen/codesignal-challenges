import java.util.Arrays;
import java.util.stream.IntStream;

public class SwapDiagonals {
	public static void main(String[] args) {
		int[][][] input0 = new int[][][] {{{1,2,3}, {4,5,6}, {7,8,9}}, {{239}}, {{1,10}, {100,1000}}, {{43,455,32,103}, {102,988,298,981}, {309,21,53,64}, {2,22,35,291}}, {{34,1000,139,248,972,584}, {98,1,398,128,762,654}, {33,498,132,543,764,43}, {329,12,54,764,666,213}, {928,109,489,71,837,332}, {93,298,42,53,76,43}}, {{1,2}, {1,2}}};
		int[][][] expectedOutput = new int[][][] {{{3,2,1}, {4,5,6}, {9,8,7}}, {{239}}, {{10,1}, {1000,100}}, {{103,455,32,43}, {102,298,988,981}, {309,53,21,64}, {291,22,35,2}}, {{584,1000,139,248,972,34}, {98,762,398,128,1,654}, {33,498,543,132,764,43}, {329,12,764,54,666,213}, {928,837,489,71,109,332}, {43,298,42,53,76,93}}, {{2,1}, {2,1}}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[][] actualOutput = swapDiagonals(input0[i]);
			assert Arrays.deepEquals(actualOutput, expectedOutput[i]) : String.format("swapDiagonals(%s) returned %s, but expected %s", Arrays.deepToString(input0[i]), Arrays.deepToString(actualOutput), Arrays.deepToString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int[][] swapDiagonals(int[][] matrix) {
		int n = matrix.length, m;
		for (int i = 0; i < n; i++) {
			m = matrix[i][i];
			matrix[i][i] = matrix[i][n-i-1];
			matrix[i][n-i-1] = m;
		}
		return matrix;
	}
}
