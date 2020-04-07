import java.util.stream.IntStream;

public class DigitTreeSum {
	public static void main(String[] args) {
		Tree<Long>[] input0 = new Tree[] {new Tree(1, new Tree(0, new Tree(3, null, null), new Tree(1, null, null)), new Tree(4, null, null)), new Tree(0, new Tree(9, null, null), new Tree(9, new Tree(1, null, null), new Tree(3, null, null))), new Tree(9, null, null), new Tree(0, new Tree(0, null, null), new Tree(0, null, null)), new Tree(0, new Tree(1, null, null), null)};
		long[] expectedOutput = new long[] {218, 193, 9, 0, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			long actualOutput = digitTreeSum(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("digitTreeSum(%s) returned %s, but expected %s", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static long digitTreeSum(Tree<Long> t) {
		return digitTreeSum(t, "");
	}
	
	static long digitTreeSum(Tree<Long> t, String prefix) {
		if (t == null) {
			return 0;
		} else if (t.left == null && t.right == null) {
			return Long.parseLong(prefix + t.value);
		}
		return digitTreeSum(t.left, prefix + t.value) + digitTreeSum(t.right, prefix + t.value);
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
