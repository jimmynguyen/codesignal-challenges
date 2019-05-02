main = ->
	input0 = [1, 21, 8, 21, 10, 76, 80]
	input1 = [5, 5, 4, 6, 3, 250, 1000]
	expectedOutput = [5, 22, 10, 23, 10, 166, 419]
	console.assert input0.length == expectedOutput.length, "# input0 = #{input0.length}, # expectedOutput = #{expectedOutput.length}"
	console.assert input1.length == expectedOutput.length, "# input1 = #{input1.length}, # expectedOutput = #{expectedOutput.length}"
	testsPassed = 0
	i = 0
	while i < expectedOutput.length
		actualOutput = pagesNumberingWithInk input0[i], input1[i]
		outputComparison = actualOutput == expectedOutput[i]
		console.assert outputComparison, "pagesNumberingWithInk(#{input0}, #{input1}) returned #{actualOutput}, but expected #{expectedOutput[i]}"
		if outputComparison
			testsPassed++
		i++
	console.log "PASSES #{testsPassed} out of #{expectedOutput.length} tests"
	return

pagesNumberingWithInk = (current, numberOfDigits) ->
	currentNumberOfDigits = "#{current}".length
	while numberOfDigits >= currentNumberOfDigits
		numberOfDigits -= currentNumberOfDigits
		currentNumberOfDigits = "#{++current}".length
	current-1

main()