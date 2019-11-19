def crossingSum(matrix, a, b):
	return sum(matrix[a]) + sum([x[b] for i, x in enumerate(matrix) if i != a])

if __name__ == '__main__':
	input0 = [[[1,1,1,1], [2,2,2,2], [3,3,3,3]], [[1,1], [1,1]], [[1,1], [3,3], [1,1], [2,2]], [[100]], [[1,2], [3,4]], [[1,2,3,4]], [[1,2,3,4,5], [1,2,2,2,2], [1,2,2,2,2], [1,2,2,2,2], [1,2,2,2,2], [1,2,2,2,2], [1,2,2,2,2]]]
	input1 = [1, 0, 3, 0, 1, 0, 1]
	input2 = [3, 0, 0, 0, 1, 3, 1]
	expectedOutput = [12, 3, 9, 100, 9, 10, 21]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	assert len(input2) == len(expectedOutput), '# input2 = {}, # expectedOutput = {}'.format(len(input2), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = crossingSum(input0[i], input1[i], input2[i])
		assert actual == expected, 'crossingSum({}, {}, {}) returned {}, but expected {}'.format(input0[i], input1[i], input2[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))