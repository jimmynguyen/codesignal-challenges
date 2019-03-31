import java.util.stream.IntStream;

public class MaxMultiple {
	public static void main(String[] args) {
		int[] input0 = new int[] {3, 2, 10, 7, 7, 5, 8, 10, 2, 3, 9, 8, 9};
		int[] input1 = new int[] {10, 7, 50, 100, 20, 13, 88, 100, 5, 5, 11, 15, 60};
		int[] expectedOutput = new int[] {9, 6, 50, 98, 14, 10, 88, 100, 4, 3, 9, 8, 54};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = maxMultiple(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("maxMultiple(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
	}

	public static int maxMultiple(int d, int b) {
		while (b >= 1)
			if (b%d==0)
				break;
			else
				b--;
		return b;
	}
}
