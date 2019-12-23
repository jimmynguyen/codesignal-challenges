import java.util.stream.IntStream;

public class OneTwoMany {
	public static void main(String[] args) {
		int[] input0 = new int[] {20, 3, 1};
		String[] expectedOutput = new String[] {"many", "many", "one"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = oneTwoMany(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("oneTwoMany(%d) returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String oneTwoMany(int n) {
		return n == 1 ? "one" : n == 2 ? "two" : "many";
	}
}
