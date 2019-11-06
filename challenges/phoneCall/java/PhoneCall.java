import java.util.stream.IntStream;

public class PhoneCall {
	public static void main(String[] args) {
		int[] input0 = new int[] {3, 2, 10, 2, 1, 10};
		int[] input1 = new int[] {1, 2, 1, 2, 2, 10};
		int[] input2 = new int[] {2, 1, 2, 1, 1, 10};
		int[] input3 = new int[] {20, 2, 22, 24, 6, 8};
		int[] expectedOutput = new int[] {14, 1, 11, 14, 3, 0};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		assert input3.length == expectedOutput.length : String.format("# input3 = %d, # expectedOutput = %d", input3.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = phoneCall(input0[i], input1[i], input2[i], input3[i]);
			assert actualOutput == expectedOutput[i] : String.format("phoneCall(%d, %d, %d, %d) returned %d, but expected %d", input0[i], input1[i], input2[i], input3[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int phoneCall(int min1, int min2_10, int min11, int s) {
		int mins = 0;
		s -= min1;
		if (s >= 0)
			mins += 1;
		while (s - min2_10 >= 0 && mins < 10) {
			s -= min2_10;
			mins += 1;
		}
		while (s - min11 >= 0 && mins >= 10) {
			s -= min11;
			mins += 1;
		}
		return mins;
	}
}
