import java.util.stream.IntStream;

public class FirstDigit {
	public static void main(String[] args) {
		String[] input0 = new String[] {"var_1__Int", "q2q-q", "0ss", "_Aas_23", "a a_933", "ok0"};
		char[] expectedOutput = new char[] {'1', '2', '0', '2', '9', '0'};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			char actualOutput = firstDigit(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("firstDigit(\"%s\") returned %s, but expected %s", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static char firstDigit(String s) {
		for (char c : s.toCharArray())
			if (c >= '0' && c <= '9')
				return c;
		return '0';
	}
}
