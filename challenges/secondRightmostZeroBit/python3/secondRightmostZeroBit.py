def secondRightmostZeroBit(n):
	s = '{0:b}'.format(n)
	return 2**[len(s) - i - 1 for i, x in enumerate(s) if x == '0'][-2]

if __name__ == '__main__':
	input0 = [37, 1073741824, 83748, 4, 728782938]
	expectedOutput = [8, 2, 2, 2, 4]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = secondRightmostZeroBit(input0[i])
		assert actual == expected, 'secondRightmostZeroBit({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))