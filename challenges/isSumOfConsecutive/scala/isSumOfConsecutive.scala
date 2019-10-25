object isSumOfConsecutive {
	def main(args: Array[String]): Unit = {
		val input0: Array[Int] = Array(9, 8, 1, 42, 110, 45, 128, 55, 400, 256)
		val expectedOutput: Array[Boolean] = Array(true, false, false, true, true, true, false, true, true, false)
		assert(input0.length == expectedOutput.length, s"# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}")
		for (i <- 0 until expectedOutput.length) {
			val actualOutput: Boolean = isSumOfConsecutive(input0(i))
			assert(actualOutput == expectedOutput(i), s"""isSumOfConsecutive(${input0(i)}) returned ${actualOutput}, but expected ${expectedOutput(i)}""")
		}
		println(s"PASSES ${expectedOutput.length} out of ${expectedOutput.length} tests")
	}

	def isSumOfConsecutive(n: Int): Boolean = {
		val m: Int = math.ceil(n/2.0).toInt
		for (i <- 0 to m) {
			var k: Int = 0
			var j: Int = i;
			while (j < m && k < n) {
				k += j
				if (k == n)
					return true
				j += 1
			}
		}
		false
	}
}
