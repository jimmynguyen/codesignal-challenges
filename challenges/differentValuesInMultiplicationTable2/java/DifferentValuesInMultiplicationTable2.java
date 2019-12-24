import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class DifferentValuesInMultiplicationTable2 {
	public static void main(String[] args) {
		int[] input0 = new int[] {3, 4, 1, 7};
		int[] input1 = new int[] {2, 4, 20, 5};
		int[] expectedOutput = new int[] {5, 9, 20, 22};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = differentValuesInMultiplicationTable2(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("differentValuesInMultiplicationTable2(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int differentValuesInMultiplicationTable2(int n, int m) {
		Set<Integer> s = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				s.add(i*j);
			}
		}
		return s.size();
	}
}
