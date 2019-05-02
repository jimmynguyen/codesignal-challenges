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