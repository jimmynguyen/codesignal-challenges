def arrayReplace(inputArray, elemToReplace, substitutionElem):
	return [substitutionElem if x == elemToReplace else x for x in inputArray]

if __name__ == '__main__':
	input0 = [[1, 2, 1], [1, 2, 3, 4, 5], [1, 1, 1], [1, 2, 1, 2, 1], [1, 2, 1, 2, 1], [3, 1], [10, 10], [2, 1]]
	input1 = [1, 3, 1, 2, 2, 3, 0, 3]
	input2 = [3, 0, 10, 1, 2, 9, 9, 9]
	expectedOutput = [[3, 2, 3], [1, 2, 0, 4, 5], [10, 10, 10], [1, 1, 1, 1, 1], [1, 2, 1, 2, 1], [9, 1], [10, 10], [2, 1]]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	assert len(input2) == len(expectedOutput), '# input2 = {}, # expectedOutput = {}'.format(len(input2), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = arrayReplace(input0[i], input1[i], input2[i])
		assert actual == expected, 'arrayReplace({}, {}, {}) returned {}, but expected {}'.format(input0[i], input1[i], input2[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))