import java.util.Arrays;
import java.util.stream.IntStream;

public class SubtractionByRegrouping {
	public static void main(String[] args) {
		int[] input0 = new int[] {2024, 6, 4567, 3001, 5000, 1, 51234, 20100};
		int[] input1 = new int[] {1234, 5, 3456, 2901, 4999, 1, 12345, 19199};
		int[][] expectedOutput = new int[][] {{4, 12, 9, 1}, {6}, {7, 6, 5, 4}, {1, 0, 10, 2}, {10, 9, 9, 4}, {1}, {14, 12, 11, 10, 4}, {10, 9, 10, 9, 1}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = subtractionByRegrouping(input0[i], input1[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("subtractionByRegrouping(%d, %d) returned %s, but expected %s", input0[i], input1[i], Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[] subtractionByRegrouping(int minuend, int subtrahend) {
		Integer[] minuendArr = Arrays.stream(Integer.toString(minuend).split("")).map(Integer::parseInt).toArray(Integer[]::new);
		Integer[] subtrahendArr = Arrays.stream(Integer.toString(subtrahend).split("")).map(Integer::parseInt).toArray(Integer[]::new);
		int[] output = new int[minuendArr.length];
		for (int i = minuendArr.length-1; i >= 0 ; i--) {
			if (minuendArr[i] < subtrahendArr[i]) {
				minuendArr[i] += 10;
				minuendArr[i-1] = minuendArr[i-1]-1;
			}
			output[output.length-i-1] = minuendArr[i];
		}
		return output;
	 }
}
