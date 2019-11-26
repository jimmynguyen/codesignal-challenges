def isSum(value):
	i = 1
	while value > 0:
		value -= i
		i += 1
	return value == 0

if __name__ == '__main__':
	input0 = [10, 11, 100, 42, 110, 45, 82, 55, 400, 321]
	expectedOutput = [True, False, False, False, False, True, False, True, False, False]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = isSum(input0[i])
		assert actual == expected, 'isSum({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))