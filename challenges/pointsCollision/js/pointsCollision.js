function main() {
	const input0 = [[0, 0], [1, 7], [1, 1], [-3, 0], [1, 1], [1, 1]];
	const input1 = [[10, 0], [1, -3], [30, 30], [-2, 0], [8, 2], [8, 2]];
	const input2 = [[40, 0], [0, 1], [5, 5], [2, 0], [2, 6], [-2, -6]];
	const input3 = [[-30, 0], [0, -1], [4, 4], [2, 0], [-12, 4], [12, -4]];
	const expectedOutput = [true, false, true, false, true, false];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input2.length == expectedOutput.length, `# input2 = ${input2.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input3.length == expectedOutput.length, `# input3 = ${input3.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = pointsCollision(input0[i], input1[i], input2[i], input3[i]);
		let outputComparison = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `pointsCollision(${JSON.stringify(input0)}, ${JSON.stringify(input1)}, ${JSON.stringify(input2)}, ${JSON.stringify(input3)}) returned ${JSON.stringify(actualOutput)}, but expected ${JSON.stringify(expectedOutput[i])}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function pointsCollision(p, q, u, v) {
	y = q[1] - p[1]
	r = q[0] - p[0] || y
	o = u[1] - v[1]
	i = u[0] - v[0] || o
	t = i ? r / i : -r
	return t >= 0 && o * t == y
}

main();