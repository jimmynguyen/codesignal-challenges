import java.util.Arrays;
import java.util.stream.IntStream;

public class UnusualDictionary {
	public static void main(String[] args) {
		String[][] input0 = new String[][] {{"the cat", "to hiss", "a kitten", "to meow", "playful", "to purr"}, {"to desert", "the desert", "a dessert"}, {"a a", "the", "the the", "to the"}, {"an", "a a", "b", "c", "d"}, {"a", "an a", "to a", "a b", "b", "to b"}, {"a thef", "the thee", "an theee"}, {"z", "a zoo", "to zoom", "the zoomlion"}, {"zaa", "a boo", "to oppm", "the oppm"}, {"the", "the the", "to the", "an to", "to", "to to"}, {"the abcdefghijklmnopqrstuvwxyz", "an abcdefghijklmnopqrstuvwxyz"}};
		boolean[] expectedOutput = new boolean[] {true, false, true, false, true, false, true, false, true, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = unusualDictionary(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("unusualDictionary(%s) returned %b, but expected %b", Arrays.deepToString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static boolean unusualDictionary(String[] w) {
		for (int i = 0, j = 1; j < w.length; i++, j++) {
			String a = w[i], b = w[j];
			int m = a.indexOf(' '), n = b.indexOf(' ');
			if (m > -1)
				a = a.substring(m+1);
			if (n > -1)
				b = b.substring(n+1);
			int c = a.compareTo(b);
			if (c > 0 || c == 0 && w[i].compareTo(w[j]) > 0)
				return false;
		}
		return true;
	}
}
