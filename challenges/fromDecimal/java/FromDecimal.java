import java.util.stream.IntStream;

public class FromDecimal {
	public static void main(String[] args) {
		int[] input0 = new int[] {2, 3, 9};
		int[] input1 = new int[] {13, 66, 381367044};
		String[] expectedOutput = new String[] {"1101", "2110", "876543210"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = fromDecimal(input0[i], input1[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("fromDecimal(%d, %d) returned \"%s\", but expected \"%s\"", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String fromDecimal(int b, int n) {
		String s = "";
		while (n > 0) {
			s = n%b + s;
			n /= b;
		}
		return s;
	}
}
