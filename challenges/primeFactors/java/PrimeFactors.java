import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimeFactors {
	public static void main(String[] args) {
		int[] input0 = new int[] {100, 1, 2};
		int[][] expectedOutput = new int[][] {{2, 2, 5, 5}, {}, {2}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = primeFactors(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("primeFactors(%d) returned %s, but expected %s", input0[i], Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int[] primeFactors(int n) {
		int[] f = new int[0];
		for (int i = 2; i <= n; i++) {
			while (n%i == 0) {
				n /= i;
				int[] g = new int[f.length+1];
				for (int j = 0; j < f.length; j++) {
					g[j] = f[j];
				}
				g[f.length] = i;
				f = g;
			}
			if (n == 1) {
				break;
			}
		}
		return f;
	}
}
