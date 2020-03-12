function main(): void {
	const input0: number[][] = [[4, 2, 1, 5, 3, 6], [2, 5], [100], [-100000, -99999, -99998]];
	const input1: number[][] = [[1, 2, 4, 3, 5, 6], [5, 2], [100], [-99999, -100000, -99998]];
	const expectedOutput: Tree<number>[] = [{ "value": 1, "left": { "value": 2, "left": { "value": 4, "left": null, "right": null }, "right": null }, "right": { "value": 3, "left": { "value": 5, "left": null, "right": null }, "right": { "value": 6, "left": null, "right": null } }}, { "value": 5, "left": { "value": 2, "left": null, "right": null }, "right": null}, { "value": 100, "left": null, "right": null}, { "value": -99999, "left": { "value": -100000, "left": null, "right": null }, "right": { "value": -99998, "left": null, "right": null }}];
	console.assert(input0.length == expectedOutput.length, `# input0 = ${input0.length}, # expectedOutput = ${expectedOutput.length}`);
	console.assert(input1.length == expectedOutput.length, `# input1 = ${input1.length}, # expectedOutput = ${expectedOutput.length}`);
	let testsPassed = 0;
	for (let i: number = 0; i < expectedOutput.length; i++) {
		let actualOutput: Tree<number> = restoreBinaryTree(input0[i], input1[i]);
		let outputComparison: boolean = JSON.stringify(actualOutput) == JSON.stringify(expectedOutput[i]);
		console.assert(outputComparison, `restoreBinaryTree(${JSON.stringify(input0)}, ${JSON.stringify(input1)}) returned ${JSON.stringify(actualOutput)}, but expected ${JSON.stringify(expectedOutput[i])}`);
		if (outputComparison) {
			testsPassed++;
		}
	}
	console.log(`PASSES ${testsPassed} out of ${expectedOutput.length} tests`);
}

function restoreBinaryTree(inorder: number[], preorder: number[]): Tree<number> {
	if (inorder.length == 1) {
			return new Tree(inorder[0]);
	}
	const root = new Tree(preorder[0]);
	const rootIndex = inorder.indexOf(root.value);
	const leftInorder = inorder.slice(0, rootIndex);
	const rightInorder = inorder.slice(rootIndex + 1, inorder.length);
	if (leftInorder.length > 0) {
			root.left = restoreBinaryTree(leftInorder, preorder.slice(1, leftInorder.length));
	}
	if (rightInorder.length > 0) {
			root.right = restoreBinaryTree(rightInorder, preorder.slice(1 + leftInorder.length, preorder.length));
	}
	return root;
}

class Tree<T> {
	value: T;
	left: Tree<T>;
	right: Tree<T>;

	constructor(value: T) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

main();