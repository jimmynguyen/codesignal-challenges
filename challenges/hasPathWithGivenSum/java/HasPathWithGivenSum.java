import java.util.stream.IntStream;

public class HasPathWithGivenSum {
	public static void main(String[] args) {
		Tree<Integer>[] input0 = new Tree[] {new Tree(4, new Tree(1, new Tree(-2, null, new Tree(3, null, null)), null), new Tree(3, new Tree(1, null, null), new Tree(2, new Tree(-2, null, null), new Tree(-3, null, null)))), new Tree(4, new Tree(1, new Tree(-2, null, new Tree(3, null, null)), null), new Tree(3, new Tree(1, null, null), new Tree(2, new Tree(-4, null, null), new Tree(-3, null, null)))), null, new Tree(5, null, null), new Tree(5, null, null), new Tree(5, null, null), new Tree(8, null, new Tree(3, null, null)), new Tree(5, new Tree(7, null, null), null)};
		int[] input1 = new int[] {7, 7, 1, 5, -5, 0, 8, 5};
		boolean[] expectedOutput = new boolean[] {true, false, false, true, false, false, false, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = hasPathWithGivenSum(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("hasPathWithGivenSum(%s, %d) returned %b, but expected %b", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
		if (t == null) {
			return false;
		} else if (t.left == null && t.right == null && t.value == s) {
			return true;
		}
		return (t.left != null ? hasPathWithGivenSum(t.left, s - t.value) : false)
				|| (t.right != null ? hasPathWithGivenSum(t.right, s - t.value) : false);
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
