import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.IntStream;

public class PrimeFactors2 {
	public static void main(String[] args) {
		int[] input0 = new int[] {100, 1, 10, 2, 120, 239, 12, 20, 35, 101, 700, 2431, 9702, 76500, 30352762};
		int[][] expectedOutput = new int[][] {{2, 5}, {}, {2, 5}, {2}, {2, 3, 5}, {239}, {2, 3}, {2, 5}, {5, 7}, {101}, {2, 5, 7}, {11, 13, 17}, {2, 3, 7, 11}, {2, 3, 5, 17}, {2, 11, 487, 2833}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = primeFactors2(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("primeFactors2(%d) returned %s, but expected %s", input0[i], Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[] primeFactors2(int n) {
		Set<Integer> primeFactors = new HashSet<>();
		while (n%2 == 0) {
			primeFactors.add(2);
			n /= 2;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2)
			while (n%i == 0) {
				primeFactors.add(i);
				n /= i;
			}
		if (n > 2)
			primeFactors.add(n);
		return primeFactors.stream().sorted().mapToInt(x -> x).toArray();
	}
}
