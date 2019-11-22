import java.util.stream.IntStream;

public class FindTheRemainder {
	public static void main(String[] args) {
		int[] input0 = new int[] {5, 4, 3};
		int[] input1 = new int[] {3, 2, 2};
		int[] expectedOutput = new int[] {2, 0, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = findTheRemainder(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("findTheRemainder(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int findTheRemainder(int a, int b) {
		return a%b;
	}
}
