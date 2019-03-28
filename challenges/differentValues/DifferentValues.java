import java.util.stream.IntStream;

public class DifferentValues {
	public static void main(String[] args) {
		int[][] input1 = new int[][] {{3, 2, 1}, {3, 7}, {10, -11, -9, -3, 5, -15}, {14, 5, 13, 10, 3, -9}};
		int[] input2 = new int[] {2, 3, 3, 5};
		int[] expectedOutput = new int[] {2, -1, 2, 5};
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = differentValues(input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("differentValues(\"%s\", \"%d\") returned %d, but expected %d", input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
	}

	public static int differentValues(int[] a, int d) {
		int n = a.length, w, x, y, z = -1;
		for (int i=0;i<n;i++) {
			x = a[i];
			for (int j=i+1;j<n;j++) {
				y = a[j];
				w = Math.abs(x-y);
				if (w <= d && w > z) {
					z = w;
				}
			}
		}
		return z;
	}
}
