function main(): void {
	const input0: string[] = ["14:11", "07:02", "12:20", "00:01", "08:23", "21:57", "23:44"];
	const input1: string[] = ["14:39", "07:42", "14:54", "04:45", "08:54", "23:58", "23:59"];
	const expectedOutput: number[] = [0, 1, 17, 43, 1, 11, 0];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i: number = 0; i < expectedOutput.length; i++) {
		let actualOutput: number = parkingCost(input0[i], input1[i]);
		let outputComparison: boolean = actualOutput == expectedOutput[i];
		console.assert(outputComparison, `parkingCost(${JSON.stringify(input0)}, ${JSON.stringify(input1)}) returned ${JSON.stringify(actualOutput)}, but expected ${JSON.stringify(expectedOutput[i])}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function parkingCost(timeIn: string, timeOut: string): number {
	let time: number = parseInt(timeOut.substring(0, 2))*60 + parseInt(timeOut.substring(3)) - parseInt(timeIn.substring(0, 2))*60 - parseInt(timeIn.substring(3));
	if (time < 30)
		return 0;
	else if (time < 120)
		return Math.floor((time - 30)/10) + ((time - 30)%10 > 0 ? 1 : 0);
	else
		return 9 + 2*(Math.floor((time - 120)/10) + ((time - 120)%10 > 0 ? 1 : 0));
}

main();