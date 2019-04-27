function main() {
	const input0 = [2024, 6, 4567, 3001, 5000, 1, 51234, 20100];
	const input1 = [1234, 5, 3456, 2901, 4999, 1, 12345, 19199];
	const expectedOutput = [[4, 12, 9, 1], [6], [7, 6, 5, 4], [1, 0, 10, 2], [10, 9, 9, 4], [1], [14, 12, 11, 10, 4], [10, 9, 10, 9, 1]];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = subtractionByRegrouping(input0[i], input1[i]);
		let outputComparison = arraysEqual(actualOutput, expectedOutput[i]);
		console.assert(outputComparison, `subtractionByRegrouping() returned ${actualOutput}, but expected ${expectedOutput[i]}`);
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

function subtractionByRegrouping(minuend, subtrahend) {
	let minuendArr = minuend.toString().split('').map((x) => parseInt(x));
	let subtrahendArr = subtrahend.toString().split('').map((x) => parseInt(x));
	let output = [];
	for (let i=minuendArr.length-1; i>=0; i--) {
		if (minuendArr[i] < subtrahendArr[i]) {
			minuendArr[i] += 10;
			minuendArr[i-1]--;
		}
		output[minuendArr.length-i-1] = minuendArr[i];
	}
	return output;
}

main();