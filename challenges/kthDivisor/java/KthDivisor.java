import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class KthDivisor {
	public static void main(String[] args) {
		int[] input0 = new int[] {63, 5, 100, 16, 239};
		int[] input1 = new int[] {4, 3, 10, 5, 3};
		int[] expectedOutput = new int[] {9, -1, -1, 16, -1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = kthDivisor(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("kthDivisor(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int kthDivisor(int n, int k) {
		SortedSet<Integer> divisors = new TreeSet<>();
		divisors.add(1);
		divisors.add(n);
		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n%i == 0) {
				divisors.add(i);
				divisors.add(n/i);
			}
		return divisors.size() > k-1 ? new ArrayList<>(divisors).get(k-1) : -1;
	}
}
