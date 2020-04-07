import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class TraverseTree {
	public static void main(String[] args) {
		Tree<Integer>[] input0 = new Tree[] {new Tree(1, new Tree(2, null, new Tree(3, null, null)), new Tree(4, new Tree(5, null, null), null)), null, new Tree(2, new Tree(1, null, new Tree(0, null, null)), null), new Tree(15, new Tree(15, null, null), null)};
		int[][] expectedOutput = new int[][] {{1, 2, 4, 3, 5}, {}, {2, 1, 0}, {15, 15}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = traverseTree(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("traverseTree(%s) returned %s, but expected %s", input0[i], Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int[] traverseTree(Tree<Integer> t) {
		if (t == null) {
			return new int[0];
		}
		List<Integer> l = new ArrayList<>();
		Deque<Tree<Integer>> s = new ArrayDeque<>();
		s.add(t);
		while (!s.isEmpty()) {
			t = s.pop();
			l.add(t.value);
			if (t.left != null) {
				s.add(t.left);
			}
			if (t.right != null) {
				s.add(t.right);
			}
		}
		return l.stream().mapToInt(Integer::intValue).toArray();
	}

	static class Tree<T> {
		public Tree(T value, Tree<T> left, Tree<T> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		public T value;
		public Tree<T> left;
		public Tree<T> right;

		@Override
		public String toString() {
			return "{\"value\": " + value.toString()
					+ ", \"left\": " + (left == null ? "null" : left.toString())
					+ ", \"right\": " + (right == null ? "null" : right.toString())
					+ "}";
		}
	}
}
