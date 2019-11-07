def swapAdjacentBits(n):
	return ((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1)

if __name__ == '__main__':
	input0 = [13, 74, 1073741823, 0, 1, 83748]
	expectedOutput = [14, 133, 1073741823, 0, 2, 166680]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = swapAdjacentBits(input0[i])
		assert actual == expected, 'swapAdjacentBits({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))