import java.util.Arrays;
import java.util.stream.IntStream;

public class ProperOrImproper {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{7, 2}, {6, 3}, {-3, 3}, {0, -3}, {-2, -3}, {-2, -1}, {7, -7}, {7, -6}, {7, -8}, {7, 7}};
		String[] expectedOutput = new String[] {"Improper", "Improper", "Improper", "Proper", "Proper", "Improper", "Improper", "Improper", "Proper", "Improper"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = properOrImproper(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("properOrImproper(%s) returned \"%s\", but expected \"%s\"", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String properOrImproper(int[] a) {
		return Math.abs((double)a[0]/a[1]) < 1 ? "Proper" : "Improper";
	}
}
