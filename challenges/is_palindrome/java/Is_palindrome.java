import java.util.stream.IntStream;

public class Is_palindrome {
	public static void main(String[] args) {
		int[] input0 = new int[] {1, 0, 12, 11};
		int[] expectedOutput = new int[] {1, 1, 0, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = is_palindrome(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("is_palindrome(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int is_palindrome(int n) {
		String s = String.valueOf(n);
		for (int i = 0; i < s.length()/2; i++)
			if (s.charAt(i) != s.charAt(s.length()-1-i))
				return 0;
		return 1;
	}
}
