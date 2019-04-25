fun main(args:Array<String>) {
	val input0 = intArrayOf(2, 10, 1, 3)
	val input1 = intArrayOf(5, 111111110, 100, 140)
	val expectedOutput = intArrayOf(1, 7, 99, 4)
	assert(input0.size == expectedOutput.size, { "# input0 = ${input0.size}, # expectedOutput = ${expectedOutput.size}" })
	assert(input1.size == expectedOutput.size, { "# input1 = ${input1.size}, # expectedOutput = ${expectedOutput.size}" })
	for (i in 0..expectedOutput.size-1) {
		val actualOutput = specialPolynomial(input0[i], input1[i])
		assert(actualOutput == expectedOutput[i], { "specialPolynomial(${input0[i]}, ${input1[i]}) returned ${actualOutput}, but expected ${expectedOutput[i]}" })
	}
	println("PASSES ${expectedOutput.size} out of ${expectedOutput.size} tests")
}

fun specialPolynomial(x: Int, n: Int): Int {
	var s: Int = 1
	var k: Int = 0
	while (s <= n) s += Math.pow(x.toDouble(), (++k).toDouble()).toInt()
	return k - 1
}