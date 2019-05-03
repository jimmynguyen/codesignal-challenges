import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSubmatrixSum {
	public static void main(String[] args) {
		int[][][] input0 = new int[][][] {{{1,12,11,10}, {4,3,2,9}, {5,6,7,8}}, {{1,2,-1}, {-4,-8,3}}, {{0,-1}}, {{1,2,1,3}, {1,1,1,1}, {2,2,2,2}}, {{1,-1}, {0,0}, {2,-1}, {3,-10}}};
		int[] input1 = new int[] {2, 2, 1, 3, 1};
		int[] input2 = new int[] {1, 2, 1, 2, 2};
		int[] expectedOutput = new int[] {19, -4, 0, 10, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = maxSubmatrixSum(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("maxSubmatrixSum(%s, %d, %d) returned %d, but expected %d", Arrays.deepToString(input0[i]), input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int maxSubmatrixSum(int[][] matrix, int n, int m) {
		int N = matrix.length;
		int M = matrix[0].length;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < N-n+1; i++) {
			for (int j = 0; j < M-m+1; j++) {
				int currentSum = getSubmatrixSum(matrix, n, m, i, j);
				if (currentSum > maxSum) {
					maxSum = currentSum;
				}
			}
		}
		return maxSum;
	}

	private static int getSubmatrixSum(int[][] matrix, int n, int m, int i, int j) {
		int sum = 0;
		for (int r = i; r < i+n; r++) {
			for (int c = j; c < j+m; c++) {
				sum += matrix[r][c];
			}
		}
		return sum;
	}
}
