import java.util.stream.IntStream;

public class ArithmeticExpression {
	public static void main(String[] args) {
		int[] input0 = new int[] {2, 8, 8, 6, 18, 2, 5, 10, 5, 1, 1};
		int[] input1 = new int[] {3, 2, 3, 3, 2, 3, 2, 2, 2, 2, 2};
		int[] input2 = new int[] {5, 4, 2, 3, 9, 6, 0, 2, 2, 1, 2};
		boolean[] expectedOutput = new boolean[] {true, true, false, true, true, true, false, false, false, false, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = arithmeticExpression(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("arithmeticExpression(%d, %d, %d) returned %b, but expected %b", input0[i], input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean arithmeticExpression(int a, int b, int c) {
		return a + b == c || a - b == c || a * b == c || (double)a / b == c;
	}
}
