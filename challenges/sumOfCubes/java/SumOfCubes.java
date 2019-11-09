import java.util.stream.IntStream;

public class SumOfCubes {
	public static void main(String[] args) {
		int[] input0 = new int[] {3, 1};
		int[] expectedOutput = new int[] {36, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = sumOfCubes(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("sumOfCubes(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int sumOfCubes(int n) {
		return (int)IntStream.range(0, n+1).mapToDouble(i -> Math.pow(i, 3)).sum();
	}
}
