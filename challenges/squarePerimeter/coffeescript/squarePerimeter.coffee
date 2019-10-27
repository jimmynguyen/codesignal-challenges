main = ->
	input0 = [1, 2]
	expectedOutput = [4, 8]
	console.assert input0.length == expectedOutput.length, "# input0 = #{input0.length}, # expectedOutput = #{expectedOutput.length}"
	testsPassed = 0
	i = 0
	while i < expectedOutput.length
		actualOutput = squarePerimeter input0[i]
		outputComparison = actualOutput == expectedOutput[i]
		console.assert outputComparison, "squarePerimeter(#{JSON.stringify input0}) returned #{JSON.stringify actualOutput}, but expected #{JSON.stringify expectedOutput[i]}"
		if outputComparison
			testsPassed++
		i++
	console.log "PASSES #{testsPassed} out of #{expectedOutput.length} tests"
	return

squarePerimeter = (n) ->
	n * 4

main()