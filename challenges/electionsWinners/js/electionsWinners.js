function main() {
	const input0 = [[2, 3, 5, 2], [1, 3, 3, 1, 1], [5, 1, 3, 4, 1], [1, 1, 1, 1], [1, 1, 1, 1], [3, 1, 1, 3, 1]];
	const input1 = [3, 0, 0, 1, 0, 2];
	const expectedOutput = [2, 0, 1, 4, 0, 2];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = electionsWinners(input0[i], input1[i]);
		let outputComparison = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `electionsWinners(${JSON.stringify(input0)}, ${JSON.stringify(input1)}) returned ${JSON.stringify(actualOutput)}, but expected ${JSON.stringify(expectedOutput[i])}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function electionsWinners(votes, k) {
	var maxVotes = Math.max(...votes);
	var numEligible = 0;
	if (k == 0) {
		for (var i = 0; i < votes.length; i++)
			if (votes[i] == maxVotes)
				numEligible++;
		numEligible = numEligible > 1 ? 0 : 1;
	} else {
		for (var i = 0; i < votes.length; i++)
			if (votes[i] + k > maxVotes)
				numEligible++;
	}
	return numEligible;
}

main();