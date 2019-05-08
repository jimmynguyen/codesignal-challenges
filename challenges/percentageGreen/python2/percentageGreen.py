def percentageGreen(green, total):
	return float(green) / total * 100

if __name__ == '__main__':
	input0 = [2, 4]
	input1 = [5, 5]
	expectedOutput = [40, 80]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = percentageGreen(input0[i], input1[i])
		assert actual == expected, 'percentageGreen({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))