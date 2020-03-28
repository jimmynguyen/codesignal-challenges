import java.util.stream.IntStream;

public class IsPrime {
	public static void main(String[] args) {
		int[] input0 = new int[] {47, 4, 133, 2, 120, 13, 42, 500, 101, 121};
		boolean[] expectedOutput = new boolean[] {true, false, false, true, false, true, false, false, true, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = isPrime(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("isPrime(%d) returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
}
