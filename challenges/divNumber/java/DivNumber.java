import java.util.stream.IntStream;

public class DivNumber {
	public static void main(String[] args) {
		int[] input0 = new int[] {3, 4};
		int[] input1 = new int[] {2, 23};
		int[] input2 = new int[] {49, 75};
		int[] expectedOutput = new int[] {4, 16};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = divNumber(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("divNumber(%d, %d, %d) returned %d, but expected %d", input0[i], input1[i], input2[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int divNumber(int k, int l, int r) {
		int d = 0;
		for (int i = l; i <= r; i++) {
			int c = 0;
			for (int j = 1; j <= Math.sqrt(i); j++)
				if (i%j == 0)
					if (i/j == j)
						c++;
					else
						c += 2;
			if (c == k) d++;
		}
		return d;
	}
}
