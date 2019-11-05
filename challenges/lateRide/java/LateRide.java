import java.util.stream.IntStream;

public class LateRide {
	public static void main(String[] args) {
		int[] input0 = new int[] {240, 808, 1439, 0, 23, 8};
		int[] expectedOutput = new int[] {4, 14, 19, 0, 5, 8};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = lateRide(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("lateRide(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int lateRide(int n) {
		return n % 60 % 10 + n % 60 / 10 + n / 60 % 10 + n / 600;
	}
}
