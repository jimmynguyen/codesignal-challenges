object minimalMultiple {
	def main(args: Array[String]): Unit = {
		val input0: Array[Int] = Array(5, 1, 15)
		val input1: Array[Int] = Array(12, 239, 1)
		val expectedOutput: Array[Int] = Array(15, 239, 15);
		assert(input0.length == expectedOutput.length, s"# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}")
		assert(input1.length == expectedOutput.length, s"# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}")
		for (i <- 0 until expectedOutput.length) {
			val actualOutput: Int = minimalMultiple(input0(i), input1(i))
			assert(actualOutput == expectedOutput(i), s"""minimalMultiple(${input0(i)}, ${input1(i)}) returned ${actualOutput}, but expected ${expectedOutput(i)}""")
		}
		println(s"PASSES ${expectedOutput.length} out of ${expectedOutput.length} tests")
	}

	def minimalMultiple(divisor: Int, lowerBound: Int): Int = {
		var i: Int = 0
		while (divisor * i < lowerBound)
			i += 1
		divisor * i
	}
}
