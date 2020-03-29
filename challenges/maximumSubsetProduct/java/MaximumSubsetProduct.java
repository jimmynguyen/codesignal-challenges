import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumSubsetProduct {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 2, -2, -3, 3, 5}, {10, -10}, {1, -1, -1, 1}, {3, 2, 1, 5, 10}, {-1, -1, 2, 3, 4, 5}, {-4, -2, 10, 20, -3}, {-1}, {1000000000, -1000000000}};
		int[] expectedOutput = new int[] {1, -10, 1, 1, 1, -2, 1, -1000000000};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = maximumSubsetProduct(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("maximumSubsetProduct(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int maximumSubsetProduct(int[] arr) {
		boolean neg = false;
		int max_neg = Integer.MIN_VALUE;
		for (int x : arr) {
			if (x < 0) {
				neg = !neg;
			}
			if (x < 0 && max_neg < x) {
				max_neg = x;
			}
		}
		return neg && arr.length > 1 ? max_neg : 1;
	}
}
