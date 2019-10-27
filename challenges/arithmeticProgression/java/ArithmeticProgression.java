import java.util.stream.IntStream;

public class ArithmeticProgression {
	public static void main(String[] args) {
		int[] input0 = new int[] {3, 2};
		int[] input1 = new int[] {2, 2};
		int[] input2 = new int[] {4, 10000};
		int[] expectedOutput = new int[] {0, 2};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = arithmeticProgression(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("arithmeticProgression(%d, %d, %d) returned %d, but expected %d", input0[i], input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int arithmeticProgression(int element1, int element2, int n) {
		int difference = element2 - element1;
		for (int i = 3; i <= n; i++) {
			element2 += difference;
		}
		return n == 1 ? element1 : element2;
	}
}
