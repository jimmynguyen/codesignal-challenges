using System;
using System.Diagnostics;

class PagesNumberingWithInk {
	static void Main() {
		int[] input0 = new int[] {1, 21, 8, 21, 10, 76, 80};
		int[] input1 = new int[] {5, 5, 4, 6, 3, 250, 1000};
		int[] expectedOutput = new int[] {5, 22, 10, 23, 10, 166, 419};
		Assert(input0.Length == expectedOutput.Length, String.Format("# input0 = {0}, # expectedOutput = {1}", input0.Length, expectedOutput.Length));
		Assert(input1.Length == expectedOutput.Length, String.Format("# input1 = {0}, # expectedOutput = {1}", input1.Length, expectedOutput.Length));
		for (int i = 0; i < expectedOutput.Length; i++) {
			int actualOutput = pagesNumberingWithInk(input0[i], input1[i]);
			Assert(actualOutput == expectedOutput[i], String.Format("pagesNumberingWithInk({0}, {1}) returned {2}, but expected {3}", input0[i], input1[i], actualOutput, expectedOutput[i]));
		}
		Console.WriteLine(String.Format("PASSES {0} out of {1} tests", expectedOutput.Length, expectedOutput.Length));
	}

	static void Assert(bool assertion, String message) {
		if (!assertion) {
			throw new Exception(message);
		}
	}

	static int pagesNumberingWithInk(int current, int numberOfDigits) {
		int currentNumberOfDigits = current.ToString().Length;
		while (numberOfDigits >= currentNumberOfDigits) {
			numberOfDigits -= currentNumberOfDigits;
			currentNumberOfDigits = (++current).ToString().Length;
		}
		return current-1;
	}
}