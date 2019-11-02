import java.util.Arrays;
import java.util.stream.IntStream;

public class AdjacentElementsProduct {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{3, 6, -2, -5, 7, 3}, {-1, -2}, {5, 1, 2, 3, 1, 4}, {1, 2, 3, 0}, {9, 5, 10, 2, 24, -1, -48}, {5, 6, -4, 2, 3, 2, -23}, {4, 1, 2, 3, 1, 5}, {-23, 4, -3, 8, -12}, {1, 0, 1, 0, 1000}};
		int[] expectedOutput = new int[] {21, 2, 6, 6, 50, 30, 6, -12, 0};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = adjacentElementsProduct(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("adjacentElementsProduct(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int adjacentElementsProduct(int[] a) {
		int p = Integer.MIN_VALUE;
		for (int i = 0, j = 1; j < a.length; i++, j++)
			p = p < a[i] * a[j] ? a[i] * a[j] : p;
		return p;
	}
}
