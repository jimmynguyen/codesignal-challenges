import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSubarray {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{-1, 7, -2, 3, 4, 0, 1, -1}, {-1, -2, -5, -1}, {1, -1, 2, 3, -1}};
		int[] expectedOutput = new int[] {13, 0, 5};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = maxSubarray(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("maxSubarray(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int maxSubarray(int[] arr) {
		int[][] sum = new int[arr.length][arr.length];
		int maxSum = arr[0];
		for (int i = 0; i < arr.length; i++) {
			sum[i][i] = arr[i];
			if (maxSum < sum[i][i])
				maxSum = sum[i][i];
			for (int j = i+1; j < arr.length; j++) {
				sum[i][j] = sum[i][j-1] + arr[j];
				if (maxSum < sum[i][j])
					maxSum = sum[i][j];
			}
		}
		return maxSum < 0 ? 0 : maxSum;
	}
}
