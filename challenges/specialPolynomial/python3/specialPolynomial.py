def specialPolynomial(x, n):
	s = 1
	k = 0
	while s <= n:
		k += 1
		s += x**k
	return k-1

if __name__ == '__main__':
	input0 = [2, 10, 1, 3]
	input1 = [5, 111111110, 100, 140]
	expectedOutput = [1, 7, 99, 4]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = specialPolynomial(input0[i], input1[i])
		assert actual == expected, 'specialPolynomial({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))