import java.util.Arrays;
import java.util.stream.IntStream;

public class WeakNumbers {
	public static void main(String[] args) {
		int[] input0 = new int[] {9, 1, 2, 7, 500, 4};
		int[][] expectedOutput = new int[][] {{2, 2}, {0, 1}, {0, 2}, {2, 1}, {403, 1}, {0, 4}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = weakNumbers(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("weakNumbers(%d) returned %s, but expected %s", input0[i], Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[] weakNumbers(int n) {
		int[] numDivisors = new int[n];
		for (int i = 0; i < n; i++)
			numDivisors[i] = getNumDivisors(i+1);
		int[] weakness = new int[n];
		int maxWeakness = -1;
		int numWeakness = 0;
		for (int i = 0; i < n; i++) {
			weakness[i] = getWeakness(i+1, numDivisors);
			if (weakness[i] > maxWeakness) {
				maxWeakness = weakness[i];
				numWeakness = 1;
			} else if (weakness[i] == maxWeakness)
				numWeakness++;
		}
		return new int[] { maxWeakness, numWeakness };
	}
	
	private static int getWeakness(int n, int[] numDivisors) {
		int weakness = 0;
		for (int i = 0; i < n-1; i++)
			if (numDivisors[i] > numDivisors[n-1])
				weakness++;
		return weakness;
	}
	
	private static int getNumDivisors(int n) {
		int numDivisors = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n%i == 0) {
				numDivisors += (double)n/i == i ? 1 : 2;
			}
		}
		return numDivisors;
	}
}
