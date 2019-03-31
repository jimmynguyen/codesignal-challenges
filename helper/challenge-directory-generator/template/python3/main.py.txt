def [METHOD_NAME]([METHOD_ARGS_DEFINITION]):
	raise NotImplementedError()

if __name__ == '__main__':
	[TEST_INPUTS]
	expectedOutput = [[TEST_OUTPUTS]]
	[NUM_TESTS_ASSERTION]
	for i, expected in enumerate(expectedOutput):
		actual = [METHOD_NAME]([METHOD_ARGS])
		assert actual == expected, '[METHOD_NAME]([METHOD_ARGS_STRING_FORMAT_TEMPLATE]) returned {}, but expected {}'.format([METHOD_ARGS_STRING_FORMAT_VALUES], actual, expected)