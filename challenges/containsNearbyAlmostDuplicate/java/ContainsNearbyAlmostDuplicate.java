import java.util.Arrays;
import java.util.stream.IntStream;

public class ContainsNearbyAlmostDuplicate {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 3, 1}, {-3, 3}, {-1, -1}, {2, 1}, {-1, -1}, {7, 1, 3}, {1, 2}, {1, 2, 3, 1}, {4, 2}, {3, 6, 0, 2}, {2, 0, -2, 2}, {1, 3, 6, 2}, {2147483647, -2147483647}, {4, 1, 6, 3}, {0, 10, 22, 15, 0, 5, 22, 12, 1, 5}, {10, 100, 11, 9}, {4, 1, -1, 6, 5}, {0, 2147483647}};
		int[] input1 = new int[] {2, 2, 1, 1, 1, 2, 1, 4, 2, 2, 2, 1, 1, 100, 3, 1, 3, 1};
		int[] input2 = new int[] {1, 4, 0, 1, 1, 3, 1, 0, 1, 2, 1, 2, 2147483647, 1, 3, 2, 1, 2147483647};
		boolean[] expectedOutput = new boolean[] {true, false, true, true, true, true, true, true, false, true, false, true, false, true, false, true, true, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = containsNearbyAlmostDuplicate(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("containsNearbyAlmostDuplicate(%s, %d, %d) returned %b, but expected %b", Arrays.toString(input0[i]), input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j <= i+k && j < nums.length; j++) {
				if (Math.abs((long)nums[i]-(long)nums[j]) <= (long)t) {
					return true;
				}
			}
		}
		return false;
	}
}
