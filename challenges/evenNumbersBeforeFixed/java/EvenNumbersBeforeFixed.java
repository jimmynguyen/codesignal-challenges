import java.util.Arrays;
import java.util.stream.IntStream;

public class EvenNumbersBeforeFixed {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 4, 2, 6, 3, 1}, {2, 2, 2, 1}, {2, 3, 4, 3}};
		int[] input1 = new int[] {6, 3, 3};
		int[] expectedOutput = new int[] {2, -1, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = evenNumbersBeforeFixed(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("evenNumbersBeforeFixed(%s, %d) returned %d, but expected %d", Arrays.toString(input0[i]), input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int evenNumbersBeforeFixed(int[] s, int e) {
		int c = 0;
		for (int i = 0; i < s.length;) {
			if (s[i] == e) return c;
			c += s[i++]%2==0 ? 1 : 0;
		}
		return -1;
	}
}
