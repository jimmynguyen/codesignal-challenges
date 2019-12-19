import java.util.Arrays;
import java.util.stream.IntStream;

public class Create2DArray {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 2, 0, 4}, {0, 0, 0}, {}};
		int[][][] expectedOutput = new int[][][] {{{0}, {0,1}, {}, {0,1,2,3}}, {{}, {}, {}}, {}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[][] actualOutput = create2DArray(input0[i]);
			assert Arrays.deepEquals(actualOutput, expectedOutput[i]) : String.format("create2DArray(%s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.deepToString(actualOutput), Arrays.deepToString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[][] create2DArray(int[] lengths) {
		int[][] output = new int[lengths.length][];
		for (int i = 0; i < lengths.length; i++) {
			output[i] = new int[lengths[i]];
			for (int j = 0; j < output[i].length; j++) {
				output[i][j] = j;
			}
		}
		return output;
	}
}
