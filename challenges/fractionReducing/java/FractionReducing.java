import java.util.Arrays;
import java.util.stream.IntStream;

public class FractionReducing {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{2, 6}, {4, 1}, {5, 10}};
		int[][] expectedOutput = new int[][] {{1, 3}, {4, 1}, {1, 2}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = fractionReducing(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("fractionReducing(%s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[] fractionReducing(int[] fraction) {
		int d = gcd(fraction[0], fraction[1]);
		while (d > 1) {
			fraction[0] /= d;
			fraction[1] /= d;
			d = gcd(fraction[0], fraction[1]);
		}
		return fraction;
	}
	
	private static int gcd(int a, int b) {
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
}
