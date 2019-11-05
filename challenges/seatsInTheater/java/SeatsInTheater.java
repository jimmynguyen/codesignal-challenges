import java.util.stream.IntStream;

public class SeatsInTheater {
	public static void main(String[] args) {
		int[] input0 = new int[] {16, 1, 13, 60, 1000};
		int[] input1 = new int[] {11, 1, 6, 100, 1000};
		int[] input2 = new int[] {5, 1, 8, 60, 1000};
		int[] input3 = new int[] {3, 1, 3, 1, 1000};
		int[] expectedOutput = new int[] {96, 0, 18, 99, 0};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		assert input3.length == expectedOutput.length : String.format("# input3 = %d, # expectedOutput = %d", input3.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = seatsInTheater(input0[i], input1[i], input2[i], input3[i]);
			assert actualOutput == expectedOutput[i] : String.format("seatsInTheater(%d, %d, %d, %d) returned %d, but expected %d", input0[i], input1[i], input2[i], input3[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int seatsInTheater(int nCols, int nRows, int col, int row) {
		return (nCols - col + 1) * (nRows - row);
	}
}
