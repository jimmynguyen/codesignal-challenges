import java.util.Arrays;
import java.util.stream.IntStream;

public class houseNumbersSum {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{5, 1, 2, 3, 0, 1, 5, 0, 2}, {4, 2, 1, 6, 0}, {4, 1, 2, 3, 0, 10, 2}, {0, 1, 2, 3, 0}, {5, 1, 1, 3, 0, 1, 5, 0, 2}, {10, 10, 10, 10, 10, 10, 10, 10, 10, 0}, {10, 10, 10, 10, 10, 10, 10, 10, 0, 10}};
		int[] expectedOutput = new int[] {11, 13, 10, 0, 10, 90, 80};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = houseNumbersSum(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("houseNumbersSum(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int houseNumbersSum(int[] a) {
		int r = 0;
		for (int x : a)
			if (x == 0)
				break;
			else
				r += x;
		return r;
	}
}
