import java.util.stream.IntStream;

public class SmallestMultiple {
	public static void main(String[] args) {
		int[] input0 = new int[] {2, 1};
		int[] input1 = new int[] {4, 1};
		int[] expectedOutput = new int[] {12, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = smallestMultiple(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("smallestMultiple(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int smallestMultiple(int left, int right) {
		int multiple = right;
		boolean found = false;
		while (!found) {
			found = true;
			for (int i = left; i <= right; i++)
				if (multiple%i != 0) {
					found = false;
					break;
				}
			if (!found)
				multiple++;
		}
		return multiple;
	}
}
