import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class ComfortableNumbers {
	public static void main(String[] args) {
		int[] input0 = new int[] {10, 1, 13, 12, 239, 1};
		int[] input1 = new int[] {12, 9, 13, 108, 777, 1000};
		int[] expectedOutput = new int[] {2, 20, 0, 707, 6166, 11435};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = comfortableNumbers(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("comfortableNumbers(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int comfortableNumbers(int l, int r) {
		Map<Integer, Set<Integer>> m = new HashMap<>();
		for (int i = l; i <= r; i++) {
			m.put(i, new HashSet<>());
			int s = 0;
			for (char c : Integer.toString(i).toCharArray()) {
				s += c - '0';
			}
			for (int j = i-s; j <= i+s; j++) {
				m.get(i).add(j);
			}
		}
		int c = 0;
		for (int i = l; i < r; i++) {
			for (int j = i+1; j <= r; j++) {
				if (m.get(i).contains(j) && m.get(j).contains(i)) {
					c++;
				}
			}
		}
		return c;
	}
}
