main = ->
	input0 = [[1, 2, 3, 4, 5], [], [239], [23, 54, 12, 3, 4, 56, 23, 12, 5, 324], [-1, 1], [88, -101, -310, 818, 747, -888, -183, -687, -723, 188, -611, 677, -597, 293, -295, -162, -265, 368, 346, 81, -831, 198, -94, 685, -434, -241, -566, -397, 501, -183, 366, -669, 96, -592, 358, 598, 444, -929, 769, -361, -754, 218, -464, 332, 893, 422, -192, -287, -850, 543]]
	expectedOutput = [[5, 2, 3, 4, 1], [], [239], [324, 54, 12, 3, 4, 56, 23, 12, 5, 23], [1, -1], [543, -101, -310, 818, 747, -888, -183, -687, -723, 188, -611, 677, -597, 293, -295, -162, -265, 368, 346, 81, -831, 198, -94, 685, -434, -241, -566, -397, 501, -183, 366, -669, 96, -592, 358, 598, 444, -929, 769, -361, -754, 218, -464, 332, 893, 422, -192, -287, -850, 88]]
	console.assert input0.length == expectedOutput.length, "# input0 = #{input0.length}, # expectedOutput = #{expectedOutput.length}"
	testsPassed = 0
	i = 0
	while i < expectedOutput.length
		actualOutput = firstReverseTry input0[i]
		outputComparison = arraysEqual(actualOutput, expectedOutput[i])
		console.assert outputComparison, "firstReverseTry(#{JSON.stringify input0}) returned #{JSON.stringify actualOutput}, but expected #{JSON.stringify expectedOutput[i]}"
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

firstReverseTry = (arr) ->
	n = arr.length - 1;
	if n > -1
		x = arr[0]
		arr[0] = arr[n]
		arr[n] = x
	arr

main()