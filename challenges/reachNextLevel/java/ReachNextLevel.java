import java.util.stream.IntStream;

public class ReachNextLevel {
	public static void main(String[] args) {
		int[] input0 = new int[] {10, 10, 3, 84, 74, 80, 97, 235, 222, 16};
		int[] input1 = new int[] {15, 15, 6, 135, 170, 199, 57, 293, 137, 23};
		int[] input2 = new int[] {5, 4, 4, 36, 58, 15, 7, 4, 58, 16};
		boolean[] expectedOutput = new boolean[] {true, false, true, false, false, false, true, false, true, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = reachNextLevel(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("reachNextLevel(%d, %d, %d) returned %b, but expected %b", input0[i], input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean reachNextLevel(int experience, int threshold, int reward) {
		return experience + reward >= threshold;
	}
}
