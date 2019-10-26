import java.util.Arrays;
import java.util.stream.IntStream;

public class DistinctDistances {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{3, 4, 5}, {4, 5, 9}, {4, 5, 10}, {1, 2, 10}};
		int[] expectedOutput = new int[] {3, 3, 4, 4};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = distinctDistances(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("distinctDistances(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int distinctDistances(int[] distances) {
		return distances[0] + distances[1] < distances[2] ? 4 : 3;
	}
}
