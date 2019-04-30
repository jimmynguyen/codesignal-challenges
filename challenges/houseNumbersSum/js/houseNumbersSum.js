function main() {
	const input0 = [[5, 1, 2, 3, 0, 1, 5, 0, 2], [4, 2, 1, 6, 0], [4, 1, 2, 3, 0, 10, 2], [0, 1, 2, 3, 0], [5, 1, 1, 3, 0, 1, 5, 0, 2], [10, 10, 10, 10, 10, 10, 10, 10, 10, 0], [10, 10, 10, 10, 10, 10, 10, 10, 0, 10]];
	const expectedOutput = [11, 13, 10, 0, 10, 90, 80];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = houseNumbersSum(input0[i]);
		let outputComparison = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `houseNumbersSum() returned ${actualOutput}, but expected ${expectedOutput[i]}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function houseNumbersSum(a) {
	let s = 0;
	for (let x of a)
		if (x == 0)
			break;
		else
			s += x;
	return s;
}

main();