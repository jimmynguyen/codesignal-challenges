import java.util.stream.IntStream;

public class FullName {
	public static void main(String[] args) {
		String[] input0 = new String[] {"David", "Tigran", "Aram"};
		String[] input1 = new String[] {"Stevenson", "Sloyan", "Shatakhtsyan"};
		String[] expectedOutput = new String[] {"David Stevenson", "Tigran Sloyan", "Aram Shatakhtsyan"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = fullName(input0[i], input1[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("fullName(\"%s\", \"%s\") returned \"%s\", but expected \"%s\"", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String fullName(String first, String last) {
		return String.format("%s %s", first, last);
	}
}
