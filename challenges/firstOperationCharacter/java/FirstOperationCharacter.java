import java.util.List;
import java.util.stream.IntStream;

public class FirstOperationCharacter {
	public static void main(String[] args) {
		String[] input0 = new String[] {"(2 + 2) * 2", "2 + 2 * 2", "((2 + 2) * 2) * 3 + (2 + (2 * 2))", "2+((22+2222)+(2222+222))", "2 + 3 * 45 * 56 + 198 + 10938 * 102938 + 5", "1022224552222222 * 3", "4 * 3 + 2"};
		int[] expectedOutput = new int[] {3, 6, 28, 6, 6, 17, 2};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = firstOperationCharacter(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("firstOperationCharacter(\"%s\") returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int firstOperationCharacter(String expr) {
		List<Character> ADD_SUB_OPS = List.of('+', '-');
		List<Character> MUL_DIV_OPS = List.of('*', '/');
		int ADD_SUB_PRIORITY = 1;
		int MUL_DIV_PRIORITY = 2;
		int parenthesisPriority = 0;
		int maxParenthesisPriority = -1;
		int maxOperationPriority = -1;
		int firstOperationIndex = 0;
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if (c == '(') {
				parenthesisPriority++;
			} else if (c == ')') {
				parenthesisPriority--;
			} else if (ADD_SUB_OPS.contains(c)) {
				if (maxParenthesisPriority < parenthesisPriority) {
					maxParenthesisPriority = parenthesisPriority;
					maxOperationPriority = ADD_SUB_PRIORITY;
					firstOperationIndex = i;
				} else if (maxParenthesisPriority == parenthesisPriority && maxOperationPriority < ADD_SUB_PRIORITY) {
					maxOperationPriority = ADD_SUB_PRIORITY;
					firstOperationIndex = i;
				}
			} else if (MUL_DIV_OPS.contains(c)) {
				if (maxParenthesisPriority < parenthesisPriority) {
					maxParenthesisPriority = parenthesisPriority;
					maxOperationPriority = MUL_DIV_PRIORITY;
					firstOperationIndex = i;
				} else if (maxParenthesisPriority == parenthesisPriority && maxOperationPriority < MUL_DIV_PRIORITY) {
					maxOperationPriority = MUL_DIV_PRIORITY;
					firstOperationIndex = i;
				}
			}
		}
		return firstOperationIndex;
	}
}
