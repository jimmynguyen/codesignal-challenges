object strangeCode {
	def main(args: Array[String]): Unit = {
		val input0: Array[Int] = Array(4, 10, 10)
		val input1: Array[Int] = Array(8, 15, 16)
		val expectedOutput: Array[String] = Array("ab", "ab", "aba");
		assert(input0.length == expectedOutput.length, s"# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}")
		assert(input1.length == expectedOutput.length, s"# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}")
		for (i <- 0 until expectedOutput.length) {
			val actualOutput: String = strangeCode(input0(i), input1(i))
			assert(actualOutput == expectedOutput(i), s"""strangeCode(${input0(i)}, ${input1(i)}) returned ${actualOutput}, but expected ${expectedOutput(i)}""")
		}
		println(s"PASSES ${expectedOutput.length} out of ${expectedOutput.length} tests")
	}

	def strangeCode(s: Int, e: Int): String = {
		var code: String = ""
		var lastLetter: Char = 'a';
		var a: Int = s
		var b: Int = e
		while (a < b - 1) {
			a += 1
			b -= 1
			if (!code.isEmpty)
				lastLetter = (if (lastLetter == 'a') 'b' else 'a')
			code += lastLetter
		}
		code
	}
}
