import java.util.stream.IntStream;

public class FindHyperlink {
	public static void main(String[] args) {
		String[] input0 = new String[] {"<a href=\"http://www.example.org\">Example1</a>", "a href=\"http://www.wrong.org\"<a href=\"correct\">Example2 a href /a</a> URL", "URL a href=\"http://www.wrong.org\"<a href=\"\">Example3 a href /a</a> URL href", "a href=\"URL\"<a href=\"href=\"\"\"> Example4</a>", "\"<a href=\"http://\">\" long teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeext \"</a>\" something something", "URL a href=\"http://www.wrong.org\"<a href=\"correct.txt\"></a>"};
		String[] expectedOutput = new String[] {"http://www.example.org", "correct", "", "href=\"\"", "http://", "correct.txt"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = findHyperlink(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("findHyperlink(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String findHyperlink(String text) {
		String anchorTagStart = "<a href=\"";
		int ndxStart = text.indexOf(anchorTagStart) + anchorTagStart.length();
		int ndxEnd = text.indexOf("\">", ndxStart);
		return text.substring(ndxStart, ndxEnd);
	}
}
