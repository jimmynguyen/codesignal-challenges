import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NthElementFromTheEnd {
	public static void main(String[] args) {
		int[][] preInput0 = new int[][] {{1, 2, 3, 4}, {10, 4, 2, 5, 8, 3, 2, 4}, {10}, {10}, {10}, {-940915830, -282043402, -106017922, 24683474, 400181737}, {-940915830, -282043402, -106017922, 24683474, 400181737}, {-1000000000, -282043402, -106017922, 24683474, 1000000000}};
		ListNode<Integer>[] input0 = new ListNode[preInput0.length];
		for (int i = 0; i < input0.length; i++) {
			input0[i] = arr2listNode(preInput0[i]);
		}
		int[] input1 = new int[] {3, 9, 1, 2, 5, 6, 5, 5};
		int[] expectedOutput = new int[] {2, -1, 10, -1, -1, -1, -940915830, -1000000000};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = nthElementFromTheEnd(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("nthElementFromTheEnd(%s, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int nthElementFromTheEnd(ListNode<Integer> l, int n) {
		List<Integer> s = new ArrayList<>();
		while (l != null) {
			s.add(l.value);
			l = l.next;
		}
		return s.size()-n >= 0 ? s.get(s.size()-n) : -1;
	}

	static ListNode<Integer> arr2listNode(int[] arr) {
		ListNode<Integer> l = null, root = null;
		for (int x : arr) {
			if (l == null) {
				l = new ListNode<>(x);
				root = l;
			} else {
				l.next = new ListNode<>(x);
				l = l.next;
			}
		}
		return root;
	}

	static class ListNode<T> {
		public ListNode(T x) {
			value = x;
		}
		T value;
		ListNode<T> next;
	}
}
