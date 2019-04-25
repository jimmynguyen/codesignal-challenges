function main() {
	const input0 = [[7, 2], [10, 3]];
	const expectedOutput = [[3, 1, 2], [3, 1, 3]];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = improperFractionToMixed(input0[i]);
		let outputComparison = arraysEqual(actualOutput, expectedOutput[i]);
		console.assert(outputComparison, `improperFractionToMixed() returned ${actualOutput}, but expected ${expectedOutput[i]}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

// https://stackoverflow.com/questions/3115982/how-to-check-if-two-arrays-are-equal-with-javascript
function arraysEqual(a, b) {
	if (a === b) return true;
	if (a == null || b == null) return false;
	if (a.length != b.length) return false;
	for (var i = 0; i < a.length; ++i) {
		if (a[i] !== b[i]) return false;
	}
	return true;
}

function improperFractionToMixed(a) {
	return [Math.floor(a[0]/a[1]), a[0]%a[1], a[1]];
}

main();