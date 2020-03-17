import java.util.Arrays;
import java.util.stream.IntStream;

public class EquationTemplate {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{2, 4, 3, 6}, {2, 3, 30, 5}, {2, 3, 5, 5}, {1, 2, 3, 4}, {0, 1, 1, 1}, {0, 10, 20, 0}, {-10, -20, 5, 40}, {2, 3, 6, 4}, {2, 12, 3, 2}, {8, 2, 2, 2}, {4, 4, 4, 64}};
		boolean[] expectedOutput = new boolean[] {true, true, false, false, false, true, true, true, true, true, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = equationTemplate(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("equationTemplate(%s) returned %b, but expected %b", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean equationTemplate(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				for (int k = 0; k < a.length; k++) {
					for (int l = 0; l < a.length; l++) {
						if (i != j
								&& i != k
								&& i != l
								&& j != k
								&& j != l
								&& k != l
								&& (a[i]*a[j]*a[k] == a[l] || a[i]*a[j] == a[k]*a[l])) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
