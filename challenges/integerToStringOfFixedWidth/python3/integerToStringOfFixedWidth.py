def integerToStringOfFixedWidth(number, width):
	s = str(number)
	n = len(s)
	return s[n-width:] if n > width else '0'*(width-n) + s

if __name__ == '__main__':
	input0 = [1234, 1234, 1234, 0, 89, 23456, 899]
	input1 = [2, 4, 5, 1, 4, 4, 3]
	expectedOutput = ["34", "1234", "01234", "0", "0089", "3456", "899"]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = integerToStringOfFixedWidth(input0[i], input1[i])
		assert actual == expected, 'integerToStringOfFixedWidth({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))