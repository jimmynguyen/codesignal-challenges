import java.util.stream.IntStream;

public class MaxDivisor {
	public static void main(String[] args) {
		int[] input0 = new int[] {1, 6, -99};
		int[] input1 = new int[] {10, 7, -96};
		int[] input2 = new int[] {3, 2, 5};
		int[] expectedOutput = new int[] {9, 6, -1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = maxDivisor(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("maxDivisor(%d, %d, %d) returned %d, but expected %d", input0[i], input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int maxDivisor(int left, int right, int divisor) {
		for (int n = right; n >= left; n--) {
			if (n%divisor == 0) {
				return n;
			}
		}
		return -1;
	}
}
