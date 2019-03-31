def exerciseElaboration(p, n):
	return sum(map(int, list(str(int(str(p)+'0'*n+str(p))**2))))

if __name__ == '__main__':
	input0 = [5, 9, 1, 2, 1, 3, 9, 4, 6, 5]
	input1 = [1, 0, 2, 1, 0, 0, 2, 3, 2, 0]
	expectedOutput = [19, 18, 4, 16, 4, 18, 27, 19, 27, 10]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = exerciseElaboration(input0[i], input1[i])
		assert actual == expected, 'exerciseElaboration({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)