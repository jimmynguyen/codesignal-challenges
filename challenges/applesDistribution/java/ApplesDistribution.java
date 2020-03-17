import java.util.stream.IntStream;

public class ApplesDistribution {
	public static void main(String[] args) {
		int[] input0 = new int[] {7, 10, 4};
		int[] input1 = new int[] {4, 5, 4};
		int[] input2 = new int[] {1, 1, 3};
		int[] expectedOutput = new int[] {3, 4, 4};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = applesDistribution(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("applesDistribution(%d, %d, %d) returned %d, but expected %d", input0[i], input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int applesDistribution(int apples, int boxCapacity, int maxResidue) {
		int c = 0;
		for (int n = 1; n <= boxCapacity; n++) {
			if (apples%n <= maxResidue) {
				c++;
			}
		}
		return c;
	}
}
