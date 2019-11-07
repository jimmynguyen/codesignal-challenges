def arrayPacking(a):
	m = 0
	for i, n in enumerate(a):
		m |= n << i*8
	return m

if __name__ == '__main__':
	input0 = [[24, 85, 0], [23, 45, 39], [1, 2, 4, 8], [5], [187, 99, 42, 43]]
	expectedOutput = [21784, 2567447, 134480385, 5, 724198331]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = arrayPacking(input0[i])
		assert actual == expected, 'arrayPacking({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))