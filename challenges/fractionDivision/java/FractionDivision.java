import java.util.Arrays;
import java.util.stream.IntStream;

public class FractionDivision {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{2, 3}, {9, 4}};
		int[][] input1 = new int[][] {{5, 6}, {3, 4}};
		int[][] expectedOutput = new int[][] {{4, 5}, {3, 1}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = fractionDivision(input0[i], input1[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("fractionDivision(%s, %s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.toString(input1[i]), Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int[] fractionDivision(int[] a, int[] b) {
		int c = a[0]*b[1];
		int d = a[1]*b[0];
		int e = gcd(d, c);
		return new int[] {c/e, d/e};
	}
	
	static int gcd(int a, int b) {
		return a == 0 ? b : gcd(b%a, a);
	}
}
