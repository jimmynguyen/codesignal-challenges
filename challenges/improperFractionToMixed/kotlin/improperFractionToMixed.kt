fun main(args:Array<String>) {
	val input0 = arrayOf(mutableListOf<Int>(7, 2), mutableListOf<Int>(10, 3))
	val expectedOutput = arrayOf(mutableListOf<Int>(3, 1, 2), mutableListOf<Int>(3, 1, 3))
	assert(input0.size == expectedOutput.size, { "# input0 = ${input0.size}, # expectedOutput = ${expectedOutput.size}" })
	for (i in 0..expectedOutput.size-1) {
		val actualOutput = improperFractionToMixed(input0[i])
		assert(actualOutput == expectedOutput[i], { "specialPolynomial(${input0[i]}) returned ${actualOutput}, but expected ${expectedOutput[i]}" })
	}
	println("PASSES ${expectedOutput.size} out of ${expectedOutput.size} tests")
}

fun improperFractionToMixed(a: MutableList<Int>): MutableList<Int> {
	return mutableListOf<Int>(a[0]/a[1], a[0]%a[1], a[1])
}