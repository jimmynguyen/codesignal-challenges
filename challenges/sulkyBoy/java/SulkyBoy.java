import java.util.stream.IntStream;

public class SulkyBoy {
	public static void main(String[] args) {
		boolean[] input0 = new boolean[] {false, true};
		boolean[] expectedOutput = new boolean[] {true, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = sulkyBoy(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("sulkyBoy(%b) returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean sulkyBoy(boolean statement) {
		return !statement;
	}
}
