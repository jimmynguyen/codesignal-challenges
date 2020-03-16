import java.util.Arrays;
import java.util.stream.IntStream;

public class VideoPart {
	public static void main(String[] args) {
		String[] input0 = new String[] {"02:20:00", "25:26:20", "00:02:20", "08:08:08", "00:00:07", "07:32:29", "01:41:59"};
		String[] input1 = new String[] {"07:00:00", "25:26:20", "00:10:00", "20:20:20", "01:10:00", "10:12:51", "02:00:00"};
		int[][] expectedOutput = new int[][] {{1, 3}, {1, 1}, {7, 30}, {2, 5}, {1, 600}, {1597, 2163}, {6119, 7200}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int[] actualOutput = videoPart(input0[i], input1[i]);
			assert Arrays.equals(actualOutput, expectedOutput[i]) : String.format("videoPart(\"%s\", \"%s\") returned %s, but expected %s", input0[i], input1[i], Arrays.toString(actualOutput), Arrays.toString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int[] videoPart(String part, String total) {
		int a = str2time(part);
		int b = str2time(total);
		int c = gcd(b, a);
		return new int[] {a/c, b/c};
	}
	
	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	
	static int str2time(String s) {
		String[] t = s.split(":");
		return Integer.parseInt(t[0])*3600 + Integer.parseInt(t[1])*60 + Integer.parseInt(t[2]);
	}
}
