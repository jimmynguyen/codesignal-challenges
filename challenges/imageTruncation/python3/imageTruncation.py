def imageTruncation(image, threshold):
	return [[y if y < threshold else threshold for y in x] for x in image]

if __name__ == '__main__':
	input0 = [[[0,100,100], [1,255,103]], [[0,100,100], [1,255,103]], [[1], [2]]]
	input1 = [102, 0, 1]
	expectedOutput = [[[0,100,100], [1,102,102]], [[0,0,0], [0,0,0]], [[1], [1]]]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = imageTruncation(input0[i], input1[i])
		assert actual == expected, 'imageTruncation({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))