main = ->
	input0 = [[3, 5, 4], [2, 2, 2], [9, 15, 6], [3, 4, 4], [4, 3, 5], [3, 7, 5], [13, 12, 5], [4, 14, 11], [8, 17, 15], [9, 15, 20]]
	expectedOutput = [true, false, false, false, true, false, true, false, true, false]
	console.assert input0.length == expectedOutput.length, "# input0 = #{input0.length}, # expectedOutput = #{expectedOutput.length}"
	testsPassed = 0
	i = 0
	while i < expectedOutput.length
		actualOutput = rightTriangle input0[i]
		outputComparison = actualOutput == expectedOutput[i]
		console.assert outputComparison, "rightTriangle(#{JSON.stringify input0[i]}) returned #{JSON.stringify actualOutput}, but expected #{JSON.stringify expectedOutput[i]}"
		if outputComparison
			testsPassed++
		i++
	console.log "PASSES #{testsPassed} out of #{expectedOutput.length} tests"
	return

rightTriangle = (sides) ->
	sides.sort (a, b) ->
		if a > b
			1
		else if b > a
			-1
		else
			0
	sides[2] == Math.sqrt(Math.pow(sides[0], 2) + Math.pow(sides[1], 2))

main()