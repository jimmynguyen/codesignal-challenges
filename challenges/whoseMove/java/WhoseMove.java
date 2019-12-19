import java.util.stream.IntStream;

public class WhoseMove {
	public static void main(String[] args) {
		String[] input0 = new String[] {"black", "white", "white"};
		boolean[] input1 = new boolean[] {false, true, false};
		String[] expectedOutput = new String[] {"white", "white", "black"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = whoseMove(input0[i], input1[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("whoseMove(\"%s\", %b) returned \"%s\", but expected \"%s\"", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String whoseMove(String lastPlayer, boolean win) {
		return win ? lastPlayer : lastPlayer.equals("white") ? "black" : "white";
	}
}
