import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class UniqueDigitProducts {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{2, 8, 121, 42, 222, 23}, {239}, {100, 101, 111}, {100, 23, 42, 239, 22339, 9999999, 456, 78, 228, 1488}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}};
		int[] expectedOutput = new int[] {3, 1, 2, 10, 10};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = uniqueDigitProducts(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("uniqueDigitProducts(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int uniqueDigitProducts(int[] a) {
		Set<Integer> products = new HashSet<>();
		for (int i = 0, product; i < a.length; i++) {
			product = 1;
			for (char c : Integer.toString(a[i]).toCharArray())
				product *= Integer.parseInt(String.valueOf(c));
			products.add(product);
		}
		return products.size();
	}
}
