import java.util.stream.IntStream;

public class IsInRange {
	public static void main(String[] args) {
		int[] input1 = new int[] {3, 0, 12, 12, 12, 12, 13, 1, 0, 40};
		int[] input2 = new int[] {2, 1, 22, 21, 22, 32, 3, 0, 2, 40};
		int[] input3 = new int[] {4, 1, 21, 21, 23, 21, 14, 2, 2, 40};
		boolean[] expectedOutput = new boolean[] {false, true, false, true, true, false, false, false, true, true};
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		assert input3.length == expectedOutput.length : String.format("# input3 = %d, # expectedOutput = %d", input3.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = isInRange(input1[i], input2[i], input3[i]);
			assert actualOutput == expectedOutput[i] : String.format("isInRange(\"%d\", \"%d\", \"%d\") returned %b, but expected %b", input1[i], input2[i], input3[i], actualOutput, expectedOutput[i]);
		});
	}

	public static boolean isInRange(int input1, int input2, int input3) {
		return input1 <= input2 && input2 <= input3;
	}
}
