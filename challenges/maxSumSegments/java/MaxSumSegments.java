import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSumSegments {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{-1, 2, 1, 3, -2}, {3, -3, 2, 2, 1, -5, 0}, {-1, -1, -1, -1}};
		int[][] expectedOutput = new int[][] {{3, 2, 1, 0, 0}, {0, 2, 2, 0, 0, 0, 0}, {0, 0, 0, 0}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = maxSumSegments(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("maxSumSegments(%s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int[] maxSumSegments(int[] a) {
		int n = a.length;
		int[][] s = new int[n][n];
		for (int i = 0; i < n; i++) {
			s[i][i] = a[i];
			for (int j = i+1; j < n; j++) {
				s[i][j] = s[i][j-1] + a[j];
			}
		}
		int max, ndx = 0;
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			max = Integer.MIN_VALUE;
			for (int j = 0; j < n-i; j++) {
				if (max < s[j][j+i]) {
					max = s[j][j+i];
					ndx = j;
				}
			}
			b[i] = ndx;
		}
		return b;
	}
}
