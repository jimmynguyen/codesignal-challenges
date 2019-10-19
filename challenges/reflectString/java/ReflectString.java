import java.util.stream.IntStream;

public class ReflectString {
	public static void main(String[] args) {
		String[] input0 = new String[] {"name", "abyz", "nnnnn", "pqr", "codesignal"};
		String[] expectedOutput = new String[] {"mznv", "zyba", "mmmmm", "kji", "xlwvhrtmzo"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = reflectString(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("reflectString(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String reflectString(String s) {
		String r = "";
		for (char c : s.toCharArray())
			r += "zyxwvutsrqponmlkjihgfedcba".charAt("abcdefghijklmnopqrstuvwxyz".indexOf(c));
		return r;
	}
}
