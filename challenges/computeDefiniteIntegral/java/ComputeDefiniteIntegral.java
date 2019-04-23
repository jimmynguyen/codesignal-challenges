import java.util.stream.IntStream;

public class ComputeDefiniteIntegral {
	public static void main(String[] args) {
		int[] input0 = new int[] {-1, 1, -150};
		int[] input1 = new int[] {2, 3, 150};
		int[][] input2 = new int[][] {{0, 0, 0, 1}, {1, 0, 0, 4}, {0, 1, 0, 1, 0, 2, 0, 3}};
		double[] expectedOutput = new double[] {3.75, 82, 0};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			double actualOutput = computeDefiniteIntegral(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("computeDefiniteIntegral(%d, %d, %s) returned %f, but expected %f", input0[i], input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static double computeDefiniteIntegral(int l, int r, int[] p) {
		double R = 0;
		double L = 0;
		for (int i = 1; i <= p.length; i++) {
			R += p[i-1]*Math.pow(r, i)/i;
			L += p[i-1]*Math.pow(l, i)/i;
		}
		return R - L;
	}
}
