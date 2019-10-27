import java.util.Arrays;
import java.util.stream.IntStream;

public class VolleyballPositions {
	public static void main(String[] args) {
		String[][][] input0 = new String[][][] {{{"empty","Player5","empty"}, {"Player4","empty","Player2"}, {"empty","Player3","empty"}, {"Player6","empty","Player1"}}, {{"empty","Alice","empty"}, {"Bob","empty","Charlie"}, {"empty","Dave","empty"}, {"Eve","empty","Frank"}}, {{"empty","player 3","empty"}, {"player 3","empty","player"}, {"empty","4","empty"}, {"5","empty","42"}}, {{"empty","player 3","empty"}, {"player 8","empty","player"}, {"empty","4","empty"}, {"5","empty","42"}}, {{"empty","player 3","empty"}, {"player 8","empty","player"}, {"empty","4","empty"}, {"5","empty","42"}}, {{"empty","Alice","empty"}, {"Bob","empty","Charlie"}, {"empty","Dave","empty"}, {"Eve","empty","Frank"}}, {{"empty","1","empty"}, {"?","empty","!"}, {"empty",".","empty"}, {"3","empty","2"}}, {{"empty","","empty"}, {"","empty",""}, {"empty","!!!","empty"}, {"","empty",""}}, {{"empty","Alice","empty"}, {"Bob","empty","Charlie"}, {"empty","Dave","empty"}, {"Eve","empty","Frank"}}, {{"empty","a","empty"}, {"b","empty","c"}, {"empty","d","empty"}, {"e","empty","f"}}};
		int[] input1 = new int[] {2, 6, 1000000, 0, 1000000000, 7, 666, 541, 0, 3220832};
		String[][][] expectedOutput = new String[][][] {{{"empty","Player1","empty"}, {"Player2","empty","Player3"}, {"empty","Player4","empty"}, {"Player5","empty","Player6"}}, {{"empty","Alice","empty"}, {"Bob","empty","Charlie"}, {"empty","Dave","empty"}, {"Eve","empty","Frank"}}, {{"empty","5","empty"}, {"4","empty","player 3"}, {"empty","player","empty"}, {"42","empty","player 3"}}, {{"empty","player 3","empty"}, {"player 8","empty","player"}, {"empty","4","empty"}, {"5","empty","42"}}, {{"empty","5","empty"}, {"4","empty","player 8"}, {"empty","player","empty"}, {"42","empty","player 3"}}, {{"empty","Charlie","empty"}, {"Alice","empty","Frank"}, {"empty","Eve","empty"}, {"Bob","empty","Dave"}}, {{"empty","1","empty"}, {"?","empty","!"}, {"empty",".","empty"}, {"3","empty","2"}}, {{"empty","","empty"}, {"","empty",""}, {"empty","","empty"}, {"","empty","!!!"}}, {{"empty","Alice","empty"}, {"Bob","empty","Charlie"}, {"empty","Dave","empty"}, {"Eve","empty","Frank"}}, {{"empty","f","empty"}, {"c","empty","d"}, {"empty","b","empty"}, {"a","empty","e"}}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String[][] actualOutput = volleyballPositions(input0[i], input1[i]);
			assert Arrays.deepEquals(actualOutput, expectedOutput[i]) : String.format("volleyballPositions(%s, %d) returned %s, but expected %s", Arrays.deepToString(input0[i]), input1[i], Arrays.deepToString(actualOutput), Arrays.deepToString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String[][] volleyballPositions(String[][] formation, int k) {
		String player;
		for (int i = 0; i < k%6; i++) {
			player = formation[0][1];
			formation[0][1] = formation[1][2];
			formation[1][2] = formation[3][2];
			formation[3][2] = formation[2][1];
			formation[2][1] = formation[3][0];
			formation[3][0] = formation[1][0];
			formation[1][0] = player;
		}
		return formation;
	}
}
