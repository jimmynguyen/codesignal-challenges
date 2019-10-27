function main() {
	const input0 = [5, 10, 3, 3, 5, 5];
	const input1 = [4, 4, 3, 4, 4, 3];
	const input2 = [8, 9, 3, 3, 9, 2];
	const expectedOutput = ["either", "second", "either", "first", "both", "none"];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input2.length == expectedOutput.length, `# input2 = ${input2.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = knapsackLight2(input0[i], input1[i], input2[i]);
		let outputComparison = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `knapsackLight2(${JSON.stringify(input0)}, ${JSON.stringify(input1)}, ${JSON.stringify(input2)}) returned ${JSON.stringify(actualOutput)}, but expected ${JSON.stringify(expectedOutput[i])}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function knapsackLight2(weight1, weight2, maxW) {
	if (weight1 + weight2 <= maxW) return "both";
	if (weight1 <= maxW && weight2 > maxW) return "first";
	if (weight1 > maxW && weight2 <= maxW) return "second";
	if (weight1 <= maxW && weight2 <= maxW) return "either";
	return "none";
}

main();