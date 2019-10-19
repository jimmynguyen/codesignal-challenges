import java.util.stream.IntStream;

public class SumOfMultiples {
	public static void main(String[] args) {
		int[] input0 = new int[] {7, 4, 5};
		int[] input1 = new int[] {2, 1, 2};
		int[] expectedOutput = new int[] {12, 10, 6};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = sumOfMultiples(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("sumOfMultiples(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int sumOfMultiples(int n, int k) {
		int j = 0;
		for (int i = 1; i <= n; i++)
			j += i % k == 0 ? i : 0;
		return j;
	}
}
