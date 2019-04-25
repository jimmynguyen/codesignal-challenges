import java.util.Arrays;
import java.util.stream.IntStream;

public class ImproperFractionToMixed {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{7, 2}, {10, 3}};
		int[][] expectedOutput = new int[][] {{3, 1, 2}, {3, 1, 32}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = improperFractionToMixed(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("improperFractionToMixed(%s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[] improperFractionToMixed(int[] a) {
		return new int[] {(int)Math.floor((double)a[0]/a[1]), a[0]%a[1], a[1]};
	}
}
