class TestCaseArgument {
	private value: string;
	private type: string;
	public constructor(value: string, type: string) {
		this.value = value;
		this.type = type;
	}
	public getValue(): string {
		return this.value;
	}
	public setValue(value: string): void {
		this.value = value;
	}
	public getType(): string {
		return this.type;
	}
	public setType(type: string): void {
		this.type = type;
	}
}

export { TestCaseArgument };