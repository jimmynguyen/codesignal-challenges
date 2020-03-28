import java.util.stream.IntStream;

public class LineEncoding {
	public static void main(String[] args) {
		String[] input0 = new String[] {"aabbbc", "abbcabb", "abcd", "zzzz", "wwwwwwwawwwwwww", "ccccccccccccccc", "qwertyuioplkjhg", "ssiiggkooo", "adfaaa", "bbjaadlkjdl"};
		String[] expectedOutput = new String[] {"2a3bc", "a2bca2b", "abcd", "4z", "7wa7w", "15c", "qwertyuioplkjhg", "2s2i2gk3o", "adf3a", "2bj2adlkjdl"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = lineEncoding(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("lineEncoding(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static String lineEncoding(String s) {
		int i = 1, n;
		char c;
		String t = "";
		while (i <= s.length()) {
			c = s.charAt(i-1);
			n = 1;
			while (i < s.length() && c == s.charAt(i)) {
				i++;
				n++;
			}
			t += n == 1 ? c : Integer.toString(n) + c;
			i++;
		}
		return t;
	}
}
