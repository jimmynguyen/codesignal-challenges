import java.util.stream.IntStream;

public class LeastFactorial {
	public static void main(String[] args) {
		int[] input0 = new int[] {17, 1, 5, 25, 18, 109, 106, 11, 55, 24};
		int[] expectedOutput = new int[] {24, 1, 6, 120, 24, 120, 120, 24, 120, 24};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = leastFactorial(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("leastFactorial(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int leastFactorial(int n) {
		int k = 1;
		int m = 1;
		while (n > k)
			k *= m++;
		return k;
	}
}
