import java.util.stream.IntStream;

public class centuryFromYear {
	public static void main(String[] args) {
		int[] input0 = new int[] {1905, 1700, 1988, 2000, 2001, 200, 374, 45, 8};
		int[] expectedOutput = new int[] {20, 17, 20, 20, 21, 2, 4, 1, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = centuryFromYear(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("centuryFromYear(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int centuryFromYear(int year) {
		return year/100 + (year%100 != 0 ? 1 : 0);
	}
}
