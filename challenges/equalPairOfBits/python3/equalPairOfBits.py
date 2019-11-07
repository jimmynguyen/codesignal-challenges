from math import log2
def equalPairOfBits(n, m):
	return 2**log2((n&m|~n&~m)&-(n&m|~n&~m))

if __name__ == '__main__':
	input0 = [10, 0, 28, 895, 1073741824]
	input1 = [11, 0, 27, 928, 1006895103]
	expectedOutput = [2, 1, 8, 32, 262144]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = equalPairOfBits(input0[i], input1[i])
		assert actual == expected, 'equalPairOfBits({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))