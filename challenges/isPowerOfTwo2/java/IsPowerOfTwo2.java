import java.util.stream.IntStream;

public class IsPowerOfTwo2 {
	public static void main(String[] args) {
		long[] input0 = new long[] {64, 5, 1, 16, 7, 17179869184L, 34359738368L, 68719476736L, 41, 239, 137438953472L};
		boolean[] expectedOutput = new boolean[] {true, false, true, true, false, true, true, true, false, false, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = isPowerOfTwo2(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("isPowerOfTwo2(%s) returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean isPowerOfTwo2(long n) {
		while (n%2 == 0) {
			n /= 2;
		}
		return n == 1;
	}
}
