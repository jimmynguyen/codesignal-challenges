import java.util.Arrays;
import java.util.stream.IntStream;

public class LargestDistance {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{7, 6, 6, 8, 1, 2, 8, 6}, {0, 1, 1, 2}, {7, 2, 3, 8, 2, 10, 9, 7}};
		int[] expectedOutput = new int[] {7, 1, 8};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = largestDistance(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("largestDistance(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int largestDistance(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i+=2) {
			for (int j = i+2; j < a.length; j+=2) {
				if (max < Math.abs(a[i]-a[j])) {
					max = Math.abs(a[i]-a[j]);
				}
				if (max < Math.abs(a[i+1]-a[j+1])) {
					max = Math.abs(a[i+1]-a[j+1]);
				}
			}
		}
		return max;
	}
}
