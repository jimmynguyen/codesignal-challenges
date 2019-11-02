import java.util.stream.IntStream;

public class CheckPalindrome {
	public static void main(String[] args) {
		String[] input0 = new String[] {"aabaa", "abac", "a", "az", "abacaba", "z", "aaabaaaa", "zzzazzazz", "hlbeeykoqqqqokyeeblh", "hlbeeykoqqqokyeeblh"};
		boolean[] expectedOutput = new boolean[] {true, false, true, false, true, true, false, false, true, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = checkPalindrome(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("checkPalindrome(\"%s\") returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean checkPalindrome(String s) {
		int n = s.length();
		for (int i = 0; i < n/2; i++)
			if (s.charAt(i) != s.charAt(n-i-1))
				return false;
		return true;
	}
}
