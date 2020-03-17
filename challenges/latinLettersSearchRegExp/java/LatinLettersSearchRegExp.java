import java.util.stream.IntStream;

public class LatinLettersSearchRegExp {
	public static void main(String[] args) {
		String[] input0 = new String[] {"a_ _2", "W2", "_1111 ", "1337 ", "123456789O", "_111l ", "a", "12375$&*D", "#!@_@($_+)", "........"};
		boolean[] expectedOutput = new boolean[] {true, true, false, false, true, true, true, true, false, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = latinLettersSearchRegExp(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("latinLettersSearchRegExp(\"%s\") returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean latinLettersSearchRegExp(String input) {
		return input.matches(".*[a-zA-Z].*");
	}
}
