import java.util.stream.IntStream;

public class Factorial {
	public static void main(String[] args) {
		int[] input0 = new int[] {5, 0};
		int[] expectedOutput = new int[] {120, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = factorial(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("factorial(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}
