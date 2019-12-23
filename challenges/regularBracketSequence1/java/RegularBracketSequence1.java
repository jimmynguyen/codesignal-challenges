import java.util.stream.IntStream;

public class RegularBracketSequence1 {
	public static void main(String[] args) {
		String[] input0 = new String[] {"()()", "((())", "(())()()()", ")))(((", "))())", "(())()(())", "())()))", ")))())))(", "())((", "(((())))()"};
		boolean[] expectedOutput = new boolean[] {true, false, true, false, false, true, false, false, false, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = regularBracketSequence1(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("regularBracketSequence1(\"%s\") returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean regularBracketSequence1(String sequence) {
		int n = 0;
		for (char c : sequence.toCharArray())
			if (n < 0)
				return false;
			else if (c == '(')
				n++;
			else if (c == ')')
				n--;
		return n == 0;
	}
}
