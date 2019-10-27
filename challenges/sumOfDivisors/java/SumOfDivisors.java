import java.util.stream.IntStream;

public class SumOfDivisors {
	public static void main(String[] args) {
		int[] input0 = new int[] {12, 1, 10, 6, 18, 24, 100, 239, 9, 576, 1000, 2592, 36, 10000, 1024, 9999};
		int[] expectedOutput = new int[] {28, 1, 18, 12, 39, 60, 217, 240, 13, 1651, 2340, 7623, 91, 24211, 2047, 15912};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = sumOfDivisors(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("sumOfDivisors(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int sumOfDivisors(int n) {
		int sum = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n%i == 0) {
				sum += n/i + (i == n/i ? 0 : i);
			}
		}
		return sum;
	}	
}
