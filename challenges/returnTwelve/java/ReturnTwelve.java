import java.util.stream.IntStream;

public class ReturnTwelve {
	public static void main(String[] args) {
		int[] input0 = new int[] {13, 10, 12};
		int[] expectedOutput = new int[] {13, 12, 12};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = returnTwelve(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("returnTwelve(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int returnTwelve(int number) {
		return number > 12 ? number : 12;
	}
}
