import java.util.stream.IntStream;

public class BuildPalindrome {
	public static void main(String[] args) {
		String[] input0 = new String[] {"abcdc", "ababab", "abba", "abaa", "aaaaba", "abc", "kebab", "abccba", "abcabc", "cbdbedffcg", "euotmn"};
		String[] expectedOutput = new String[] {"abcdcba", "abababa", "abba", "abaaba", "aaaabaaaa", "abcba", "kebabek", "abccba", "abcabcbacba", "cbdbedffcgcffdebdbc", "euotmnmtoue"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = buildPalindrome(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("buildPalindrome(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static String buildPalindrome(String s) {
		for (int i = 0; i <= s.length(); i++) {
			String t = s;
			for (int j = i-1; j >= 0; j--) {
				t += s.charAt(j);
			}
			if (isPalindrome(t)) {
				return t;
			}
		}
		return null;
	}
	
	static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
}
