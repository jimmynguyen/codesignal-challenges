import java.util.Arrays;
import java.util.stream.IntStream;

public class WaterTubes {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 2, 5}, {1, 2, 3}, {1, 1, 1}};
		int[][] input1 = new int[][] {{1, 1, 2}, {1, 1, 2}, {3, 4, 5}};
		int[] expectedOutput = new int[] {3, 2, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = waterTubes(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("waterTubes(%s, %s) returned %d, but expected %d", Arrays.toString(input0[i]), Arrays.toString(input1[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int waterTubes(int[] water, int[] flowPerMinute) {
		boolean isNotEmpty = true;
		int minutes = 0;
		while (isNotEmpty) {
			isNotEmpty = false;
			for (int i = 0; i < water.length; i++) {
				water[i] -= flowPerMinute[i];
				isNotEmpty = isNotEmpty || water[i] > 0;
			}
			minutes++;
		}
		return minutes;
	}
}
