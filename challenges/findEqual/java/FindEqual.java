import java.util.Arrays;
import java.util.stream.IntStream;

public class FindEqual {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 3, 2, 1}, {1, 3, 2}, {1, 4, 10, 4, 2}, {239}, {239, 239}, {0, -2, 5, 6}, {1000000000, -1000000000}, {3, 3, 3}, {4, 3, 5, -1, 2, 8, -10, 10, 1, 0, -9, 8}, {887054867, -752605877, 164338219, -740349323, 533303064, 609353299, 606300351, -838575817, 675594620, -999824833}};
		boolean[] expectedOutput = new boolean[] {true, false, true, false, true, false, false, true, true, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = findEqual(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("findEqual(%s) returned %b, but expected %b", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean findEqual(int[] sequence) {
		for (int i = 0; i < sequence.length; i++) {
			for (int j = i+1; j < sequence.length; j++) {
				if (sequence[i] == sequence[j]) {
					return true;
				}
			}
		}
		return false;
	}
}
