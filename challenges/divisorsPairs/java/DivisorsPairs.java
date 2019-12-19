import java.util.Arrays;
import java.util.stream.IntStream;

public class DivisorsPairs {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 3, 2}, {2, 4, 8}, {42}};
		int[] expectedOutput = new int[] {2, 3, 0};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = divisorsPairs(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("divisorsPairs(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int divisorsPairs(int[] sequence) {
		int count = 0;
		for (int i = 0; i < sequence.length; i++) {
			for (int j = 0; j < sequence.length; j++) {
				if (i != j && sequence[j]%sequence[i] == 0) {
					count++;
				}
			}
		}
		return count;
	}
}
