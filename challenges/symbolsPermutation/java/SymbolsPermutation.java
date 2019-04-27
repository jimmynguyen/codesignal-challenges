import java.util.Arrays;
import java.util.stream.IntStream;

public class SymbolsPermutation {
	public static void main(String[] args) {
		String[] input0 = new String[] {"abc", "aaaa", "sutr", "kscsa", "imazpsni", "ekufzjmk", "seha", "beicgzwj", "nbimwm", "ryqa"};
		String[] input1 = new String[] {"cab", "aaa", "cybk", "ncwxt", "kbyafemd", "chhmjxmy", "zims", "pazofnfl", "xwidkg", "ayrq"};
		boolean[] expectedOutput = new boolean[] {true, false, false, false, false, false, false, false, false, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = symbolsPermutation(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("symbolsPermutation(\"%s\", \"%s\") returned %b, but expected %b", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean symbolsPermutation(String word1, String word2) {
		char[] word1Arr = word1.toCharArray();
		char[] word2Arr = word2.toCharArray();
		Arrays.sort(word1Arr);
		Arrays.sort(word2Arr);
		return word1.length() == word2.length() && Arrays.equals(word1Arr, word2Arr);
	}
}
