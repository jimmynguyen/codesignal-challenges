from math import log2
def differentRightmostBit(n, m):
	return 2**log2((n^m)&-(n^m))

if __name__ == '__main__':
	input0 = [11, 7, 1, 64, 1073741823, 42]
	input1 = [13, 23, 0, 65, 1071513599, 22]
	expectedOutput = [2, 16, 1, 1, 131072, 4]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = differentRightmostBit(input0[i], input1[i])
		assert actual == expected, 'differentRightmostBit({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))