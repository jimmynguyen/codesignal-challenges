main = ->
	input0 = [[[1,12,11,10], [4,3,2,9], [5,6,7,8]], [[1,2,-1], [-4,-8,3]], [[0,-1]], [[1,2,1,3], [1,1,1,1], [2,2,2,2]], [[1,-1], [0,0], [2,-1], [3,-10]]]
	input1 = [2, 2, 1, 3, 1]
	input2 = [1, 2, 1, 2, 2]
	expectedOutput = [19, -4, 0, 10, 1]
	console.assert input0.length == expectedOutput.length, "# input0 = #{input0.length}, # expectedOutput = #{expectedOutput.length}"
	console.assert input1.length == expectedOutput.length, "# input1 = #{input1.length}, # expectedOutput = #{expectedOutput.length}"
	console.assert input2.length == expectedOutput.length, "# input2 = #{input2.length}, # expectedOutput = #{expectedOutput.length}"
	testsPassed = 0
	i = 0
	while i < expectedOutput.length
		actualOutput = maxSubmatrixSum input0[i], input1[i], input2[i]
		outputComparison = actualOutput == expectedOutput[i]
		console.assert outputComparison, "maxSubmatrixSum(#{JSON.stringify input0}, #{JSON.stringify input1}, #{JSON.stringify input2}) returned #{JSON.stringify actualOutput}, but expected #{JSON.stringify expectedOutput[i]}"
		if outputComparison
			testsPassed++
		i++
	console.log "PASSES #{testsPassed} out of #{expectedOutput.length} tests"
	return

maxSubmatrixSum = (matrix, n, m) ->
	N = matrix.length
	M = matrix[0].length
	maxSum = Number.NEGATIVE_INFINITY
	for i in [0..N-n]
		for j in [0..M-m]
			currentSum = getSubmatrixSum matrix, n, m, i, j
			if currentSum > maxSum
				maxSum = currentSum
	maxSum

getSubmatrixSum = (matrix, n, m, i, j) ->
	sum = 0
	for r in [i..i+n-1]
		for c in [j..j+m-1]
			sum += matrix[r][c]
	sum

main()