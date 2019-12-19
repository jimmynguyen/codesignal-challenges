def isInfiniteProcess(a, b):
	while a != b:
		if (a > b):
			return True
		a += 1
		b -= 1
	return False

if __name__ == '__main__':
	input0 = [2, 2, 2, 0, 3, 10, 5, 6, 10, 5]
	input1 = [6, 3, 10, 1, 1, 10, 10, 10, 0, 5]
	expectedOutput = [False, True, False, True, True, False, True, False, True, False]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = isInfiniteProcess(input0[i], input1[i])
		assert actual == expected, 'isInfiniteProcess({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))