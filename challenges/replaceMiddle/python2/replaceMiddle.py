def replaceMiddle(arr):
	L = len(arr)
	M = int(L/2)
	return arr[0:M-1] + [sum(arr[M-1:M+1])] + arr[M+1:] if L%2==0 else arr

if __name__ == '__main__':
	input0 = [[7, 2, 2, 5, 10, 7], [-5, -5, 10], [45, 23, 12, 33, 12, 453, -234, -45], [2, 8], [-12, 34, 40, -5, -12, 4, 0, 0, -12], [9, 0, 15, 9], [-6, 6, -6], [26, 26, -17], [-7, 5, 5, 10]]
	expectedOutput = [[7, 2, 7, 10, 7], [-5, -5, 10], [45, 23, 12, 45, 453, -234, -45], [10], [-12, 34, 40, -5, -12, 4, 0, 0, -12], [9, 15, 9], [-6, 6, -6], [26, 26, -17], [-7, 10, 10]]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = replaceMiddle(input0[i])
		assert actual == expected, 'replaceMiddle({}) returned {}, but expected {}'.format(input0[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))