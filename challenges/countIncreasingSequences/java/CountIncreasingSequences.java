import java.util.stream.IntStream;

public class CountIncreasingSequences {
	public static void main(String[] args) {
		int[] input0 = new int[] {2, 1};
		int[] input1 = new int[] {3, 4};
		int[] expectedOutput = new int[] {3, 4};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = countIncreasingSequences(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("countIncreasingSequences(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int countIncreasingSequences(int n, int k) {
		return (int) (factorial(k) / factorial(n) / factorial(k - n));
	}

	private static double factorial(int n) {
		int f = 1;
		for (int i = 2; i <= n; i++)
			f *= i;
		return (double) f;
	}
}
