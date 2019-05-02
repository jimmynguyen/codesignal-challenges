import java.util.stream.IntStream;

public class pagesNumberingWithInk {
	public static void main(String[] args) {
		int[] input0 = new int[] {1, 21, 8, 21, 76, 80};
		int[] input1 = new int[] {5, 5, 4, 6, 250, 1000};
		int[] expectedOutput = new int[] {5, 22, 10, 23, 166, 419};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = pagesNumberingWithInk(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("pagesNumberingWithInk(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int pagesNumberingWithInk(int current, int numberOfDigits) {
		int currentNumberOfDigits = Integer.toString(current).length();
		while (numberOfDigits >= currentNumberOfDigits) {
			numberOfDigits -= currentNumberOfDigits;
			currentNumberOfDigits = Integer.toString(current++).length();
		}
		return current-1;
	}
}
