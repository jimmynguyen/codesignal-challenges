import math

def improperFractionToMixed(a):
	return [math.floor(a[0]/a[1]), a[0]%a[1], a[1]]

if __name__ == '__main__':
	input0 = [[7, 2], [10, 3]]
	expectedOutput = [[3, 1, 2], [3, 1, 3]]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = improperFractionToMixed(input0[i])
		assert actual == expected, 'improperFractionToMixed({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))