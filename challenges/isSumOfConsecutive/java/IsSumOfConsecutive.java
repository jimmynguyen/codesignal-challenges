import java.util.stream.IntStream;

public class IsSumOfConsecutive {
	public static void main(String[] args) {
		int[] input0 = new int[] {9, 8, 1, 42, 110, 45, 128, 55, 400, 256};
		boolean[] expectedOutput = new boolean[] {true, false, false, true, true, true, false, true, true, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = isSumOfConsecutive(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("isSumOfConsecutive(%d) returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean isSumOfConsecutive(int n) {
		int m = (int)Math.ceil(n/2.0);
		for (int i = 1; i < m; i++)
			for (int j = i, k = 0; j < m; j++) {
				k += j;
				if (k == n)
					return true;
				else if (k > n)
					break;
			}
		return false;
	}
}
