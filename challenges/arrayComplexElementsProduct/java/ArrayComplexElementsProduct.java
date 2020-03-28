import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayComplexElementsProduct {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 2}, {1, 2, 3}};
		int[][] input1 = new int[][] {{1, 3}, {0, 0, 0}};
		int[][] expectedOutput = new int[][] {{-1, 5}, {6, 0}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = arrayComplexElementsProduct(input0[i], input1[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("arrayComplexElementsProduct(%s, %s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.toString(input1[i]), Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int[] arrayComplexElementsProduct(int[] real, int[] imag) {
		int[] prod = new int[] {real[0], imag[0]};
		for (int i = 1; i < real.length; i++) {
			int prodReal = prod[0] * real[i] - prod[1] * imag[i];
			int prodImag = prod[0] * imag[i] + prod[1] * real[i];
			prod = new int[] {prodReal, prodImag};
		}
		return prod;
	}
}
