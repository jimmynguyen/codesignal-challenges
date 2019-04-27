main = ->
	input0 = [
		"abc"
		"aaaa"
		"sutr"
		"kscsa"
		"imazpsni"
		"ekufzjmk"
		"seha"
		"beicgzwj"
		"nbimwm"
		"ryqa"
	]
	input1 = [
		"cab"
		"aaa"
		"cybk"
		"ncwxt"
		"kbyafemd"
		"chhmjxmy"
		"zims"
		"pazofnfl"
		"xwidkg"
		"ayrq"
	]
	expectedOutput = [
		true
		false
		false
		false
		false
		false
		false
		false
		false
		true
	]
	console.assert input0.length == expectedOutput.length, "# input0 = #{input0.length}, # expectedOutput = #{expectedOutput.length}"
	console.assert input1.length == expectedOutput.length, "# input1 = #{input1.length}, # expectedOutput = #{expectedOutput.length}"
	testsPassed = 0
	i = 0
	while i < expectedOutput.length
		actualOutput = symbolsPermutation(input0[i], input1[i])
		outputComparison = actualOutput == expectedOutput[i];
		console.assert outputComparison, "symbolsPermutation(\"#{input0[i]}\", \"#{input1[i]}\") returned #{actualOutput}, but expected #{expectedOutput[i]}"
		if outputComparison
			testsPassed++
		i++
	console.log "PASSES #{testsPassed} out of #{expectedOutput.length} tests"
	return

symbolsPermutation = (word1, word2) ->
	word1.split("").sort().join("")  == word2.split("").sort().join("")

main()