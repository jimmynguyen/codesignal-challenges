import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class BfsComponentSize {
	public static void main(String[] args) {
		boolean[][][] input0 = new boolean[][][] {{{false,true,false}, {true,false,false}, {false,false,false}}, {{false,false,true,false}, {false,false,false,false}, {true,false,false,true}, {false,false,true,false}}, {{false,false,false}, {false,false,false}, {false,false,false}}, {{false,true,true}, {true,false,false}, {true,true,false}}};
		int[] expectedOutput = new int[] {2, 1, 1, 3};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = bfsComponentSize(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("bfsComponentSize(%s) returned %d, but expected %d", Arrays.deepToString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int bfsComponentSize(boolean[][] matrix) {
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[matrix.length];
		visited[1] = true;
		queue.add(1);
		int s;
		while (queue.size() != 0) {
			s = queue.poll();
			for (int i = 0; i < matrix.length; i++)
				if (matrix[s][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
		}
		int n = 0;
		for (int i = 0; i < visited.length; i++)
			if (visited[i])
				n++;
		return n;
	}
}
