def countSumOfTwoRepresentations3(n, l, r):
	return max(0, 1 + n//2 - max(l, n-r))

if __name__ == '__main__':
	input0 = [6, 10, 6, 5, 10, 9, 24, 24]
	input1 = [2, 3, 3, 1, 9, 5, 8, 10]
	input2 = [4, 5, 3, 5, 11, 10, 16, 12]
	expectedOutput = [2, 1, 1, 2, 0, 0, 5, 1]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	assert len(input2) == len(expectedOutput), '# input2 = {}, # expectedOutput = {}'.format(len(input2), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = countSumOfTwoRepresentations3(input0[i], input1[i], input2[i])
		assert actual == expected, 'countSumOfTwoRepresentations3({}, {}, {}) returned {}, but expected {}'.format(input0[i], input1[i], input2[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))