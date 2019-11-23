def leapYear(year):
	return year % 4 == 0 and year % 100 != 0 or year % 400 == 0

if __name__ == '__main__':
	input0 = [2000, 1993, 1000, 0, 100, 200, 42, 1200, 123, 124]
	expectedOutput = [True, False, False, True, False, False, False, True, False, True]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = leapYear(input0[i])
		assert actual == expected, 'leapYear({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))