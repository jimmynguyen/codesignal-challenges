def depositProfit(deposit, rate, threshold):
	years = 0
	while deposit < threshold:
		deposit *= 1 + rate/100
		years += 1
	return years

if __name__ == '__main__':
	input0 = [100, 100, 1, 20, 50]
	input1 = [20, 1, 100, 20, 25]
	input2 = [170, 101, 64, 50, 100]
	expectedOutput = [3, 1, 6, 6, 4]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	assert len(input2) == len(expectedOutput), '# input2 = {}, # expectedOutput = {}'.format(len(input2), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = depositProfit(input0[i], input1[i], input2[i])
		assert actual == expected, 'depositProfit({}, {}, {}) returned {}, but expected {}'.format(input0[i], input1[i], input2[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))