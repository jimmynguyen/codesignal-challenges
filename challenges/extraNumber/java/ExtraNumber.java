import java.util.stream.IntStream;

public class ExtraNumber {
	public static void main(String[] args) {
		int[] input0 = new int[] {2, 3, 5, 500000000, 1, 5, 5, 4000000, 548442737, 469992838};
		int[] input1 = new int[] {7, 2, 5, 3, 5, 5, 1, 3000000, 82231042, 66019520};
		int[] input2 = new int[] {2, 2, 1, 500000000, 1, 3, 1, 4000000, 548442737, 66019520};
		int[] expectedOutput = new int[] {7, 3, 1, 3, 5, 3, 5, 3000000, 82231042, 469992838};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = extraNumber(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("extraNumber(%d, %d, %d) returned %d, but expected %d", input0[i], input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int extraNumber(int a, int b, int c) {
		return a == b ? c : a == c ? b : a;
	}
}
