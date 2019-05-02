function main() {
	const input0 = [1, 21, 8, 21, 76, 80];
	const input1 = [5, 5, 4, 6, 250, 1000];
	const expectedOutput = [5, 22, 10, 23, 166, 419];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = pagesNumberingWithInk(input0[i], input1[i]);
		let outputComparison = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `pagesNumberingWithInk() returned ${actualOutput}, but expected ${expectedOutput[i]}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function pagesNumberingWithInk(current, numberOfDigits) {
	let currentNumberOfDigits = current.toString().length;
	while (numberOfDigits >= currentNumberOfDigits) {
		numberOfDigits -= currentNumberOfDigits;
		currentNumberOfDigits = (++current).toString().length;
	}
	return current-1;
}

main();