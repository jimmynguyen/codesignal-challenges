main = ->
	input0 = [2, 4]
	input1 = [5, 5]
	expectedOutput = [40, 80]
	console.assert input0.length == expectedOutput.length, "# input0 = #{input0.length}, # expectedOutput = #{expectedOutput.length}"
	console.assert input1.length == expectedOutput.length, "# input1 = #{input1.length}, # expectedOutput = #{expectedOutput.length}"
	testsPassed = 0
	i = 0
	while i < expectedOutput.length
		actualOutput = percentageGreen input0[i], input1[i]
		outputComparison = actualOutput == expectedOutput[i]
		console.assert outputComparison, "percentageGreen(#{JSON.stringify input0}, #{JSON.stringify input1}) returned #{JSON.stringify actualOutput}, but expected #{JSON.stringify expectedOutput[i]}"
		if outputComparison
			testsPassed++
		i++
	console.log "PASSES #{testsPassed} out of #{expectedOutput.length} tests"
	return

percentageGreen = (green, total) ->
	green / total * 100

main()