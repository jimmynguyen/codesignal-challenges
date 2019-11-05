import java.util.stream.IntStream;

public class Candies {
	public static void main(String[] args) {
		int[] input0 = new int[] {3, 1, 10, 4, 4, 9, 8, 3, 7, 3};
		int[] input1 = new int[] {10, 2, 5, 4, 15, 100, 2, 3, 10, 23};
		int[] expectedOutput = new int[] {9, 2, 0, 4, 12, 99, 0, 3, 7, 21};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = candies(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("candies(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int candies(int n, int m) {
		return m / n * n;
	}
}
