import java.util.Arrays;
import java.util.stream.IntStream;

public class DotProduct {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 1, 1}, {0, 0, 1}};
		int[][] input1 = new int[][] {{0, 1, -1}, {0, 5, -2}};
		int[] expectedOutput = new int[] {0, -2};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = dotProduct(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("dotProduct(%s, %s) returned %d, but expected %d", Arrays.toString(input0[i]), Arrays.toString(input1[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int dotProduct(int[] v1, int[] v2) {
		return IntStream.range(0, v1.length).map(i -> v1[i] * v2[i]).sum();
	}
}
