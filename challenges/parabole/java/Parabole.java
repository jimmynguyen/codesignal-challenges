import java.util.stream.IntStream;

public class Parabole {
	public static void main(String[] args) {
		int[] input0 = new int[] {1, -1};
		int[] input1 = new int[] {2, -4};
		int[] input2 = new int[] {3, 7};
		int[] input3 = new int[] {-1, 14};
		int[] expectedOutput = new int[] {2, -245};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		assert input3.length == expectedOutput.length : String.format("# input3 = %d, # expectedOutput = %d", input3.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = parabole(input0[i], input1[i], input2[i], input3[i]);
			assert actualOutput == expectedOutput[i] : String.format("parabole(%d, %d, %d, %d) returned %d, but expected %d", input0[i], input1[i], input2[i], input3[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int parabole(int a, int b, int c, int x) {
		return a*x*x + b*x + c;
	}
}
