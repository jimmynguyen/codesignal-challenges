object sumOfCubes {
	def main(args: Array[String]): Unit = {
		val input0: Array[Int] = Array(3, 1)
		val expectedOutput: Array[Int] = Array(36, 1)
		assert(input0.length == expectedOutput.length, s"# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}")
		for (i <- 0 until expectedOutput.length) {
			val actualOutput: Int = sumOfCubes(input0(i))
			assert(actualOutput == expectedOutput(i), s"""sumOfCubes("${input0(i)}") returned ${actualOutput}, but expected ${expectedOutput(i)}""")
		}
		println(s"PASSES ${expectedOutput.length} out of ${expectedOutput.length} tests")
	}

	def sumOfCubes(n: Int): Int = {
		Range(0, n+1).map(i => Math.pow(i, 3)).toList.sum.toInt
	}
}
