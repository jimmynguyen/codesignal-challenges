import java.util.stream.IntStream;

public class KnapsackLight {
	public static void main(String[] args) {
		int[] input0 = new int[] {10, 10, 5, 10, 15, 2, 4, 3};
		int[] input1 = new int[] {5, 5, 3, 2, 2, 5, 3, 5};
		int[] input2 = new int[] {6, 6, 7, 11, 20, 3, 3, 3};
		int[] input3 = new int[] {4, 4, 4, 3, 3, 4, 4, 8};
		int[] input4 = new int[] {8, 9, 6, 1, 2, 5, 4, 10};
		int[] expectedOutput = new int[] {10, 16, 7, 0, 15, 3, 4, 3};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		assert input3.length == expectedOutput.length : String.format("# input3 = %d, # expectedOutput = %d", input3.length, expectedOutput.length);
		assert input4.length == expectedOutput.length : String.format("# input4 = %d, # expectedOutput = %d", input4.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = knapsackLight(input0[i], input1[i], input2[i], input3[i], input4[i]);
			assert actualOutput == expectedOutput[i] : String.format("knapsackLight(%d, %d, %d, %d, %d) returned %d, but expected %d", input0[i], input1[i], input2[i], input3[i], input4[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
		if (weight1 + weight2 <= maxW) return value1 + value2;
		if (value1 > value2 && weight1 <= maxW) return value1;
		if (value2 > value1 && weight2 <= maxW) return value2;
		if (weight1 <= maxW) return  value1;
		if (weight2 <= maxW) return value2;
		return 0;
	}
}
