import java.util.Arrays;
import java.util.stream.IntStream;

public class CountInversionsNaive {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 3, 2, 0}, {1, 4, 10, 4, 2}, {1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}, {-1, -2, 3, -4, 5}};
		int[] expectedOutput = new int[] {4, 4, 0, 10, 4};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = countInversionsNaive(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("countInversionsNaive(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int countInversionsNaive(int[] arr) {
		int n = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					n++;
				}
			}
		}
		return n;
	}
}
