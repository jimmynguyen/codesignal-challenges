def houseNumbersSum(a):
	s = 0
	for x in a:
		if x == 0:
			break
		else:
			s += x
	return s

if __name__ == '__main__':
	input0 = [[5, 1, 2, 3, 0, 1, 5, 0, 2], [4, 2, 1, 6, 0], [4, 1, 2, 3, 0, 10, 2], [0, 1, 2, 3, 0], [5, 1, 1, 3, 0, 1, 5, 0, 2], [10, 10, 10, 10, 10, 10, 10, 10, 10, 0], [10, 10, 10, 10, 10, 10, 10, 10, 0, 10]]
	expectedOutput = [11, 13, 10, 0, 10, 90, 80]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = houseNumbersSum(input0[i])
		assert actual == expected, 'houseNumbersSum({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))