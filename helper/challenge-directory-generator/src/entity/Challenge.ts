import { TestCase } from './TestCase';

class Challenge {
	private id: string = '';
	private name: string = '';
	private link: string = '';
	private language: string = '';
	private testCases: TestCase[] = [];
	public constructor(id: string, language: string) {
		this.id = id;
		this.language = language;
	}
	public getId(): string {
		return this.id;
	}
	public setId(id: string): void {
		this.id = id;
	}
	public getName(): string {
		return this.name;
	}
	public setName(name: string): void {
		this.name = name;
	}
	public getLink(): string {
		return this.link;
	}
	public setLink(link: string): void {
		this.link = link;
	}
	public getLanguage(): string {
		return this.language;
	}
	public setLanguage(language: string): void {
		this.language = language;
	}
	public getTestCases(): TestCase[] {
		return this.testCases;
	}
	public setTestCases(testCases: TestCase[]) {
		this.testCases = testCases;
	}
	public addTestCase(testCase: TestCase): void {
		this.testCases.push(testCase);
	}
}

export { Challenge };