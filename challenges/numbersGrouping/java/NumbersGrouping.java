import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class NumbersGrouping {
	public static void main(String[] args) {
		int[][] input0 = new int[][] {{20000, 239, 10001, 999999, 10000, 20566, 29999}, {10000, 20000, 30000, 40000, 50000, 60000, 10000, 120000, 150000, 200000, 300000, 1000000, 10000000, 100000000, 10000000}, {10000}, {10000, 1}, {685400881, 696804468, 696804942, 803902442, 976412678, 976414920, 47763597, 803900633, 233144924, 47764349, 233149077, 214990733, 214994039, 280528089, 280524347, 685401797}, {598589004, 92986320, 520103781, 808743817, 635098665, 95244159, 808747008, 867017063, 635092226, 867013865, 92989995, 520100093, 95245838, 84897101, 598583113, 84893918}, {1000000000, 999990000, 999980000, 999970000, 999960000, 999950000, 999940000, 999930000, 999920000, 999910000}, {102382103, 21039898, 39823, 433, 30928398, 40283209, 23234, 342534, 98473483, 498398424, 9384984, 9839239}};
		int[] expectedOutput = new int[] {11, 28, 2, 3, 24, 24, 20, 24};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = numbersGrouping(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("numbersGrouping(%s) returned %d, but expected %d", Arrays.toString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int numbersGrouping(int[] a) {
		Set<Integer> s = new HashSet<>();
		int lines = 0;
		for (int x : a) {
			int n = (x-1)/10000;
			if (s.contains(n)) {
				lines++;
			} else {
				s.add(n);
				lines += 2;
			}
		}
		return lines;
	}
}
