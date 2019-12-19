import java.util.stream.IntStream;

public class IsCaseInsensitivePalindrome {
	public static void main(String[] args) {
		String[] input0 = new String[] {"AaBaa", "abac", "aBACaba", "opOP", "ZZzzazZzz", "zzzzazzzz", "ZZzzabzZzz", "abcdcbA", "abracabra", "abcd"};
		boolean[] expectedOutput = new boolean[] {true, false, true, false, true, true, false, true, false, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = isCaseInsensitivePalindrome(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("isCaseInsensitivePalindrome(\"%s\") returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean isCaseInsensitivePalindrome(String s) {
		s = s.toLowerCase();
		for (int i = 0; i < s.length()/2; i++)
			if (s.charAt(i) != s.charAt(s.length()-1-i))
				return false;
		return true;
	}
}
