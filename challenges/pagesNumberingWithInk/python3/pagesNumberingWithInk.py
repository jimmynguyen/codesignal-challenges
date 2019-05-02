def pagesNumberingWithInk(current, numberOfDigits):
	currentNumberOfDigits = len(str(current))
	while numberOfDigits >= currentNumberOfDigits:
		numberOfDigits -= currentNumberOfDigits
		current += 1
		currentNumberOfDigits = len(str(current))
	return current-1

if __name__ == '__main__':
	input0 = [1, 21, 8, 21, 76, 80]
	input1 = [5, 5, 4, 6, 250, 1000]
	expectedOutput = [5, 22, 10, 23, 166, 419]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = pagesNumberingWithInk(input0[i], input1[i])
		assert actual == expected, 'pagesNumberingWithInk({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))