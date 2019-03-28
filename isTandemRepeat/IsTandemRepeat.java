import java.util.stream.IntStream;

public class IsTandemRepeat {
	public static void main(String[] args) {
		String[] input = new String[] { "tandemtandem", "qqq", "2w2ww", "hophey", "CodeSignalCodeSignal", "interestinterest", "aa", "ab", "stringString", "truetruetrue" };
		boolean[] expectedOutput = new boolean[] { true, false, false, false, true, true, true, false, false, false };
		assert input.length == expectedOutput.length : String.format("# inputs = %d, # expectedOutputs = %d", input.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = isTandemRepeat(input[i]);
			assert actualOutput == expectedOutput[i] : String.format("isTandemRepeat(\"%s\") returned %d, but expected %d", input[i], actualOutput, expectedOutput[i]);
		});
	}

	public static boolean isTandemRepeat(String s) {
		int n = s.length();
		return s.substring(0, n/2).equals(s.substring(n/2));
	}
}
