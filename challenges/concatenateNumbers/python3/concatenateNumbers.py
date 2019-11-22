def concatenateNumbers(a, b):
	return int(str(a) + str(b))

if __name__ == '__main__':
	input0 = [23, 962]
	input1 = [45, 12345]
	expectedOutput = [2345, 96212345]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = concatenateNumbers(input0[i], input1[i])
		assert actual == expected, 'concatenateNumbers({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))