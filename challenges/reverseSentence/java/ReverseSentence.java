import java.util.stream.IntStream;

public class ReverseSentence {
	public static void main(String[] args) {
		String[] input0 = new String[] {"Man bites dog", "IHateSpaces", "a b c", "BgwlaMUMkToumKe ANHz"};
		String[] expectedOutput = new String[] {"dog bites Man", "IHateSpaces", "c b a", "ANHz BgwlaMUMkToumKe"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = reverseSentence(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("reverseSentence(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static String reverseSentence(String sentence) {
		String reverse = "";
		String[] words = sentence.split(" ");
		for (int i = words.length-1; i >= 0; i--) {
			reverse += words[i] + " ";
		}
		return reverse.substring(0, reverse.length()-1);
	}
}
