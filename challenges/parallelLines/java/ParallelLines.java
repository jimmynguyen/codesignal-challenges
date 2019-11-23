import java.util.Arrays;
import java.util.stream.IntStream;

public class ParallelLines {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, -1, 0}, {4, 3, 10}, {4, 15, -10}, {19, 20, 19}, {16, 17, -2}, {19, 3, -13}, {20, -17, 11}, {-4, -4, -18}, {-15, -20, 18}, {8, 18, 13}};
		int[][] input1 = new int[][] {{1, 1, 0}, {-8, -6, 0}, {-7, 18, 17}, {14, -1, 13}, {-10, 5, -3}, {-13, 5, -1}, {-20, 17, -5}, {18, 18, -1}, {9, 12, -9}, {2, 11, 18}};
		boolean[] expectedOutput = new boolean[] {false, true, false, false, false, false, true, true, true, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = parallelLines(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("parallelLines(%s, %s) returned %b, but expected %b", Arrays.toString(input0[i]), Arrays.toString(input1[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean parallelLines(int[] line1, int[] line2) {
		return line1[0] * line2[1] == line1[1] * line2[0];
	}
}
