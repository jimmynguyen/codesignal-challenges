import java.util.Arrays;
import java.util.stream.IntStream;

public class ExtractEachKth {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 1, 1, 1, 1}, {1, 2, 1, 2, 1, 2, 1, 2}, {1, 2, 1, 2, 1, 2, 1, 2}, {2, 4, 6, 8, 10}};
		int[] input1 = new int[] {3, 1, 2, 10, 2};
		int[][] expectedOutput = new int[][] {{1, 2, 4, 5, 7, 8, 10}, {}, {1, 1, 1, 1}, {1, 2, 1, 2, 1, 2, 1, 2}, {2, 6, 10}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = extractEachKth(input0[i], input1[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("extractEachKth(%s, %d) returned %s, but expected %s", Arrays.toString(input0[i]), input1[i], Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[] extractEachKth(int[] inputArray, int k) {
		return IntStream.range(0, inputArray.length).filter(i -> (i+1)%k != 0).map(i -> inputArray[i]).toArray();
	}
}
