import java.util.stream.IntStream;

public class AddTwoDigits {
	public static void main(String[] args) {
		int[] input0 = new int[] {29, 48, 10, 25, 52, 99, 44, 50, 39, 26};
		int[] expectedOutput = new int[] {11, 12, 1, 7, 7, 18, 8, 5, 12, 8};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = addTwoDigits(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("addTwoDigits(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int addTwoDigits(int n) {
		int s = 0;
		for (char c : Integer.toString(n).toCharArray()) {
			s += Integer.parseInt(""+c);
		}
		return s;
	}
}
