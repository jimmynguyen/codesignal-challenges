import java.util.stream.IntStream;

public class RegexMatching {
	public static void main(String[] args) {
		String[] input0 = new String[] {"^code", "nal$", "hello", "aba", "def$", "^abc", "abcdefghi$", "^abcdefghijklmn", "d", "^coal", "tar$", "abcd", "^qwertyuiophasgdfkasdhflkjaeyuetyroueqwgbuherkyfgikegbflo", "afsdkjhakfaeyuwqtrowiequyolidchbslfkchadvgfkasdhjfkldsagfljdsgflkjdsagldslklfhevdshgfkldsjaghfldsahflhadshfdsah$", "^gdkhafglsdgaflsdhyfighdsflkjgclksdhgsdjflglsdkfhglkshdfbldkjshfggsfdkastkuyryuewbcbfocyr"};
		String[] input1 = new String[] {"codesignal", "codesignal", "world", "abacaba", "asdef", "abcdef", "fvsakhdgaskhfkasdjghfldgsafkajsdgfldsaghfiuewuabcdefghi", "abcdefghijklmngskhdgfasteywriwlurpewipoirzxbvvcmnxjcfklsajdof", "abacaba", "coaltar", "coaltar", "efgh", "vhjkasdgfkagekhfjaegflkerjgfhgerdkjfkdjasgfldksgfldsjgldjg", "sfadkhfjgkasdjhgkdasjgkdjfhgkdsjgfkjhdsgfljkdsgfdgfsjaghfldsahflhadshfdsahafsdkjhakfaeyuwqtrowiequyolidchbslfkchadvgfkasdhjfkldsagfljdsgflkjdsagldslklfhevdshgfkldsjaghfldsahflhadshfdsah", "gdkhafglsdgaflsdhyfighdsflkjgclksdhgsdjflglsdkfhglkshdfbldkjshfggsfdkastkuyryuewbcbfocyrgakjhfgkjsdagfkldasgkfjlhguireyyitfebfghjdgld"};
		boolean[] expectedOutput = new boolean[] {true, true, false, true, true, true, true, true, false, true, true, false, false, true, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = regexMatching(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("regexMatching(\"%s\", \"%s\") returned %b, but expected %b", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean regexMatching(String pattern, String test) {
		if (pattern.charAt(0) == '^') {
			return test.startsWith(pattern.substring(1));
		} else if (pattern.charAt(pattern.length()-1) == '$') {
			return test.endsWith(pattern.substring(0, pattern.length()-1));
		} else {
			return test.contains(pattern);
		}
	}
}
