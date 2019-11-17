def isUppercase(symbol):
	return symbol >= 'A' and symbol <= 'Z'

if __name__ == '__main__':
	input0 = ["A", "a", "0", "3", "-", "M", "x", "l", ".", "U"]
	expectedOutput = [True, False, False, False, False, True, False, False, False, True]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = isUppercase(input0[i])
		assert actual == expected, 'isUppercase({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))