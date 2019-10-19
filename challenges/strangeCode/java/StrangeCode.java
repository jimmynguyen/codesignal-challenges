import java.util.stream.IntStream;

public class StrangeCode {
	public static void main(String[] args) {
		int[] input0 = new int[] {4, 10, 10};
		int[] input1 = new int[] {8, 15, 16};
		String[] expectedOutput = new String[] {"ab", "ab", "aba"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = strangeCode(input0[i], input1[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("strangeCode(%d, %d) returned \"%s\", but expected \"%s\"", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String strangeCode(int s, int e) {
		String code = "";
		char lastLetter = 'a';
		while (s < e - 1) {
			s++;
			e--;
			if (!code.isEmpty())
				lastLetter = lastLetter == 'a' ? 'b' : 'a';
			code += lastLetter;
		}
		return code;
	}
}
