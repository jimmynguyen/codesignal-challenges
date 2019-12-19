def add(param1, param2):
	return param1 + param2

if __name__ == '__main__':
	input0 = [1, 0, 2, 99, -100, -1000]
	input1 = [2, 1000, -39, 100, 100, -1000]
	expectedOutput = [3, 1000, -37, 199, 0, -2000]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = add(input0[i], input1[i])
		assert actual == expected, 'add({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))