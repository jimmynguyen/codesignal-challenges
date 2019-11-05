import java.util.stream.IntStream;

public class BishopAndPawn {
	public static void main(String[] args) {
		String[] input0 = new String[] {"a1", "h1", "a5", "g1", "e7", "e7", "e3", "a1", "a1", "h1"};
		String[] input1 = new String[] {"c3", "h3", "c3", "f3", "d6", "a3", "a7", "h8", "h7", "a8"};
		boolean[] expectedOutput = new boolean[] {true, false, true, false, true, true, true, true, false, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = bishopAndPawn(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("bishopAndPawn(\"%s\", \"%s\") returned %b, but expected %b", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean bishopAndPawn(String bishop, String pawn) {
		return Math.abs((double)(bishop.charAt(0) - pawn.charAt(0)) / (bishop.charAt(1) - pawn.charAt(1))) == 1;
	}
}
