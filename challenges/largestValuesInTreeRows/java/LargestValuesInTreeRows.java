import java.util.Arrays;
import java.util.stream.IntStream;

public class LargestValuesInTreeRows {
	public static void main(String[] args) {
		Tree<Integer>[] input0 = new Tree[] {new Tree(-1, new Tree(5, null, null), new Tree(7, null, new Tree(1, null, null))), null, new Tree(-1, null, null), new Tree(-1, new Tree(5, null, null), new Tree(7, null, new Tree(1, new Tree(5, null, null), null))), new Tree(-1, new Tree(5, new Tree(-1, new Tree(10, null, null), null), null), new Tree(7, null, new Tree(1, new Tree(5, null, null), null)))};
		int[][] expectedOutput = new int[][] {{-1, 7, 1}, {}, {-1}, {-1, 7, 1, 5}, {-1, 7, 1, 10}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = largestValuesInTreeRows(input0[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("largestValuesInTreeRows(%s) returned %s, but expected %s", input0[i], Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int[] largestValuesInTreeRows(Tree<Integer> t) {
		return largestValuesInTreeRows(t, 0, new int[0]);
	}
	
	static int[] largestValuesInTreeRows(Tree<Integer> t, int d, int[] a) {
		if (t == null) {
			return a;
		}
		int[] b;
		if (d >= a.length) {
			b = new int[d+1];
			for (int i = 0; i <= d; i++) {
				b[i] = i < a.length ? a[i] : Integer.MIN_VALUE;
			}
		} else {
			b = a;
		}
		if (t.value > b[d]) {
			b[d] = t.value;
		}
		return largestValuesInTreeRows(t.right, d+1, largestValuesInTreeRows(t.left, d+1, b));
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
