main = ->
	input0 = [
		[
			7
			2
		]
		[
			10
			3
		]
	]
	expectedOutput = [
		[
			3
			1
			2
		]
		[
			3
			1
			3
		]
	]
	console.assert input0.length == expectedOutput.length, "# input0 = #{input0.length}, # expectedOutput = #{expectedOutput.length}"
	testsPassed = 0
	i = 0
	while i < expectedOutput.length
		actualOutput = improperFractionToMixed(input0[i])
		outputComparison = arraysEqual(actualOutput, expectedOutput[i])
		console.assert outputComparison, "improperFractionToMixed() returned #{actualOutput}, but expected #{expectedOutput[i]}"
		if outputComparison
			testsPassed++
		i++
	console.log "PASSES #{testsPassed} out of #{expectedOutput.length} tests"
	return

# https://stackoverflow.com/questions/3115982/how-to-check-if-two-arrays-are-equal-with-javascript
arraysEqual = (a, b) ->
	if a == b
		return true
	if a == null or b == null
		return false
	if a.length != b.length
		return false
	i = 0
	while i < a.length
		if a[i] != b[i]
			return false
		++i
	true

improperFractionToMixed = (a) ->
	[
		Math.floor(a[0] / a[1])
		a[0] % a[1]
		a[1]
	]

main()