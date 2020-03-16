import java.util.Arrays;
import java.util.stream.IntStream;

public class ShuffledArray {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 12, 3, 6, 2}, {1, -3, -5, 7, 2}, {2, -1, 2, 2, -1}, {-3, -3}, {37, 11, -37, -85, -67, 32, 90, -90, 56, 80, 37}, {18, -73, -39, 65, -65, -52}};
		int[][] expectedOutput = new int[][] {{1, 2, 3, 6}, {-5, -3, 2, 7}, {-1, -1, 2, 2}, {-3}, {-90, -85, -67, -37, 11, 37, 37, 56, 80, 90}, {-65, -52, -39, 18, 65}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = shuffledArray(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("shuffledArray(%s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int[] shuffledArray(int[] shuffled) {
		Arrays.sort(shuffled);
		int sum = IntStream.of(shuffled).sum()/2;
		int[] sorted = new int[shuffled.length-1];
		int i = 0;
		boolean found = false;
		for (int x : shuffled) {
			if (x == sum && !found) {
				found = true;
			} else {
				sorted[i++] = x;
			}
		}
		return sorted;
	}
}
