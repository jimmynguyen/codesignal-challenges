import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayPreviousLess {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{3, 5, 2, 4, 5}, {2, 2, 1, 3, 4, 5, 5, 3}, {3, 2, 1}, {100, 101, 102}, {7, 7, 8, 3, 4, 4, 2, 5, 6, 7, 7}, {68, 135, 101, 170, 125}};
		int[][] expectedOutput = new int[][] {{-1, 3, -1, 2, 4}, {-1, -1, -1, 1, 3, 4, 4, 1}, {-1, -1, -1}, {-1, 100, 101}, {-1, -1, 7, -1, 3, 3, -1, 2, 5, 6, 6}, {-1, 68, 68, 101, 101}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = arrayPreviousLess(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("arrayPreviousLess(%s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[] arrayPreviousLess(int[] a) {
		int[] b = new int[a.length];
		b[0] = -1;
		for (int i = 1; i < a.length; i++) {
			int c = -1;
			for (int j = i-1; j >= 0; j--) {
				if (a[j] < a[i]) {
					c = a[j];
					break;
				}
			}
			b[i] = c;
		}
		return b;
	}
}
