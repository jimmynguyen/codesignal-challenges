using System;
using System.Diagnostics;
using System.Linq;

class ImproperFractionToMixed {
	static void Main() {
		int[][] input0 = new int[][] {new int[] {7, 2}, new int[] {10, 3}, new int[] {23, 22}, new int[] {7, 3}, new int[] {8, 5}, new int[] {15, 4}, new int[] {18, 7}};
		int[][] expectedOutput = new int[][] {new int[] {3, 1, 2}, new int[] {3, 1, 3}, new int[] {1, 1, 22}, new int[] {2, 1, 3}, new int[] {1, 3, 5}, new int[] {3, 3, 4}, new int[] {2, 4, 7}};
		Assert(input0.Length == expectedOutput.Length, String.Format("# input0 = {0}, # expectedOutput = {1}", input0.Length, expectedOutput.Length));
		for (int i = 0; i < expectedOutput.Length; i++) {
			int[] actualOutput = improperFractionToMixed(input0[i]);
			Assert(actualOutput.SequenceEqual(expectedOutput[i]), String.Format("improperFractionToMixed({0}) returned {1}, but expected {2}", String.Format("[{0}]", String.Join(", ", input0[i])), String.Format("[{0}]", String.Join(", ", actualOutput)), String.Format("[{0}]", String.Join(", ", expectedOutput[i]))));
		}
		Console.WriteLine(String.Format("PASSES {0} out of {1} tests", expectedOutput.Length, expectedOutput.Length));
	}

	static void Assert(bool assertion, String message) {
		if (!assertion) {
			throw new Exception(message);
		}
	}

	static int[] improperFractionToMixed(int[] a) {
		return new int[] {(int)Math.Floor((double)a[0]/a[1]), a[0]%a[1], a[1]};
	}
}