import java.util.stream.IntStream;

public class CommonCharacterCount {
	public static void main(String[] args) {
		String[] input1 = new String[] { "aabcc", "zzzz", "abca", "a", "a" };
		String[] input2 = new String[] { "adcaa", "zzzzzzz", "xyzbac", "b", "aaa" };
		int[] expectedOutput = new int[] { 3, 4, 3, 0, 1 };
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = countCommonCharacters(input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("commonCharacterCount(\"%s\", \"%s\") returned %d, but expected %d", input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
	}

	public static int countCommonCharacters(String s1, String s2) {
		int n = s2.length();
		for (var c : s1.split(""))
			s2=s2.replaceFirst(c,"");
		return n-s2.length();
	}
}
