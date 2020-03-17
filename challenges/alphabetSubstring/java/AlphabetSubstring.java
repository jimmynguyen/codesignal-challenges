import java.util.stream.IntStream;

public class AlphabetSubstring {
	public static void main(String[] args) {
		String[] input0 = new String[] {"efghi", "bde", "cdefghijk", "b", "bccdef", "pqrstuvwx", "prs", "abcdefghij", "uvwxyz", "abcdefhijk", "stuvwx"};
		boolean[] expectedOutput = new boolean[] {true, false, true, true, false, true, false, true, true, false, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = alphabetSubstring(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("alphabetSubstring(\"%s\") returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean alphabetSubstring(String s) {
		return "abcdefghijklmnopqrstuvwxyz".contains(s);
	}
}
