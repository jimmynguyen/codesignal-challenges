def isDigit(symbol):
	return symbol >= '0' and symbol <= '9'

if __name__ == '__main__':
	input0 = ["0", "-", "O", "1", "2", "!", "@", "+", "6", "(", ")"]
	expectedOutput = [True, False, False, True, True, False, False, False, True, False, False]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = isDigit(input0[i])
		assert actual == expected, 'isDigit({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))