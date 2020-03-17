import java.util.Arrays;
import java.util.stream.IntStream;

public class GraphEdges {
	public static void main(String[] args) {
		boolean[][][] input0 = new boolean[][][] {{{false,true,true}, {true,false,false}, {true,false,false}}, {{false,false,false}, {false,false,false}, {false,false,false}}, {{false,true,true}, {true,false,true}, {true,true,false}}, {{false,true,true,false}, {true,false,true,true}, {true,true,false,true}, {false,true,true,false}}, {{false,true,true,false}, {true,false,true,false}, {true,true,false,true}, {false,false,true,false}}, {{false,true,true,true,true}, {true,false,true,true,true}, {true,true,false,false,false}, {true,true,false,false,false}, {true,true,false,false,false}}, {{false,false,false,false,false}, {false,false,false,false,false}, {false,false,false,false,false}, {false,false,false,false,false}, {false,false,false,false,false}}, {{false,true,true,false,true,true}, {true,false,true,true,false,true}, {true,true,false,false,false,true}, {false,true,false,false,false,true}, {true,false,false,false,false,true}, {true,true,true,true,true,false}}, {{false,true,false,true,true,true}, {true,false,true,true,false,true}, {false,true,false,true,true,true}, {true,true,true,false,true,true}, {true,false,true,true,false,false}, {true,true,true,true,false,false}}};
		int[] expectedOutput = new int[] {2, 0, 3, 5, 4, 7, 0, 10, 12};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = graphEdges(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("graphEdges(%s) returned %d, but expected %d", Arrays.deepToString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int graphEdges(boolean[][] matrix) {
		int c = 0, n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (matrix[i][j]) {
					c++;
				}
			}
		}
		return c;
	}
}
