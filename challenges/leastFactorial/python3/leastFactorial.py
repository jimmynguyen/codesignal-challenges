def leastFactorial(n):
	m = 1
	k = 1
	while k < n:
		m += 1
		k *= m
	return k

if __name__ == '__main__':
	input0 = [17, 1, 5, 25, 18, 109, 106, 11, 55, 24]
	expectedOutput = [24, 1, 6, 120, 24, 120, 120, 24, 120, 24]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = leastFactorial(input0[i])
		assert actual == expected, 'leastFactorial({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))