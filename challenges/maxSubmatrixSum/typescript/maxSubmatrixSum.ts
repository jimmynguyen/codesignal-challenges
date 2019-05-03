function main(): void {
	const input0: number[][][] = [[[1,12,11,10], [4,3,2,9], [5,6,7,8]], [[1,2,-1], [-4,-8,3]], [[0,-1]], [[1,2,1,3], [1,1,1,1], [2,2,2,2]], [[1,-1], [0,0], [2,-1], [3,-10]]];
	const input1: number[] = [2, 2, 1, 3, 1];
	const input2: number[] = [1, 2, 1, 2, 2];
	const expectedOutput: number[] = [19, -4, 0, 10, 1];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input2.length == expectedOutput.length, `# input2 = ${input2.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i: number = 0; i < expectedOutput.length; i++) {
		let actualOutput: number = maxSubmatrixSum(input0[i], input1[i], input2[i]);
		let outputComparison: boolean = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `maxSubmatrixSum(${JSON.stringify(input0)}, ${JSON.stringify(input1)}, ${JSON.stringify(input2)}) returned ${JSON.stringify(actualOutput)}, but expected ${JSON.stringify(expectedOutput[i])}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function maxSubmatrixSum(matrix: number[][], n: number, m: number): number {
	const N: number = matrix.length;
	const M: number = matrix[0].length;
	let maxSum: number = Number.NEGATIVE_INFINITY;
	for (let i: number = 0; i < N-n+1; i++) {
		for (let j: number = 0; j < M-m+1; j++) {
			let currentSum: number = getSubmatrixSum(matrix, n, m, i, j);
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
		}
	}
	return maxSum;
}

function getSubmatrixSum(matrix: number[][], n: number, m: number, i: number, j: number): number {
	let sum: number = 0;
	for (let r: number = i; r < i+n; r++) {
		for (let c: number = j; c < j+m; c++) {
			sum += matrix[r][c];
		}
	}
	return sum;
}

main();