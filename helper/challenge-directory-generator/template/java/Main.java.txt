import java.util.stream.IntStream;

public class [CLASS_NAME] {
	public static void main(String[] args) {
		[TEST_INPUTS]
		[OUTPUT_TYPE][] expectedOutput = new [OUTPUT_TYPE][] {[TEST_OUTPUTS]};
		[NUM_TESTS_ASSERTION]
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			[OUTPUT_TYPE] actualOutput = [METHOD_NAME]([METHOD_ARGS]);
			assert [ACTUAL_EXPECTED_COMPARISON] : String.format("[METHOD_NAME]([METHOD_ARGS_STRING_FORMAT_TEMPLATE]) returned [OUTPUT_TYPE_STRING_FORMAT_TEMPLATE], but expected [OUTPUT_TYPE_STRING_FORMAT_TEMPLATE]", [METHOD_ARGS_STRING_FORMAT_VALUES], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static [OUTPUT_TYPE] [METHOD_NAME]([METHOD_ARGS_DEFINITION]) {
		throw new UnsupportedOperationException();
	}
}
