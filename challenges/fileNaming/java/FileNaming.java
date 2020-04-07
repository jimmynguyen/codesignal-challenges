import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FileNaming {
	public static void main(String[] args) {
		String[][] input0 = new String[][] {{"doc", "doc", "image", "doc(1)", "doc"}, {"a(1)", "a(6)", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"}, {"dd", "dd(1)", "dd(2)", "dd", "dd(1)", "dd(1)(2)", "dd(1)(1)", "dd", "dd(1)"}, {"a", "b", "cd", "b ", "a(3)"}, {"name", "name", "name(1)", "name(3)", "name(2)", "name(2)"}, {}};
		String[][] expectedOutput = new String[][] {{"doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"}, {"a(1)", "a(6)", "a", "a(2)", "a(3)", "a(4)", "a(5)", "a(7)", "a(8)", "a(9)", "a(10)", "a(11)"}, {"dd", "dd(1)", "dd(2)", "dd(3)", "dd(1)(1)", "dd(1)(2)", "dd(1)(1)(1)", "dd(4)", "dd(1)(3)"}, {"a", "b", "cd", "b ", "a(3)"}, {"name", "name(1)", "name(1)(1)", "name(3)", "name(2)", "name(2)(1)"}, {}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String[] actualOutput = fileNaming(input0[i]);
			assert Arrays.deepEquals(actualOutput, expectedOutput[i]) : String.format("fileNaming(%s) returned %s, but expected %s", Arrays.deepToString(input0[i]), Arrays.deepToString(actualOutput), Arrays.deepToString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static String[] fileNaming(String[] a) {
		List<String> s = new ArrayList<>();
		for (String x : a) {
			if (s.contains(x)) {
				int i = 1;
				String y = x + "(" + Integer.toString(i) + ")";
				while (s.contains(y)) {
					y = x + "(" + Integer.toString(++i) + ")";
				}
				s.add(y);
			} else {
				s.add(x);
			}
		}
		return s.toArray(new String[s.size()]);
	}
}
