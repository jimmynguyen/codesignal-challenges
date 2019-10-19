object reflectString {
	def main(args: Array[String]): Unit = {
		val input0: Array[String] = Array("name", "abyz", "nnnnn", "pqr", "codesignal")
		val expectedOutput: Array[String] = Array("mznv", "zyba", "mmmmm", "kji", "xlwvhrtmzo")
		assert(input0.length == expectedOutput.length, s"# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}")
		for (i <- 0 until expectedOutput.length) {
			val actualOutput: String = reflectString(input0(i))
			assert(actualOutput == expectedOutput(i), s"""reflectString("${input0(i)}") returned ${actualOutput}, but expected ${expectedOutput(i)}""")
		}
		println(s"PASSES ${expectedOutput.length} out of ${expectedOutput.length} tests")
	}

	def reflectString(s: String): String = {
		val alphabet: String = "abcdefghijklmnopqrstuvwxyz"
		s.map(c => alphabet.reverse(alphabet.indexOf(c)))
	}
}
