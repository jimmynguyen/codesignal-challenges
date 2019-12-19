import java.util.stream.IntStream;

public class AreSimilarNumbers {
	public static void main(String[] args) {
		int[] input0 = new int[] {10, 10, 5, 5, 2, 121, 100, 21, 54, 26, 78};
		int[] input1 = new int[] {12, 12, 7, 15, 21, 33, 100, 4, 27, 7, 39};
		int[] input2 = new int[] {2, 3, 2, 5, 2, 11, 3, 4, 6, 14, 10};
		boolean[] expectedOutput = new boolean[] {true, false, true, true, false, true, true, false, false, true, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = areSimilarNumbers(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("areSimilarNumbers(%d, %d, %d) returned %b, but expected %b", input0[i], input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean areSimilarNumbers(int a, int b, int d) {
		return a%d == 0 && b%d == 0 || a%d != 0 && b%d != 0;
	}
}
