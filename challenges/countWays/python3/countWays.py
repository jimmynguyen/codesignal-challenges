import math

def countWays(n, k):
	return (math.factorial(n)//math.factorial(k)//math.factorial(abs(n-k)))%(10**9+7)

if __name__ == '__main__':
	input0 = [5, 12, 7, 1000, 7]
	input1 = [2, 5, 5, 500, 10]
	expectedOutput = [10, 792, 21, 159835829, 0]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = countWays(input0[i], input1[i])
		assert actual == expected, 'countWays({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))