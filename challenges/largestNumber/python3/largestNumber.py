def largestNumber(n):
	return int('9'*n)

if __name__ == '__main__':
	input0 = [2, 1, 7, 4, 3]
	expectedOutput = [99, 9, 9999999, 9999, 999]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = largestNumber(input0[i])
		assert actual == expected, 'largestNumber({}) returned {}, but expected {}'.format(input0[i], actual, expected)