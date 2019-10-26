import java.util.stream.IntStream;

public class Decipher {
	public static void main(String[] args) {
		String[] input0 = new String[] {"10197115121", "98", "122", "1229897", "97989910010110210310410510610710810911011111211311411511611711811912012112297", "10297115106108102108971061151041029897107106115981001029710711510010298", "11211111911310110810910097107108115111112119113101106107971101021101061021041149710511411497"};
		String[] expectedOutput = new String[] {"easy", "b", "z", "zba", "abcdefghijklmnopqrstuvwxyza", "fasjlflajshfbakjsbdfaksdfb", "powqelmdaklsopwqejkanfnjfhrairra"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = decipher(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("decipher(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String decipher(String cipher) {
		String message = "";
		while (!cipher.isEmpty()) {
			int ndx = cipher.charAt(0) == '9' ? 2 : 3;
			message += Character.toString((char) Integer.parseInt(cipher.substring(0, ndx)));
			cipher = cipher.substring(ndx);
		}
		return message;
	}
}
