def killKthBit(n, k):
	return n & ~(1 << k-1)

if __name__ == '__main__':
	input0 = [37, 37, 37, 0, 2147483647, 374823748, 2734827, 1084197039, 1160825071, 2039063284]
	input1 = [3, 4, 2, 4, 16, 13, 4, 15, 3, 4]
	expectedOutput = [33, 37, 37, 0, 2147450879, 374819652, 2734819, 1084197039, 1160825067, 2039063284]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = killKthBit(input0[i], input1[i])
		assert actual == expected, 'killKthBit({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))