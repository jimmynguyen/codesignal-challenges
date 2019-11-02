function main() {
	const input0 = [1905, 1700, 1988, 2000, 2001, 200, 374, 45, 8];
	const expectedOutput = [20, 17, 20, 20, 21, 2, 4, 1, 1];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = centuryFromYear(input0[i]);
		let outputComparison = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `centuryFromYear(${JSON.stringify(input0)}) returned ${JSON.stringify(actualOutput)}, but expected ${JSON.stringify(expectedOutput[i])}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function centuryFromYear(year) {
	return Math.floor(year/100) + (year%100 > 0 ? 1 : 0);
}

main();