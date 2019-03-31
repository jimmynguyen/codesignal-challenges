import java.util.stream.IntStream;

public class CountDistantPairs {
	public static void main(String[] args) {
		String[] input0 = new String[] {"abacaba", "abacaba", "abacaba"};
		int[] input1 = new int[] {1, 2, 3};
		int[] expectedOutput = new int[] {3, 0, 3};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = countDistantPairs(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("countDistantPairs(\"%s\", %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
	}

	public static int countDistantPairs(String s, int d) {
		int c = 0;
		for (int i = 0;i < s.length()-d-1;i++)
			c += s.charAt(i)==s.charAt(i+d+1) ? 1 : 0;
		return c;
	}
}
