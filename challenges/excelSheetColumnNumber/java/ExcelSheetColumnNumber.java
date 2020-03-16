import java.util.stream.IntStream;

public class ExcelSheetColumnNumber {
	public static void main(String[] args) {
		String[] input0 = new String[] {"AB", "A", "ZZ", "OPQ", "DEAD", "SHEET", "RABBIT"};
		int[] expectedOutput = new int[] {28, 1, 702, 10573, 73714, 8826682, 214358502};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = excelSheetColumnNumber(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("excelSheetColumnNumber(\"%s\") returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int excelSheetColumnNumber(String s) {
		int c = 0;
		for (int i = 0; i < s.length(); i++) {
			c += (s.charAt(i)-'A'+1)*(int)Math.pow(26, s.length()-i-1);
		}
		return c;
	}
}
