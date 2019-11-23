def seatsInTheater(nCols, nRows, col, row):
	return (nCols - col + 1) * (nRows - row)

if __name__ == '__main__':
	input0 = [16, 1, 13, 60, 1000]
	input1 = [11, 1, 6, 100, 1000]
	input2 = [5, 1, 8, 60, 1000]
	input3 = [3, 1, 3, 1, 1000]
	expectedOutput = [96, 0, 18, 99, 0]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	assert len(input2) == len(expectedOutput), '# input2 = {}, # expectedOutput = {}'.format(len(input2), len(expectedOutput))
	assert len(input3) == len(expectedOutput), '# input3 = {}, # expectedOutput = {}'.format(len(input3), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = seatsInTheater(input0[i], input1[i], input2[i], input3[i])
		assert actual == expected, 'seatsInTheater({}, {}, {}, {}) returned {}, but expected {}'.format(input0[i], input1[i], input2[i], input3[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))