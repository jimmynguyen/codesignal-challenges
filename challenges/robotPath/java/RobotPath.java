import java.util.Arrays;
import java.util.stream.IntStream;

public class RobotPath {
	public static void main(String[] args) {
		String[] input0 = new String[] {"LLLLUUUUDR", "LLLLDDDDUR", "LRUDLURDLDUR"};
		int[] input1 = new int[] {2, 2, 1};
		int[][] expectedOutput = new int[][] {{-1, 1}, {-1, -1}, {0, 0}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = robotPath(input0[i], input1[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("robotPath(\"%s\", %d) returned %s, but expected %s", input0[i], input1[i], Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[] robotPath(String instructions, int bound) {
		int[] coordinates = new int[]{0, 0};
		for (int i = 0; i < instructions.length(); i++) {
			char instruction = instructions.charAt(i);
			if (instruction == 'L' && coordinates[0] > -bound)
				coordinates[0]--;
			if (instruction == 'R' && coordinates[0] < bound)
				coordinates[0]++;
			if (instruction == 'D' && coordinates[1] > -bound)
				coordinates[1]--;
			if (instruction == 'U' && coordinates[1] < bound)
				coordinates[1]++;
		}
		return coordinates;
	}
}
