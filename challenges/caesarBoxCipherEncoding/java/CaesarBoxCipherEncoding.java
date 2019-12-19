import java.util.stream.IntStream;

public class CaesarBoxCipherEncoding {
	public static void main(String[] args) {
		String[] input0 = new String[] {"a message", "sixteenletters16"};
		String[] expectedOutput = new String[] {"aea sgmse", "seerietsxnt1tle6"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = caesarBoxCipherEncoding(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("caesarBoxCipherEncoding(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String caesarBoxCipherEncoding(String s) {
		int n = (int)Math.sqrt(s.length());
		String c = "";
		for (int i = 0; i < n; i++)
			for (int j = i; j < s.length(); j+=n)
				c += s.charAt(j);
		return c;
	}
}
