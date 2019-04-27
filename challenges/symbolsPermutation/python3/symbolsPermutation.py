def symbolsPermutation(a, b):
	return sorted(a) == sorted(b)

if __name__ == '__main__':
	input0 = ["abc", "aaaa", "sutr", "kscsa", "imazpsni", "ekufzjmk", "seha", "beicgzwj", "nbimwm", "ryqa"]
	input1 = ["cab", "aaa", "cybk", "ncwxt", "kbyafemd", "chhmjxmy", "zims", "pazofnfl", "xwidkg", "ayrq"]
	expectedOutput = [True, False, False, False, False, False, False, False, False, True]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = symbolsPermutation(input0[i], input1[i])
		assert actual == expected, 'symbolsPermutation(\"{}\", \"{}\") returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))