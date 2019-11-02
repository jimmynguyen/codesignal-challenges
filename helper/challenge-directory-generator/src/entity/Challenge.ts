import { ILanguage } from '../interface/ILanguage';
import { TestCase } from './TestCase';
import { ChallengeService } from '../service/ChallengeService';

class Challenge {
	private static SITE_URL: string = 'https://app.codesignal.com';
	private static CHALLENGE_URL_TEMPLATE: string = Challenge.SITE_URL + '/challenge/{challengeId}';
	private id: string = '';
	private name: string = '';
	private link: string = '';
	private language: ILanguage;
	private testCases: TestCase[] = [];
	public constructor(idOrLink: string, language: ILanguage) {
		if (idOrLink.indexOf(Challenge.SITE_URL) > -1) {
			this.link = idOrLink;
		} else {
			this.id = idOrLink;
			this.link = Challenge.CHALLENGE_URL_TEMPLATE.replace('{challengeId}', idOrLink);
		}
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
	public getLanguage(): ILanguage {
		return this.language;
	}
	public setLanguage(language: ILanguage): void {
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