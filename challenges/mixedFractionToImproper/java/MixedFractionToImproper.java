import java.util.Arrays;
import java.util.stream.IntStream;

public class MixedFractionToImproper {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{3, 1, 2}, {3, 1, 3}};
		int[][] expectedOutput = new int[][] {{7, 2}, {10, 3}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = mixedFractionToImproper(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("mixedFractionToImproper(%s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int[] mixedFractionToImproper(int[] a) {
		int n = a[0] * a[2] + a[1];
		int d = a[2];
		int c = gcd(n, d);
		return new int[] {n/c, d/c};
	}
	
	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
}
