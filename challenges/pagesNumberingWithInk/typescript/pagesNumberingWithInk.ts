function main(): void {
	const input0: number[] = [1, 21, 8, 21, 10, 76, 80];
	const input1: number[] = [5, 5, 4, 6, 3, 250, 1000];
	const expectedOutput: number[] = [5, 22, 10, 23, 10, 166, 419];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i: number = 0; i < expectedOutput.length; i++) {
		let actualOutput: number = pagesNumberingWithInk(input0[i], input1[i]);
		let outputComparison: boolean = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `pagesNumberingWithInk(${input0}, ${input1}) returned ${actualOutput}, but expected ${expectedOutput[i]}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function pagesNumberingWithInk(current: number, numberOfDigits: number): number {
	let currentNumberOfDigits: number = current.toString().length;
	while (numberOfDigits >= currentNumberOfDigits) {
		numberOfDigits -= currentNumberOfDigits;
		currentNumberOfDigits = (++current).toString().length;
	}
	return current-1;
}

main();