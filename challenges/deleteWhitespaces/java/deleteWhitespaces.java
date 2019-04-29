import java.util.stream.IntStream;

public class deleteWhitespaces {
	public static void main(String[] args) {
		String[] input0 = new String[] {"a  b cd  e", "a   b c  dc "};
		String[] expectedOutput = new String[] {"abcde", "abcdc"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = deleteWhitespaces(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("deleteWhitespaces(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String deleteWhitespaces(String inputStr) {
		return inputStr.replaceAll(" ", "");
	}
}
