def isSuspiciousRespondent(ans1, ans2, ans3):
	return ans1 == ans2 and ans1 == ans3

if __name__ == '__main__':
	input0 = [False, True, True, True, False]
	input1 = [False, True, False, True, True]
	input2 = [False, False, False, True, False]
	expectedOutput = [True, False, False, True, False]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	assert len(input2) == len(expectedOutput), '# input2 = {}, # expectedOutput = {}'.format(len(input2), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = isSuspiciousRespondent(input0[i], input1[i], input2[i])
		assert actual == expected, 'isSuspiciousRespondent({}, {}, {}) returned {}, but expected {}'.format(input0[i], input1[i], input2[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))