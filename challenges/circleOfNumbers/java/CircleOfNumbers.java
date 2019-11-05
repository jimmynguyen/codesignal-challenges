import java.util.stream.IntStream;

public class CircleOfNumbers {
	public static void main(String[] args) {
		int[] input0 = new int[] {10, 10, 4, 6, 18, 12, 18};
		int[] input1 = new int[] {2, 7, 1, 3, 6, 10, 5};
		int[] expectedOutput = new int[] {7, 2, 3, 0, 15, 4, 14};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = circleOfNumbers(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("circleOfNumbers(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int circleOfNumbers(int n, int firstNumber) {
		return (firstNumber + n / 2) % n;
	}
}
