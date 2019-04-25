static void main(String[] args) {
	def input0 = [[7, 2], [10, 3]]
	def expectedOutput = [[3, 1, 2], [3, 1, 3]]
	assert input0.size() == expectedOutput.size() : String.format("# input0 = %d, # expectedOutput = %d", input0.size(), expectedOutput.size())
	for (def i = 0; i < expectedOutput.size(); i++) {
		def actualOutput = improperFractionToMixed(input0[i])
		assert actualOutput.equals(expectedOutput[i]) : String.format("improperFractionToMixed(%s) returned %s, but expected %s", input0[i].join(", "), actualOutput.join(", "), expectedOutput[i].join(", "))
	}
	println String.format("PASSES %d out of %d tests", expectedOutput.size(), expectedOutput.size())
}

static List<Integer> improperFractionToMixed(List<Integer> a) {
	return [Math.floor(a.get(0)/a.get(1)), a.get(0)%a.get(1), a.get(1)]
}