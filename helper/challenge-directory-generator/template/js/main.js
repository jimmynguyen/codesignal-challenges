function main() {
	[TEST_INPUTS]
	const expectedOutput = [[TEST_OUTPUTS]];
	[NUM_TESTS_ASSERTION]
	let testsPassed = 0;
	for (let i = 0; i < expectedOutput.length; i++) {
		let actualOutput = [METHOD_NAME]([METHOD_ARGS]);
		let outputComparison = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `[METHOD_NAME]() returned ${actualOutput}, but expected ${expectedOutput[i]}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function [METHOD_NAME]([METHOD_ARGS_DEFINITION]) {
	throw new Error("Method not implemented.");
}

main();