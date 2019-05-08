import java.util.stream.IntStream;

public class PercentageGreen {
	public static void main(String[] args) {
		int[] input0 = new int[] {2, 4};
		int[] input1 = new int[] {5, 5};
		int[] expectedOutput = new int[] {40, 80};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = percentageGreen(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("percentageGreen(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int percentageGreen(int green, int total) {
		return (int)((double) green / total * 100);
	}
}
