import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayMaximalAdjacentDifference {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{2, 4, 1, 0}, {1, 1, 1, 1}, {-1, 4, 10, 3, -2}, {10, 11, 13}, {-2, -2, -2, -2, -2}, {-1, 1, -3, -4}, {-14, 15, -15}};
		int[] expectedOutput = new int[] {3, 0, 7, 2, 0, 4, 30};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = arrayMaximalAdjacentDifference(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("arrayMaximalAdjacentDifference(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int arrayMaximalAdjacentDifference(int[] a) {
		int n = -1;
		for (int i = 1, d; i < a.length-1; i++) {
			d = Math.abs(a[i]-a[i+1]);
			if (n < d) {
				n = d;
			}
		}
		return n;
	}
}
