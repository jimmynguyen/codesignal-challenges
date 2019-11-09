import java.util.stream.IntStream;

public class CountSumOfTwoRepresentations2 {
	public static void main(String[] args) {
		int[] input0 = new int[] {6, 6, 10, 24, 24, 93};
		int[] input1 = new int[] {2, 3, 9, 8, 12, 24};
		int[] input2 = new int[] {4, 3, 11, 16, 12, 58};
		int[] expectedOutput = new int[] {2, 1, 0, 5, 1, 12};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = countSumOfTwoRepresentations2(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("countSumOfTwoRepresentations2(%d, %d, %d) returned %d, but expected %d", input0[i], input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int countSumOfTwoRepresentations2(int n, int l, int r) {
		int count = 0;
		for (int a = l, b; a <= r; a++) {
			b = n - a;
			if (b >= a && b <= r) count++;
		}
		return count;
	}
}
