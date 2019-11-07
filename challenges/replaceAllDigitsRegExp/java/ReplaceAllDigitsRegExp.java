import java.util.stream.IntStream;

public class ReplaceAllDigitsRegExp {
	public static void main(String[] args) {
		String[] input0 = new String[] {"There are 12 points", "012ss210", " _Aas 23", "no digits here", " aa_0239mehce3d", "v z gv4zyx eu mu "};
		String[] expectedOutput = new String[] {"There are ## points", "###ss###", " _Aas ##", "no digits here", " aa_####mehce#d", "v z gv#zyx eu mu "};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = replaceAllDigitsRegExp(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("replaceAllDigitsRegExp(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String replaceAllDigitsRegExp(String s) {
		return s.replaceAll("[0-9]", "#");
	}
}
