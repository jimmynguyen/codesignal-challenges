import { Builder, By, Capabilities, until, WebDriver, WebElement } from 'selenium-webdriver';
import * as chrome from 'selenium-webdriver/chrome';

import { Challenge } from '../entity/Challenge';
import { TestCase } from '../entity/TestCase';
import { TestCaseArgument } from '../entity/TestCaseArgument';
import { TestCaseArgumentTypesResult } from '../entity/TestCaseArgumentTypesResult';
import { UserInputService } from './UserInputService';

class ChallengeService {
	private static URL_TEMPLATE: string = 'https://app.codesignal.com/challenge/{challengeId}';
	private static WINDOW_SIZE: any = { width: 1280, height: 960 };
	private static TIMEOUT: number = 2000;
	public static async getChallenge(language: string): Promise<Challenge> {
		let challenge: Challenge = new Challenge(await ChallengeService.getChallengeId(), language);
		let driver: WebDriver = await new Builder().withCapabilities(Capabilities.chrome()).setChromeOptions(new chrome.Options().headless().windowSize(ChallengeService.WINDOW_SIZE)).build();
		const linkToChallenge = ChallengeService.URL_TEMPLATE.replace('{challengeId}', challenge.getId());
		challenge.setLink(linkToChallenge);
		try {
			await driver.get(linkToChallenge);
			let methodHeader: string = await ChallengeService.getMethodHeader(driver);
			challenge.setName(ChallengeService.getChallengeName(methodHeader));
			let testCaseArgumentTypes: TestCaseArgumentTypesResult = ChallengeService.getTestCaseArgumentTypes(methodHeader);
			challenge.setTestCases(await ChallengeService.getTestCases(driver, testCaseArgumentTypes));
		} finally {
			await driver.quit();
		}
		return challenge;
	}
	private static async getChallengeId(): Promise<string> {
		let challengeId: string;
		if (process.argv.length > 3) {
			challengeId = process.argv[3];
		} else {
			challengeId = await UserInputService.get(UserInputService.INPUTS.CHALLENGE_ID);
		}
		return challengeId;
	}
	private static async getMethodHeader(driver: WebDriver): Promise<string> {
		let languageDropdownButton: WebElement = await driver.wait(until.elementLocated(By.xpath('//div[@data-name="language-selector"]')), ChallengeService.TIMEOUT);
		await languageDropdownButton.click();
		let javaLanguageDropdownOption: WebElement = await driver.wait(until.elementLocated(By.xpath('//div[contains(@class, "select-menu ")]/div/div/span[text()="Java"]')), ChallengeService.TIMEOUT);
		await javaLanguageDropdownOption.click();
		await driver.wait(until.elementLocated(By.xpath('//div[contains(@class, "tabs--title")]/div/span[text()="main.java"]')), ChallengeService.TIMEOUT);
		let methodHeaderElement: WebElement =  await driver.wait(until.elementLocated(By.xpath('//pre[contains(@class,"CodeMirror-line")][1]/span[@role="presentation"]')), ChallengeService.TIMEOUT);
		let methodHeader: string = await methodHeaderElement.getAttribute("innerText");
		return methodHeader;
	}
	private static getChallengeName(methodHeader: string): string {
		return methodHeader.split(' ')[1].split('(')[0];
	}
	private static getTestCaseArgumentTypes(methodHeader: string): TestCaseArgumentTypesResult {
		let methodHeaderArgs = methodHeader.split(' ');
		let outputType: string = methodHeaderArgs[0];
		let inputTypes: string[] = [];
		let tempArgs = methodHeaderArgs[1].split('(');
		inputTypes.push(tempArgs[1]);
		for (var i = 3; i < methodHeaderArgs.length-1; i+=2) {
			inputTypes.push(methodHeaderArgs[i]);
		}
		return new TestCaseArgumentTypesResult(inputTypes, outputType);
	}
	private static async getTestCases(driver: WebDriver, testCaseArgumentTypes: TestCaseArgumentTypesResult): Promise<TestCase[]> {
		let testCases: TestCase[] = [];
		let testCaseWebElements: WebElement[] = await driver.wait(until.elementsLocated(By.xpath('//div[@class="accordion--head" and child::div/span[@class="-layout-h -center -space-h-8" and not(child::div)]]')), ChallengeService.TIMEOUT);
		for (const testCaseWebElement of testCaseWebElements) {
			testCases.push(await ChallengeService.getTestCase(driver, testCaseWebElement, testCaseArgumentTypes));
		}
		return testCases;
	}
	private static async getTestCase(driver: WebDriver, testCaseWebElement: WebElement, testCaseArgumentTypes: TestCaseArgumentTypesResult): Promise<TestCase> {
		await testCaseWebElement.click();
		let inputs: TestCaseArgument[] = await ChallengeService.getTestCaseInputs(driver, testCaseArgumentTypes.getInputTypes());
		let output: TestCaseArgument = await ChallengeService.getTestCaseOutput(driver, testCaseArgumentTypes.getOutputType());
		return new TestCase(inputs, output);
	}
	private static async getTestCaseInputs(driver: WebDriver, inputTypes: string[]): Promise<TestCaseArgument[]> {
		let inputs: TestCaseArgument[] = [];
		let inputWebElements: WebElement[] = await driver.findElements(By.xpath('//pre[contains(@class, "task-tests--value") and not(contains(@class, "-answer"))]/div'));
		for (const [index, inputWebElement] of inputWebElements.entries()) {
			inputs.push(new TestCaseArgument((await inputWebElement.getAttribute('innerText')).split(': ')[1], inputTypes[index]));
		}
		return inputs;
	}
	private static async getTestCaseOutput(driver: WebDriver, outputType: string): Promise<TestCaseArgument> {
		let outputWebElement: WebElement = await driver.findElement(By.xpath('//pre[contains(@class, "task-tests--value") and contains(@class, "-answer")]'));
		return new TestCaseArgument(await outputWebElement.getAttribute('innerText'), outputType);
	}
}

export { ChallengeService };