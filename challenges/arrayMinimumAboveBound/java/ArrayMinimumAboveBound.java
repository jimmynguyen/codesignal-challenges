import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayMinimumAboveBound {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 3, 5, 4, 2, 6}, {1, 4, 10, 5, 2}, {-1, -4, -10, -5, -2}, {19, 32, 11, 23}, {0, -2, 5, 6, -9}, {1, 2, 4, 5, 3}};
		int[] input1 = new int[] {3, 1, -5, 22, 5, 2};
		int[] expectedOutput = new int[] {4, 2, -4, 23, 6, 3};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = arrayMinimumAboveBound(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("arrayMinimumAboveBound(%s, %d) returned %d, but expected %d", Arrays.toString(input0[i]), input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int arrayMinimumAboveBound(int[] a, int b) {
		int d = Integer.MAX_VALUE, r = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > b && d > a[i] - b) {
				r = a[i];
				d = a[i] - b;
			}
		}
		return r;
	}
}
