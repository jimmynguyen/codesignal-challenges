function main() {
	const input0 = [5, 1, 3, 11, 15, 14, 12, 6, 13, 2];
	const input1 = [2, 2, 3, 3, 5, 3, 2, 4, 5, 3];
	const expectedOutput = [9, 1, 4, 16, 18, 20, 23, 7, 16, 2];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = candles(input0[i], input1[i]);
		let outputComparison = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `candles(${JSON.stringify(input0)}, ${JSON.stringify(input1)}) returned ${JSON.stringify(actualOutput)}, but expected ${JSON.stringify(expectedOutput[i])}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function candles(candlesNumber, makeNew) {
	var leftovers = candlesNumber, n;
	while (leftovers / makeNew >= 1) {
		n = Math.floor(leftovers / makeNew);
		candlesNumber += n;
		leftovers += n - n * makeNew;
	}
	return candlesNumber;
}

main();