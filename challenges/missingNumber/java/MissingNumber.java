import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{3, 1, 0}, {0}, {1, 2}, {0, 1}, {3, 1, 2}, {3, 2, 1}, {5, 2, 1, 6, 3, 0}, {8, 6, 7, 0, 2, 5, 4, 3}, {0, 3, 5, 8, 4, 6, 1, 9, 7}, {2, 9, 8, 1, 3, 6, 7, 4, 5}, {9, 6, 4, 2, 3, 5, 7, 0, 1}, {1, 8, 4, 6, 2, 0, 9, 7, 5}, {1, 2, 5, 0, 6, 7, 9, 3, 4}, {45, 35, 38, 13, 12, 23, 48, 15, 44, 21, 43, 26, 6, 37, 1, 19, 22, 3, 11, 32, 4, 16, 28, 49, 29, 36, 33, 8, 9, 39, 46, 17, 41, 7, 2, 5, 27, 20, 40, 34, 30, 25, 47, 0, 31, 42, 24, 10, 14}, {44, 26, 34, 25, 23, 42, 0, 43, 38, 14, 47, 19, 49, 6, 16, 41, 24, 35, 10, 4, 32, 5, 8, 15, 31, 3, 46, 22, 2, 30, 28, 37, 1, 21, 39, 45, 9, 48, 36, 17, 7, 27, 18, 29, 13, 40, 11, 20, 12}};
		int[] expectedOutput = new int[] {2, 1, 0, 2, 0, 0, 4, 1, 2, 0, 8, 3, 8, 18, 33};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = missingNumber(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("missingNumber(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int missingNumber(int[] arr) {
		boolean[] found = new boolean[arr.length+1];
		for (int n : arr) {
			found[n] = true;
		}
		int missing = 0;
		for (int i = 0; i < found.length; i++) {
			if (!found[i]) {
				missing = i;
				break;
			}
		}
		return missing;
	}
}
