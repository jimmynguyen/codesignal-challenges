import java.util.stream.IntStream;

public class EvenDigitsOnly {
	public static void main(String[] args) {
		int[] input0 = new int[] {248622, 642386, 248842, 1, 8, 2462487, 468402800, 2468428, 5468428, 7468428};
		boolean[] expectedOutput = new boolean[] {true, false, true, false, true, false, true, true, false, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = evenDigitsOnly(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("evenDigitsOnly(%d) returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean evenDigitsOnly(int n) {
		for (char c : Integer.toString(n).toCharArray()) {
			if ((c - '0')%2 != 0) {
				return false;
			}
		}
		return true;
	}
}
