import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class LongestSequence {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 7, 3, 5, 4, 2}, {1, -2, 7, 3, -7, 4, 9, 2, -8, -5, -5, -7, 6, 2, -8, -9, 2, 5, 4, -10}, {43}, {4, 1, 2, 4, 3, 5, 4, 6}};
		int[] expectedOutput = new int[] {3, 4, 1, 4};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = longestSequence(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("longestSequence(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int longestSequence(int[] a) {
		HashSet[][] table = new HashSet[a.length][a.length];
		int maxLength = 1;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				table[i][j] = new HashSet<Integer>();
				table[i][j].add(a[i]);
				table[i][j].add(a[j]);
				int diff = a[j] - a[i];
				int prev = a[j];
				for (int k = j+1; k < a.length; k++) {
					if (a[k] == prev + diff) {
						table[i][j].add(a[k]);
						prev = a[k];
					}
				}
				if (table[i][j].size() > maxLength) {
					maxLength = table[i][j].size();
				}
			}
		}
		return maxLength;
	}
}
