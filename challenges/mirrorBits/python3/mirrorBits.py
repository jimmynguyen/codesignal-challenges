def mirrorBits(a):
	return int('{0:b}'.format(a)[::-1], 2)

if __name__ == '__main__':
	input0 = [97, 8, 123, 86782, 5]
	expectedOutput = [67, 1, 111, 65173, 5]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = mirrorBits(input0[i])
		assert actual == expected, 'mirrorBits({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))