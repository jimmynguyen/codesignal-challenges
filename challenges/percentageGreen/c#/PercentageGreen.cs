using System;
using System.Diagnostics;

class PercentageGreen {
	static void Main() {
		int[] input0 = new int[] {2, 4};
		int[] input1 = new int[] {5, 5};
		int[] expectedOutput = new int[] {40, 80};
		Assert(input0.Length == expectedOutput.Length, String.Format("# input0 = {0}, # expectedOutput = {1}", input0.Length, expectedOutput.Length));
		Assert(input1.Length == expectedOutput.Length, String.Format("# input1 = {0}, # expectedOutput = {1}", input1.Length, expectedOutput.Length));
		for (int i = 0; i < expectedOutput.Length; i++) {
			int actualOutput = percentageGreen(input0[i], input1[i]);
			Assert(actualOutput == expectedOutput[i], String.Format("percentageGreen({0}, {1}) returned {2}, but expected {3}", input0[i], input1[i], actualOutput, expectedOutput[i]));
		}
		Console.WriteLine(String.Format("PASSES {0} out of {1} tests", expectedOutput.Length, expectedOutput.Length));
	}

	static void Assert(bool assertion, String message) {
		if (!assertion) {
			throw new Exception(message);
		}
	}

	static int percentageGreen(int green, int total) {
		return (int)((double) green / total * 100);
	}
}