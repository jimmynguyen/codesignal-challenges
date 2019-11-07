def metroCard(lastNumberOfDays):
	return [31] if lastNumberOfDays < 31 else [28, 30, 31]

if __name__ == '__main__':
	input0 = [30, 31]
	expectedOutput = [[31], [28, 30, 31]]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = metroCard(input0[i])
		assert actual == expected, 'metroCard({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))