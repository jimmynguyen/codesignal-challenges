import java.util.stream.IntStream;

public class ReduceString {
	public static void main(String[] args) {
		String[] input0 = new String[] {"abacaba", "12133221", ""};
		String[] expectedOutput = new String[] {"", "1332", ""};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = reduceString(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("reduceString(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String reduceString(String s) {
		while (s.length() > 1 && s.charAt(0) == s.charAt(s.length()-1))
			s = s.substring(1, s.length()-1);
		return s.length() > 1 ? s : "";
	}
}
