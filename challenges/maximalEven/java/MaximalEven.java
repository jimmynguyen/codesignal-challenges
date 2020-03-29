import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximalEven {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{4, 3, 6, 8, 2, 4}, {10, 2}, {7, 2}, {1, 4, 2, 4, 10}};
		int[] expectedOutput = new int[] {8, 10, 2, 10};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = maximalEven(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("maximalEven(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int maximalEven(int[] a) {
		int n = Integer.MIN_VALUE;
		for (int x : a) {
			if (n < x && x%2 == 0) {
				n = x;
			}
		}
		return n;
	}
}
