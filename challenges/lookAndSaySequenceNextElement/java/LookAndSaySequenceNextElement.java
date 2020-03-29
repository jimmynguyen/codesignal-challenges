import java.util.stream.IntStream;

public class LookAndSaySequenceNextElement {
	public static void main(String[] args) {
		String[] input0 = new String[] {"1", "1211", "13112221", "1113213211"};
		String[] expectedOutput = new String[] {"11", "111221", "1113213211", "31131211131221"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = lookAndSaySequenceNextElement(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("lookAndSaySequenceNextElement(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static String lookAndSaySequenceNextElement(String element) {
		String nextElement = "";
		int i = 1;
		while (i <= element.length()) {
			char c = element.charAt(i-1);
			int n = 1;
			while (i < element.length() && c == element.charAt(i)) {
				i++;
				n++;
			}
			nextElement += Integer.toString(n) + c;
			i++;
		}
		return nextElement;
	}
}
