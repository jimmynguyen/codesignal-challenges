import java.util.stream.IntStream;

public class ReverseInteger {
	public static void main(String[] args) {
		int[] input0 = new int[] {12345, -4243, 1, 10, -100, 900000, -901000, 120, -102, 8192, -61733, -34794, -89827, 83650, -71511, 20842, 43889, 123};
		int[] expectedOutput = new int[] {54321, -3424, 1, 1, -1, 9, -109, 21, -201, 2918, -33716, -49743, -72898, 5638, -11517, 24802, 98834, 321};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = reverseInteger(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("reverseInteger(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int reverseInteger(int x) {
		boolean negative = x < 0;
		String s = Integer.toString(negative ? -x : x);
		String t = "";
		for (int i = s.length()-1; i >= 0; i--) {
			t += s.charAt(i);
		}
		return Integer.parseInt(negative ? '-'+t : t);
	}
}
