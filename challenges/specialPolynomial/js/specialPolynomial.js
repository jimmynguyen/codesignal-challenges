function main() {
	const input0 = [2, 10, 1, 3];
	const input1 = [5, 111111110, 100, 140];
	const expectedOutput = [1, 7, 99, 4];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = specialPolynomial(input0[i], input1[i]);
		let outputComparison = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `specialPolynomial() returned ${actualOutput}, but expected ${expectedOutput[i]}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function specialPolynomial(x, n) {
	let s=1, k=0;
	while (s<=n) {
		s += Math.pow(x, ++k);
	}
	return k-1;
}

main();