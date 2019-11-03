import java.util.stream.IntStream;

public class CommonCharacterCount {
	public static void main(String[] args) {
		String[] input0 = new String[] {"aabcc", "zzzz", "abca", "a", "a"};
		String[] input1 = new String[] {"adcaa", "zzzzzzz", "xyzbac", "b", "aaa"};
		int[] expectedOutput = new int[] {3, 4, 3, 0, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = commonCharacterCount(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("commonCharacterCount(\"%s\", \"%s\") returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int commonCharacterCount(String a, String b) {
		int n = 0;
		for (char c : a.toCharArray()) {
			int i = b.indexOf(c);
			if (i > -1) {
				b = b.substring(0, i) + b.substring(i+1);
				n++;
			}
		}
		return n;
	}

	public static int countCommonCharacters2(String s1, String s2) {
		int n = s2.length();
		for (var c : s1.split(""))
			s2=s2.replaceFirst(c,"");
		return n-s2.length();
	}
}
