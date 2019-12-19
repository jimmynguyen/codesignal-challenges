import java.util.stream.IntStream;

public class LastDigit {
	public static void main(String[] args) {
		int[] input0 = new int[] {2, 100, 999999, 583743};
		int[] input1 = new int[] {5, 0, 1000000, 384723};
		int[] expectedOutput = new int[] {2, 1, 1, 7};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = lastDigit(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("lastDigit(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int lastDigit(int a, int b) {
		if (b == 0) return 1;
		String r = String.valueOf(a);
		int n = Integer.parseInt(String.valueOf(r.charAt(r.length()-1)));
		String s = String.valueOf((int)Math.pow(n%10,b%4==0?4:b%4));
		return Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));
	}
}
