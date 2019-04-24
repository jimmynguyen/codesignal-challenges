import java.util.stream.IntStream;

public class SpecialPolynomial {
	public static void main(String[] args) {
		int[] input0 = new int[] {2, 10, 1, 3};
		int[] input1 = new int[] {5, 111111110, 100, 140};
		int[] expectedOutput = new int[] {1, 7, 99, 4};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = specialPolynomial(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("specialPolynomial(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int specialPolynomial(int x, int n) {
		int s = 1, k = 0;
		while (s <= n) s += Math.pow(x, ++k);
		return k-1;
	}
}
