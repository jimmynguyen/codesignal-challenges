import java.util.Arrays;
import java.util.stream.IntStream;

public class FractionComparison {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{3, 4}, {3, 2}, {3, 5}};
		int[][] input1 = new int[][] {{6, 8}, {2, 5}, {2, 3}};
		char[] expectedOutput = new char[] {'=', '>', '<'};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			char actualOutput = fractionComparison(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("fractionComparison(%s, %s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.toString(input1[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static char fractionComparison(int[] a, int[] b) {
		double c = (double)a[0]/a[1];
		double d = (double)b[0]/b[1];
		return c < d ? '<' : c > d ? '>' : '=';
	}
}
