import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class DeDup {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{1, 2, 3, 3, 3, 3, 3}, {1, 1, 1}};
		int[][] expectedOutput = new int[][] {{1, 2, 3}, {1}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = deDup(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("deDup(%s) returned %s, but expected %s", Arrays.toString(input0[i]), Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int[] deDup(int[] a) {
		SortedSet<Integer> s = new TreeSet<>();
		for (int i = 0; i < a.length; i++)
			s.add(a[i]);
		int[] b = new int[s.size()];
		int i = 0;
		for (int n : s)
			b[i++] = n;
		return b;
	}
}
