import java.util.stream.IntStream;

public class CubeVolume {
	public static void main(String[] args) {
		int[] input0 = new int[] {5, 1};
		int[] expectedOutput = new int[] {125, 1};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = cubeVolume(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("cubeVolume(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int cubeVolume(int n) {
		return (int)Math.pow(n, 3);
	}
}
