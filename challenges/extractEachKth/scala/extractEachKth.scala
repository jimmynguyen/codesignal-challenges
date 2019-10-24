object extractEachKth {
	def main(args: Array[String]): Unit = {
		val input0: Array[Array[Int]] = Array(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), Array(1, 1, 1, 1, 1), Array(1, 2, 1, 2, 1, 2, 1, 2), Array(1, 2, 1, 2, 1, 2, 1, 2), Array(2, 4, 6, 8, 10))
		val input1: Array[Int] = Array(3, 1, 2, 10, 2)
		val expectedOutput: Array[Array[Int]] = Array(Array(1, 2, 4, 5, 7, 8, 10), Array(), Array(1, 1, 1, 1), Array(1, 2, 1, 2, 1, 2, 1, 2), Array(2, 6, 10))
		assert(input0.length == expectedOutput.length, s"# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}")
		assert(input1.length == expectedOutput.length, s"# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}")
		for (i <- 0 until expectedOutput.length) {
			val actualOutput: Array[Int] = extractEachKth(input0(i), input1(i))
			assert(actualOutput sameElements expectedOutput(i), s"""extractEachKth(${input0(i).mkString("[", ", ", "]")}, ${input1(i)}) returned ${actualOutput.mkString("[", ", ", "]")}, but expected ${expectedOutput(i).mkString("[", ", ", "]")}""")
		}
		println(s"PASSES ${expectedOutput.length} out of ${expectedOutput.length} tests")
	}

	def extractEachKth(inputArray: Array[Int], k: Int): Array[Int] = {
		Range(0, inputArray.length).filter(i => (i+1)%k != 0).map(i => inputArray(i)).toArray
	}
}
