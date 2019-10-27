main = ->
	input0 = [6, 12, 20, 1, 1, 2, 10, 239, 239, 239]
	input1 = [2, 5, 4, 2, 1000, 2, 3, 2, 3, 4]
	expectedOutput = [4, 2, 6, 0, 0, 1, 4, 232, 115, 76]
	console.assert input0.length == expectedOutput.length, "# input0 = #{input0.length}, # expectedOutput = #{expectedOutput.length}"
	console.assert input1.length == expectedOutput.length, "# input1 = #{input1.length}, # expectedOutput = #{expectedOutput.length}"
	testsPassed = 0
	i = 0
	while i < expectedOutput.length
		actualOutput = sumOfPowers input0[i], input1[i]
		outputComparison = actualOutput == expectedOutput[i]
		console.assert outputComparison, "sumOfPowers(#{JSON.stringify input0}, #{JSON.stringify input1}) returned #{JSON.stringify actualOutput}, but expected #{JSON.stringify expectedOutput[i]}"
		if outputComparison
			testsPassed++
		i++
	console.log "PASSES #{testsPassed} out of #{expectedOutput.length} tests"
	return

sumOfPowers = (n, divisor) ->
	s = 0
	for i in [1..n]
		p = i
		while (i%Math.pow divisor, p) > 0
			p--
		s += p
	s

main()