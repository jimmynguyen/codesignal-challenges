import java.util.Arrays;
import java.util.stream.IntStream;

public class NewRoadSystem {
	public static void main(String[] args) {
		boolean[][][] input0 = new boolean[][][] {
			{
				{false,true,false,false}, 
				{false,false,true,false}, 
				{true,false,false,true}, 
				{false,false,true,false}
			}, {
				{false,true,false,false,false,false,false}, 
				{true,false,false,false,false,false,false}, 
				{false,false,false,true,false,false,false}, 
				{false,false,true,false,false,false,false}, 
				{false,false,false,false,false,false,true}, 
				{false,false,false,false,true,false,false}, 
				{false,false,false,false,false,true,false}
			}, {
				{false,true,false}, 
				{false,false,false}, 
				{true,false,false}
			}, {
				{false,false,false,false}, 
				{false,false,false,false}, 
				{false,false,false,false}, 
				{false,false,false,false}
			}, {
				{false}
			}, {
				{false,true,true,true,false}, 
				{true,false,true,true,true}, 
				{true,true,false,true,false}, 
				{true,true,true,false,true}, 
				{true,true,true,true,false}
			}, {
				{false,true,true,true,true}, 
				{true,false,true,true,true}, 
				{true,true,false,true,true}, 
				{true,true,true,false,true}, 
				{true,true,true,true,false}
			}, {
				{false,true,false,true,true}, 
				{false,false,false,false,true}, 
				{true,false,false,true,true}, 
				{true,true,true,false,false}, 
				{true,true,true,false,false}
			}, {
				{false,true,true,false,true}, 
				{true,false,false,true,false}, 
				{false,true,false,true,false}, 
				{true,true,true,false,true}, 
				{true,true,false,false,false}
			}, {
				{false,true,false,true,true}, 
				{true,false,true,true,true}, 
				{false,false,false,false,true}, 
				{false,false,true,false,true}, 
				{true,false,true,true,false}
			}, {
				{false,false,false,false,true,true,false,true,false,true}, 
				{false,false,true,false,false,false,true,false,false,true}, 
				{false,false,false,true,false,false,false,true,false,true}, 
				{false,true,false,false,true,false,false,true,false,false}, 
				{false,true,false,true,false,false,false,true,false,false}, 
				{true,true,true,true,true,false,true,false,true,true}, 
				{false,false,true,true,true,true,false,false,false,true}, 
				{true,true,true,false,false,false,false,false,false,false}, 
				{false,false,false,true,false,true,true,true,false,false}, 
				{false,true,true,true,true,false,true,false,true,false}
			}
		};
		boolean[] expectedOutput = new boolean[] {true, true, false, true, true, false, true, false, false, false, false};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = newRoadSystem(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("newRoadSystem(%s) returned %b, but expected %b", Arrays.deepToString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static boolean newRoadSystem(boolean[][] roadRegister) {
		int[] incoming = new int[roadRegister.length];
		int[] outgoing = new int[roadRegister.length];
		for (int i = 0; i < roadRegister.length; i++) {
			for (int j = 0; j < roadRegister[i].length; j++) {
				if (roadRegister[i][j]) {
					incoming[j]++;
					outgoing[i]++;
				}
			}
		}
		for (int i = 0; i < roadRegister.length; i++) {
			if (incoming[i] != outgoing[i]) {
				return false;
			}
		}
		return true;
	}
}
