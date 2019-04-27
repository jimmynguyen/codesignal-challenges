function main(): void {
	const input0: string[] = ["abc", "aaaa", "sutr", "kscsa", "imazpsni", "ekufzjmk", "seha", "beicgzwj", "nbimwm", "ryqa"];
	const input1: string[] = ["cab", "aaa", "cybk", "ncwxt", "kbyafemd", "chhmjxmy", "zims", "pazofnfl", "xwidkg", "ayrq"];
	const expectedOutput: boolean[] = [true, false, false, false, false, false, false, false, false, true];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i: number = 0; i < expectedOutput.length; i++) {
		let actualOutput: boolean = symbolsPermutation(input0[i], input1[i]);
		let outputComparison = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `symbolsPermutation("${input0[i]}", "${input1[i]}") returned ${actualOutput}, but expected ${expectedOutput[i]}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function symbolsPermutation(word1: string, word2: string): boolean {
	return word1.split('').sort().join('') == word2.split('').sort().join('');
}

main();