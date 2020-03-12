import { Builder, By, Capabilities, until, WebDriver, WebElement } from 'selenium-webdriver';
import * as chrome from 'selenium-webdriver/chrome';

import { Challenge } from '../entity/Challenge';
import { TestCase } from '../entity/TestCase';
import { TestCaseArgument } from '../entity/TestCaseArgument';
import { TestCaseArgumentTypesResult } from '../entity/TestCaseArgumentTypesResult';
import { ILanguage } from '../interface/ILanguage';
import { UserInputService } from './UserInputService';

class ChallengeService {
	private static WINDOW_SIZE: any = { width: 1280, height: 960 };
	private static TIMEOUT: number = 5000;
	public static async getChallengeByLanguage(language: ILanguage): Promise<Challenge> {
		let challenge: Challenge = new Challenge(await ChallengeService.getChallengeIdOrLink(), language);
		let driver: WebDriver = await new Builder().withCapabilities(Capabilities.chrome()).setChromeOptions(await ChallengeService.getChromeOptions()).build();
		try {
			let username = await ChallengeService.getUsername();
			let password = await ChallengeService.getPassword();
			await driver.get("https://app.codesignal.com/login")
			let usernameInput: WebElement = await driver.wait(until.elementLocated(By.xpath('//input[@name="username"]')), ChallengeService.TIMEOUT);
			await usernameInput.sendKeys(username);
			let passwordInput: WebElement = await driver.wait(until.elementLocated(By.xpath('//input[@name="password"]')), ChallengeService.TIMEOUT);
			await passwordInput.sendKeys(password);
			let signInButton: WebElement = await driver.wait(until.elementLocated(By.xpath('//*[@class="coder-login--button"]')), ChallengeService.TIMEOUT);
			await signInButton.click();
			await driver.wait(until.elementLocated(By.xpath('//h3[text()="Daily Challenge"]')), ChallengeService.TIMEOUT);
			await driver.get(challenge.getLink());
			let methodHeader: string = await ChallengeService.getMethodHeader(driver);
			challenge.setName(ChallengeService.getChallengeName(methodHeader));
			let testCaseArgumentTypes: TestCaseArgumentTypesResult = ChallengeService.getTestCaseArgumentTypes(methodHeader);
			challenge.setTestCases(await ChallengeService.getTestCases(driver, testCaseArgumentTypes));
		} finally {
			await driver.quit();
		}
		return challenge;
	}
	private static async getChallengeIdOrLink(): Promise<string> {
		let challengeIdOrLink: string;
		if (process.argv.length > 3) {
			challengeIdOrLink = process.argv[3];
		} else {
			challengeIdOrLink = await UserInputService.get(UserInputService.INPUTS.CHALLENGE_ID);
		}
		return challengeIdOrLink;
	}
	private static async getChromeOptions(): Promise<chrome.Options> {
		let options: chrome.Options;
		let headless: boolean = true;
		if (process.argv.length > 4) {
			headless = process.argv[4] == 'yes' || process.argv[4] == 'y';
		} else {
			headless = await UserInputService.confirm(UserInputService.INPUTS.RUN_HEADLESS);
		}
		if (headless) {
			options = new chrome.Options().headless().windowSize(ChallengeService.WINDOW_SIZE);
		} else {
			options = new chrome.Options();
		}
		return options;
	}
	private static async getUsername(): Promise<string> {
		let username: string;
		if (process.argv.length > 5) {
			username = process.argv[5];
		} else {
			username = await UserInputService.get(UserInputService.INPUTS.USERNAME);
		}
		return username;
	}
	private static async getPassword(): Promise<string> {
		let password: string;
		if (process.argv.length > 6) {
			password = process.argv[6];
		} else {
			password = await UserInputService.get(UserInputService.INPUTS.CHALLENGE_ID);
		}
		return password;
	}
	private static async getMethodHeader(driver: WebDriver): Promise<string> {
		let languageDropdownButton: WebElement = await driver.wait(until.elementLocated(By.xpath('//div[@data-name="language-selector"]')), ChallengeService.TIMEOUT);
		await languageDropdownButton.click();
		let javaLanguageDropdownOption: WebElement = await driver.wait(until.elementLocated(By.xpath('//div[contains(@class, "select-menu ")]/div/div/span[text()="Java"]')), ChallengeService.TIMEOUT);
		await javaLanguageDropdownOption.click();
		await driver.wait(until.elementLocated(By.xpath('//div[contains(@class, "tabs--title")]/div/span[text()="main.java"]')), ChallengeService.TIMEOUT);
		let methodHeaderElement: WebElement =  await driver.wait(until.elementLocated(By.xpath('//*[contains(@class,"view-lines")]//*[contains(@class,"view-line") and not(./span/child::span[starts-with(text(),"//")])][1]/span')), ChallengeService.TIMEOUT);
    let methodHeader: string = await methodHeaderElement.getAttribute("innerText");
		return methodHeader;
	}
	private static getChallengeName(methodHeader: string): string {
		return methodHeader.split(/(\s+)/)[2].split('(')[0];
	}
	private static getTestCaseArgumentTypes(methodHeader: string): TestCaseArgumentTypesResult {
    let methodHeaderArgs = methodHeader.split(/(\s+)/);
    for (var i = 0; i < methodHeaderArgs.length; i++) {
      methodHeaderArgs.splice(i + 1, 1);
    }
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
		let testCaseWebElements: WebElement[] = await driver.wait(until.elementsLocated(By.xpath('//div[contains(@class, "accordion") and contains(@class, "-theme-dark-blue") and child::div[@class="accordion--head" and child::div/span[@class="-layout-h -center -space-h-8" and not(div/div[contains(@class, "icon")])]]]')), ChallengeService.TIMEOUT);
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
			inputs.push(new TestCaseArgument((await inputWebElement.getAttribute('innerText')).split(':')[1].trim().replace(/(\r\n|\n|\r)/gm,'').replace(/ +(?= )/g,''), inputTypes[index]));
		}
		return inputs;
	}
	private static async getTestCaseOutput(driver: WebDriver, outputType: string): Promise<TestCaseArgument> {
		let outputWebElement: WebElement = await driver.wait(until.elementLocated(By.xpath('//pre[contains(@class, "task-tests--value") and contains(@class, "-answer")]')), ChallengeService.TIMEOUT);
		return new TestCaseArgument((await outputWebElement.getAttribute('innerText')).trim().replace(/(\r\n|\n|\r)/gm,'').replace(/ +(?= )/g,''), outputType);
	}
}

export { ChallengeService };