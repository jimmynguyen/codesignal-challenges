import java.util.Arrays;
import java.util.stream.IntStream;

public class ReplaceMiddle {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{7, 2, 2, 5, 10, 7}, {-5, -5, 10}, {45, 23, 12, 33, 12, 453, -234, -45}, {2, 8}, {-12, 34, 40, -5, -12, 4, 0, 0, -12}, {9, 0, 15, 9}, {-6, 6, -6}, {26, 26, -17}, {-7, 5, 5, 10}};
		int[][] expectedOutput = new int[][] {{7, 2, 7, 10, 7}, {-5, -5, 10}, {45, 23, 12, 45, 453, -234, -45}, {10}, {-12, 34, 40, -5, -12, 4, 0, 0, -12}, {9, 15, 9}, {-6, 6, -6}, {26, 26, -17}, {-7, 10, 10}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = replaceMiddle(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("replaceMiddle(%s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[] replaceMiddle(int[] arr) {
		int L = arr.length;
		if (L%2 != 0) {
			return arr;
		}
		int M = arr.length/2;
		int[] out = new int[L-1];
		for (int i = 0; i < M-1; i++) {
			out[i] = arr[i];
		}
		out[M-1] = arr[M-1] + arr[M];
		for (int i = M+1; i < L; i++) {
			out[i-1] = arr[i];
		}
		return out;
	}
}
