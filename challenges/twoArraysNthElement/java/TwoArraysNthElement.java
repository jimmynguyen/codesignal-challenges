import java.util.Arrays;
import java.util.stream.IntStream;

public class TwoArraysNthElement {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 3, 4}, {1, 2, 3}, {1, 3, 5}};
		int[][] input1 = new int[][] {{2, 6, 8}, {4, 5, 6}, {2, 4}};
		int[] input2 = new int[] {5, 3, 2};
		int[] expectedOutput = new int[] {8, 4, 3};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = twoArraysNthElement(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("twoArraysNthElement(%s, %s, %d) returned %d, but expected %d", Arrays.toString(input0[i]), Arrays.toString(input1[i]), input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int twoArraysNthElement(int[] array1, int[] array2, int n) {
		int i = 0, j = 0;
		while (i < array1.length || j < array2.length) {
			if (i + j == n) {
				return j == array2.length || (i < array1.length && array1[i] < array2[j]) ? array1[i] : array2[j];
			} else if (j == array2.length || (i < array1.length && array1[i] < array2[j])) {
				i++;
			} else {
				j++;
			}
		}
		return -1;
	}
}
