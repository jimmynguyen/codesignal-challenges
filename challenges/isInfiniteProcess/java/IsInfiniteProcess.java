import java.util.stream.IntStream;

public class IsInfiniteProcess {
	public static void main(String[] args) {
		int[] input0 = new int[] {2, 2, 2, 0, 3, 10, 5, 6, 10, 5};
		int[] input1 = new int[] {6, 3, 10, 1, 1, 10, 10, 10, 0, 5};
		boolean[] expectedOutput = new boolean[] {false, true, false, true, true, false, true, false, true, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = isInfiniteProcess(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("isInfiniteProcess(%d, %d) returned %b, but expected %b", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean isInfiniteProcess(int a, int b) {
		while (a != b) {
			if (a > b) return true;
			a++;
			b--;
		}
		return false;
	}
}
