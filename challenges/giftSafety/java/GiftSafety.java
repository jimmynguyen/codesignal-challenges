import java.util.Arrays;
import java.util.stream.IntStream;

public class GiftSafety {
	public static void main(String[] args) {
		String[] input0 = new String[] {"doll", "aaaaaaa", "cat", "cd", "aaaabbbcccdddeffffff", "cannon"};
		int[] expectedOutput = new int[] {1, 5, 0, 0, 17, 3};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = giftSafety(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("giftSafety(\"%s\") returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int giftSafety(String gift) {
		int safety = 0;
		for (int i = 0; i < gift.length()-2; i++) {
			if (Arrays.asList(
					"" + gift.charAt(i) + gift.charAt(i+2) + gift.charAt(i+1),
					"" + gift.charAt(i+1) + gift.charAt(i) + gift.charAt(i+2),
					"" + gift.charAt(i+2) + gift.charAt(i+1) + gift.charAt(i),
					"" + gift.charAt(i+2) + gift.charAt(i) + gift.charAt(i+1)).contains(gift.substring(i, i+3))) {
				safety++;
			}
		}
		return safety;
	}
}
