def magicalWell(a, b, n):
	s = 0
	while n > 0:
		n -= 1
		s += a*b
		a += 1
		b += 1
	return s

if __name__ == '__main__':
	input0 = [1, 1, 6, 1601, 1891, 1936, 957, 687, 491, 1275]
	input1 = [2, 1, 5, 337, 352, 1835, 57, 1337, 1552, 362]
	input2 = [2, 1, 3, 0, 0, 5, 2, 0, 4, 2]
	expectedOutput = [8, 1, 128, 0, 0, 17800540, 110113, 0, 3060400, 924738]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	assert len(input2) == len(expectedOutput), '# input2 = {}, # expectedOutput = {}'.format(len(input2), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = magicalWell(input0[i], input1[i], input2[i])
		assert actual == expected, 'magicalWell({}, {}, {}) returned {}, but expected {}'.format(input0[i], input1[i], input2[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))