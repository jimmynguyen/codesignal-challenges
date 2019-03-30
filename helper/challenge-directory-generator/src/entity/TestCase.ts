import { TestCaseArgument } from './TestCaseArgument';

class TestCase {
	private inputs: TestCaseArgument[] = [];
	private output: TestCaseArgument;
	public constructor(inputs: TestCaseArgument[], output: TestCaseArgument) {
		this.inputs = inputs;
		this.output = output;
	}
	public getInputs(): TestCaseArgument[] {
		return this.inputs;
	}
	public setInputs(inputs: TestCaseArgument[]): void {
		this.inputs = inputs;
	}
	public addInput(input: TestCaseArgument): void {
		this.inputs.push(input);
	}
	public getOutput(): TestCaseArgument {
		return this.output;
	}
	public setOutput(output: TestCaseArgument): void {
		this.output = output;
	}
}

export { TestCase };