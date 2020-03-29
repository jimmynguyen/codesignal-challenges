import java.util.stream.IntStream;

public class CheckFactorial {
	public static void main(String[] args) {
		int[] input0 = new int[] {120, 25, 119, 121, 1, 2, 3, 5, 6, 24, 23};
		boolean[] expectedOutput = new boolean[] {true, false, false, false, true, true, false, false, true, true, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = checkFactorial(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("checkFactorial(%d) returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean checkFactorial(int n) {
		int k = 1, p = 1;
		while (n > p) {
			p *= k+1;
			k++;
		}
		return n == p;
	}
}
