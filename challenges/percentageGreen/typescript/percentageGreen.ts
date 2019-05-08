function main(): void {
	const input0: number[] = [2, 4];
	const input1: number[] = [5, 5];
	const expectedOutput: number[] = [40, 80];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i: number = 0; i < expectedOutput.length; i++) {
		let actualOutput: number = percentageGreen(input0[i], input1[i]);
		let outputComparison: boolean = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `percentageGreen(${JSON.stringify(input0)}, ${JSON.stringify(input1)}) returned ${JSON.stringify(actualOutput)}, but expected ${JSON.stringify(expectedOutput[i])}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function percentageGreen(green: number, total: number): number {
	return green / total * 100;
}

main();