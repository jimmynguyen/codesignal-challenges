import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayMinimumIndex {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{19, 32, 11, 23}, {1, 4, 10, 3, 2}, {0, -2, 5, 6, -9}};
		int[] expectedOutput = new int[] {2, 0, 4};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = arrayMinimumIndex(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("arrayMinimumIndex(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int arrayMinimumIndex(int[] arr) {
		int n = 0;
		for (int i = 1; i < arr.length; i++)
			if (arr[n] > arr[i])
				n = i;
		return n;
	}
}
