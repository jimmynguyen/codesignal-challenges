import java.util.Arrays;
import java.util.stream.IntStream;

public class MakeArrayConsecutive2 {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{6, 2, 3, 8}, {0, 3}, {5, 4, 6}, {6, 3}, {1}};
		int[] expectedOutput = new int[] {3, 2, 0, 2, 0};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = makeArrayConsecutive2(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("makeArrayConsecutive2(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int makeArrayConsecutive2(int[] statues) {
		int min = statues[0];
		int max = statues[0];
		for (int i = 1; i < statues.length; i++) {
			if (min > statues[i]) {
				min = statues[i];
			}
			if (max < statues[i]) {
				max = statues[i];
			}
		}
		return max - min - statues.length + 1;
	}
}
