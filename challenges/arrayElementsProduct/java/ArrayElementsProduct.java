import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayElementsProduct {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 3, 2, 10}, {2, 4, 10, 1}, {1, 1}};
		int[] expectedOutput = new int[] {60, 80, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = arrayElementsProduct(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("arrayElementsProduct(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int arrayElementsProduct(int[] a) {
		int p = 1;
		for (int n : a) {
			p *= n;
		}
		return p;
	}
}
