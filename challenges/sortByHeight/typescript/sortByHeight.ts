function main(): void {
	const input0: number[][] = [[-1, 150, 190, 170, -1, -1, 160, 180], [-1, -1, -1, -1, -1], [-1], [4, 2, 9, 11, 2, 16], [2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1], [23, 54, -1, 43, 1, -1, -1, 77, -1, -1, -1, 3]];
	const expectedOutput: number[][] = [[-1, 150, 160, 170, -1, -1, 180, 190], [-1, -1, -1, -1, -1], [-1], [2, 2, 4, 9, 11, 16], [1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2], [1, 3, -1, 23, 43, -1, -1, 54, -1, -1, -1, 77]];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i: number = 0; i < expectedOutput.length; i++) {
		let actualOutput: number[] = sortByHeight(input0[i]);
		let outputComparison: boolean = arraysEqual(actualOutput, expectedOutput[i]);
		console.assert(outputComparison, `sortByHeight(${JSON.stringify(input0)}) returned ${JSON.stringify(actualOutput)}, but expected ${JSON.stringify(expectedOutput[i])}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

// https://stackoverflow.com/questions/3115982/how-to-check-if-two-arrays-are-equal-with-javascript
function arraysEqual(a: any[], b: any[]): boolean {
	if (a === b) return true;
	if (a == null || b == null) return false;
	if (a.length != b.length) return false;
	for (let i: number = 0; i < a.length; ++i) {
		if (a[i] !== b[i]) return false;
	}
	return true;
}

function sortByHeight(a: number[]): number[] {
	let n: number[] = [];
	let b: number[] = [];
	for (let i: number = 0; i < a.length; i++)
		if (a[i] > -1) {
			n.push(i);
			b.push(a[i]);
		}
	b.sort((x, y) => x > y ? 1 : x < y ? -1 : 0);
	for (let i: number = 0; i < n.length; i++)
		a[n[i]] = b[i];
	return a;
}

main();