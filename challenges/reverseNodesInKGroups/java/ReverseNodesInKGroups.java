import java.util.stream.IntStream;

public class ReverseNodesInKGroups {
	public static void main(String[] args) {
		int[][] preInput0 = new int[][] {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, {239}, {1, 2, 3, 4}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, {1000000000, -849483855, -1000000000, 376365554, -847904832}, {376365554, -340557143, -849483855, 810952169, -847904832}, {810952169, -849483855, -340557143, 376365554, -847904832}, {-503549928, -526666356, 262916773, -508129645, 992040586, 867794712, 24042453, -540165420, -417669299, 766910780}, {-526666356, -503549928, -508129645, 262916773, 867794712, 992040586, -540165420, 24042453, 766910780, -417669299}, {24042453, -540165420, 992040586, 867794712, 262916773, -508129645, -503549928, -526666356, 766910780, -417669299}};
		ListNode<Integer>[] input0 = arr2node(preInput0);
		int[] input1 = new int[] {2, 1, 3, 1, 2, 3, 4, 4, 4, 2, 2, 8, 6};
		int[][] preExpectedOutput = new int[][] {{2, 1, 4, 3, 5}, {1, 2, 3, 4, 5}, {3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11}, {239}, {2, 1, 4, 3}, {3, 2, 1, 6, 5, 4, 9, 8, 7, 12, 11, 10}, {4, 3, 2, 1, 8, 7, 6, 5, 12, 11, 10, 9}, {376365554, -1000000000, -849483855, 1000000000, -847904832}, {810952169, -849483855, -340557143, 376365554, -847904832}, {-849483855, 810952169, 376365554, -340557143, -847904832}, {-526666356, -503549928, -508129645, 262916773, 867794712, 992040586, -540165420, 24042453, 766910780, -417669299}, {24042453, -540165420, 992040586, 867794712, 262916773, -508129645, -503549928, -526666356, 766910780, -417669299}, {-508129645, 262916773, 867794712, 992040586, -540165420, 24042453, -503549928, -526666356, 766910780, -417669299}};
		ListNode<Integer>[] expectedOutput = arr2node(preExpectedOutput);
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			ListNode<Integer> actualOutput = reverseNodesInKGroups(input0[i], input1[i]);
			assert equals(actualOutput, expectedOutput[i]) : String.format("reverseNodesInKGroups(%s, %d) returned %s, but expected %s", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> root, int k) {
		ListNode<Integer> segmentStart = root;
		ListNode<Integer> segmentEnd = root;
		ListNode<Integer> beforeSegment = null;
		ListNode<Integer> afterSegment = null;
		int n = 1;
		while (segmentEnd != null) {
			if (n == k) {
				afterSegment = segmentEnd.next;
				ListNode<Integer> prev = afterSegment;
				ListNode<Integer> curr = segmentStart;
				ListNode<Integer> next = segmentStart.next;
				while (curr != afterSegment) {
					curr.next = prev;
					prev = curr;
					curr = next;
					next = next == null ? null : next.next;
				}
				if (beforeSegment == null) {
					root = prev;
				} else {
					beforeSegment.next = prev;
				}
				beforeSegment = segmentStart;
				segmentStart = afterSegment;
				segmentEnd = afterSegment;
				n = 1;
			} else {
				segmentEnd = segmentEnd.next;
				n++;
			}
		}
		return root;
	}

	static class ListNode<T> {
		public T value;
		public ListNode<T> next;
		public ListNode(T x) {
			value = x;
		}
	}

	static ListNode<Integer> arr2node(int[] arr) {
		ListNode<Integer> root = new ListNode<>(arr[0]);
		ListNode<Integer> curr = root;
		ListNode<Integer> next;
		for (int i = 1; i < arr.length; i++) {
			next = new ListNode<>(arr[i]);
			curr.next = next;
			curr = next;
		}
		return root;
	}

	static ListNode<Integer>[] arr2node(int[][] arr) {
		ListNode<Integer>[] node = new ListNode[arr.length];
		for (int i = 0; i < arr.length; i++) {
			node[i] = arr2node(arr[i]);
		}
		return node;
	}

	static boolean equals(ListNode<Integer> a, ListNode<Integer> b) {
		while (a != null && b != null) {
			if (a.value - b.value != 0) {
				return false;
			}
			a = a.next;
			b = b.next;
		}
		return a == null && b == null;
	}

	static void print(ListNode<Integer> n) {
		System.out.print("[" + node2str(n));
		while (n.next != null) {
			n = n.next;
			System.out.print(", " + node2str(n));
		}
		System.out.println("]");
	}
	
	static String node2str(ListNode<Integer> n) {
		if (n == null) {
			return "null";
		}
		String s = "{value=" + n.value.toString() + ",";
		if (n.next != null) {
			s += "next=" + n.next.value.toString();
		} else {
			s += "next=null";
		}
		s += "}";
		return s;
	}
}
