import java.util.stream.IntStream;

public class AlphabetSubsequence {
	public static void main(String[] args) {
		String[] input0 = new String[] {"effg", "cdce", "ace", "bxz", "cdefghijkxyzz", "qa", "fkyz", "xz", "pfyz", "fz"};
		boolean[] expectedOutput = new boolean[] {false, false, true, true, false, false, true, true, false, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = alphabetSubsequence(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("alphabetSubsequence(\"%s\") returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean alphabetSubsequence(String s) {
		boolean[] found = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (found[c-'a'] || (i+1 < s.length() && c > s.charAt(i+1))) {
				return false;
			} else {
				found[c-'a'] = true;
			}
		}
		return true;
	}
}
