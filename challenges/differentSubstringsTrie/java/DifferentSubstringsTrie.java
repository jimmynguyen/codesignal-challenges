import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class DifferentSubstringsTrie {
	public static void main(String[] args) {
		String[] input0 = new String[] {"abac", "abacaba", "string"};
		int[] expectedOutput = new int[] {9, 21, 21};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = differentSubstringsTrie(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("differentSubstringsTrie(\"%s\") returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int differentSubstringsTrie(String s) {
		Set<String> t = new HashSet<>();
		for (int i = 0; i < s.length(); i++)
			for (int j = i+1; j <= s.length(); j++)
				t.add(s.substring(i, j));
		return t.size();
	}
}
