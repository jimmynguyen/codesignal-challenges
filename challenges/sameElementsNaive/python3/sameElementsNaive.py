def sameElementsNaive(a, b):
	return len([x for x in a for y in b if x == y])

if __name__ == '__main__':
	input0 = [[1, 2, 3], [1], [1, 2, 3]]
	input1 = [[3, 4, 5], [2, 3, 4, 1], [2, 3, 4]]
	expectedOutput = [1, 1, 2]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = sameElementsNaive(input0[i], input1[i])
		assert actual == expected, 'sameElementsNaive({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))