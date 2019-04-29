import java.util.Arrays;
import java.util.stream.IntStream;

public class arraySumAdjacentDifference {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{4, 7, 1, 2}, {1, 5, 10, 4, 2}, {1, 1, 1, 1}};
		int[] expectedOutput = new int[] {10, 17, 0};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = arraySumAdjacentDifference(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("arraySumAdjacentDifference(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int arraySumAdjacentDifference(int[] inputArray) {
		return IntStream.range(0, inputArray.length-1).map(i -> Math.abs(inputArray[i+1]-inputArray[i])).sum();
	}
}
