import java.util.stream.IntStream;

public class FibonacciNumber {
	public static void main(String[] args) {
		int[] input0 = new int[] {2, 1, 7, 6, 4, 5, 13, 3};
		int[] expectedOutput = new int[] {1, 1, 13, 8, 3, 5, 233, 2};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = fibonacciNumber(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("fibonacciNumber(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int fibonacciNumber(int n) {
		int i = 2, prev = 1, curr = 1;
		while (i < n) {
			curr += prev;
			prev = curr - prev;
			i++;
		}
		return curr;
	}
}
