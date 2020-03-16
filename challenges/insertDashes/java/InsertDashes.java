import java.util.stream.IntStream;

public class InsertDashes {
	public static void main(String[] args) {
		String[] input0 = new String[] {"aba caba", "x"};
		String[] expectedOutput = new String[] {"a-b-a c-a-b-a", "x"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = insertDashes(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("insertDashes(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static String insertDashes(String input) {
		String output = "";
		char c = input.charAt(0), d = input.charAt(0);
		for (int i = 0; i < input.length()-1; i++) {
			c = input.charAt(i);
			d = input.charAt(i+1);
			output += input.charAt(i) + ((c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') && (d >= 'a' && d <= 'z' || d >= 'A' && d <= 'Z') ? "-" : "");
		}
		return output + d;
	}
}
