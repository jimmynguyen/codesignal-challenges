import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseOnDiagonals {
	public static void main(String[] args) {
		int[][][] input0 = new int[][][] {{{1,2,3}, {4,5,6}, {7,8,9}}, {{239}}, {{1,10}, {100,1000}}, {{43,455,32,103}, {102,988,298,981}, {309,21,53,64}, {2,22,35,291}}, {{34,1000,139,248,972,584}, {98,1,398,128,762,654}, {33,498,132,543,764,43}, {329,12,54,764,666,213}, {928,109,489,71,837,332}, {93,298,42,53,76,43}}, {{1,1}, {2,2}}};
		int[][][] expectedOutput = new int[][][] {{{9,2,7}, {4,5,6}, {3,8,1}}, {{239}}, {{1000,100}, {10,1}}, {{291,455,32,2}, {102,53,21,981}, {309,298,988,64}, {103,22,35,43}}, {{43,1000,139,248,972,93}, {98,837,398,128,109,654}, {33,498,764,54,764,43}, {329,12,543,132,666,213}, {928,762,489,71,1,332}, {584,298,42,53,76,34}}, {{2,2}, {1,1}}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[][] actualOutput = reverseOnDiagonals(input0[i]);
			assert Arrays.deepEquals(actualOutput, expectedOutput[i]) : String.format("reverseOnDiagonals(%s) returned %s, but expected %s", Arrays.deepToString(input0[i]), Arrays.deepToString(actualOutput), Arrays.deepToString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int[][] reverseOnDiagonals(int[][] a) {
		int n = a.length;
		int[][] b = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					b[i][i] = a[n-i-1][n-i-1];
				} else if (j == n-1-i) {
					b[i][j] = a[j][i];
				} else {
					b[i][j] = a[i][j];
				}
			}
		}
		return b;
	}
}
