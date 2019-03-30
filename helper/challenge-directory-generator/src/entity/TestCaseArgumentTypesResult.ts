class TestCaseArgumentTypesResult {
	private inputTypes: string[];
	private outputType: string;
	public constructor(inputTypes: string[], outputType: string) {
		this.inputTypes = inputTypes;
		this.outputType = outputType;
	}
	public getInputTypes(): string[] {
		return this.inputTypes;
	}
	public setInputTypes(inputTypes: string[]): void {
		this.inputTypes = inputTypes;
	}
	public addInputType(inputType: string): void {
		this.inputTypes.push(inputType);
	}
	public getOutputType(): string {
		return this.outputType;
	}
	public setOutputType(outputType: string): void {
		this.outputType = outputType;
	}
}

export { TestCaseArgumentTypesResult }