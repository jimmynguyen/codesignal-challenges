import java.util.Arrays;
import java.util.stream.IntStream;

public class VisitsOnCircularRoad {
	public static void main(String[] args) {
		int[] input0 = new int[] {4, 3};
		int[][] input1 = new int[][] {{1, 3, 2, 3, 1}, {3}};
		int[] expectedOutput = new int[] {6, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = visitsOnCircularRoad(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("visitsOnCircularRoad(%d, %s) returned %d, but expected %d", input0[i], Arrays.toString(input1[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int visitsOnCircularRoad(int n, int[] visitsOrder) {
		int t = 0;
		int currentLocation = 1;
		for (int i = 0; i < visitsOrder.length; i++) {
			if (visitsOrder[i] > currentLocation) {
				t += (int) Math.min(visitsOrder[i] - currentLocation, n - visitsOrder[i] + currentLocation);
			} else {
				t += (int) Math.min(currentLocation - visitsOrder[i], n - currentLocation + visitsOrder[i]);
			}
			currentLocation = visitsOrder[i];
		}
		return t;
	}
}
