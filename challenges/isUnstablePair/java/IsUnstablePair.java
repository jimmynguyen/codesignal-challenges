import java.util.stream.IntStream;

public class IsUnstablePair {
	public static void main(String[] args) {
		String[] input0 = new String[] {"aa", "A", "yyyyyy", "mehOu", "aaZ", "fdsAs", "aaad", "zzzzzAa123", "123za", "qwerTyu123"};
		String[] input1 = new String[] {"AAB", "z", "Azzzzzzzzz", "mehau", "AAzz", "dzdw", "aaAdd", "zzzzza", "123Z", "qwertyu"};
		boolean[] expectedOutput = new boolean[] {true, false, false, true, true, false, true, true, false, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = isUnstablePair(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("isUnstablePair(\"%s\", \"%s\") returned %b, but expected %b", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean isUnstablePair(String filename1, String filename2) {
		return compare(filename1, filename2) != compare(filename1.toUpperCase(), filename2.toUpperCase());
	}
	
	static int compare(String a, String b) {
		int x = a.length() == b.length() ? 0 : a.length() < b.length() ? -1 : 1;
		for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
			if (a.charAt(i) < b.charAt(i)) {
				x = -1;
				break;
			} else if (a.charAt(i) > b.charAt(i)) {
				x = 1;
				break;
			}
		}
		return x;
	}
}
