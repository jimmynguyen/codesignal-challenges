function main() {
	const input0 = [[[1,12,11,10], [4,3,2,9], [5,6,7,8]], [[1,2,-1], [-4,-8,3]], [[0,-1]], [[1,2,1,3], [1,1,1,1], [2,2,2,2]], [[1,-1], [0,0], [2,-1], [3,-10]]];
	const input1 = [2, 2, 1, 3, 1];
	const input2 = [1, 2, 1, 2, 2];
	const expectedOutput = [19, -4, 0, 10, 1];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input2.length == expectedOutput.length, `# input2 = ${input2.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = maxSubmatrixSum(input0[i], input1[i], input2[i]);
		let outputComparison = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `maxSubmatrixSum(${JSON.stringify(input0)}, ${JSON.stringify(input1)}, ${JSON.stringify(input2)}) returned ${JSON.stringify(actualOutput)}, but expected ${JSON.stringify(expectedOutput[i])}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function maxSubmatrixSum(matrix, n, m) {
	const N = matrix.length;
	const M = matrix[0].length;
	let maxSum = Number.NEGATIVE_INFINITY;
	for (let i = 0; i < N-n+1; i++) {
		for (let j = 0; j < M-m+1; j++) {
			let currentSum = getSubmatrixSum(matrix, n, m, i, j);
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
		}
	}
	return maxSum;
}

function getSubmatrixSum(matrix, n, m, i, j) {
	let sum = 0;
	for (let r = i; r < i+n; r++) {
		for (let c = j; c < j+m; c++) {
			sum += matrix[r][c];
		}
	}
	return sum;
}

main();