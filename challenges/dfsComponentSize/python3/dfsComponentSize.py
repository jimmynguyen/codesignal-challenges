def dfsComponentSize(matrix, vertex):
	stack = [vertex]
	component = []
	while stack:
		v = stack.pop()
		if v not in component:
			component.append(v)
			for w, connected in enumerate(matrix[v]):
				if connected:
					stack.append(w)
	return len(component)

if __name__ == '__main__':
	input0 = [[[False,True,False], [True,False,False], [False,False,False]], [[False,True,False,True], [True,False,False,False], [False,False,False,False], [True,False,False,False]], [[False,False,False], [False,False,False], [False,False,False]], [[False,True,False], [True,False,False], [False,False,False]], [[False,True,False,True], [True,False,True,False], [False,True,False,True], [True,False,True,False]]]
	input1 = [0, 1, 0, 2, 2]
	expectedOutput = [2, 3, 1, 1, 4]
	assert len(input0) == len(expectedOutput), '# input0 = {}, # expectedOutput = {}'.format(len(input0), len(expectedOutput))
	assert len(input1) == len(expectedOutput), '# input1 = {}, # expectedOutput = {}'.format(len(input1), len(expectedOutput))
	for i, expected in enumerate(expectedOutput):
		actual = dfsComponentSize(input0[i], input1[i])
		assert actual == expected, 'dfsComponentSize({}, {}) returned {}, but expected {}'.format(input0[i], input1[i], actual, expected)
	print('PASSES {} out of {} tests'.format(len(expectedOutput), len(expectedOutput)))