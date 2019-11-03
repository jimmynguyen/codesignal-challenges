import java.util.stream.IntStream;

public class IsLucky {
	public static void main(String[] args) {
		int[] input0 = new int[] {1230, 239017, 134008, 10, 11, 1010, 261534, 100000, 999999, 123321};
		boolean[] expectedOutput = new boolean[] {true, false, true, false, true, true, false, false, true, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = isLucky(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("isLucky(%d) returned %b, but expected %b", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean isLucky(int n) {
		int a = 0;
		int b = 0;
		String s = Integer.toString(n);
		int k = s.length();
		for (int i = 0; i < k; i++) {
			int d = Character.getNumericValue(s.charAt(i));
			if (i < k/2)
				a += d;
			else
				b += d;
		}
		return a == b;
	}
}
