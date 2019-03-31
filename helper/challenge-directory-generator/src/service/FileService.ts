import { Challenge } from '../entity/Challenge';
import { sprintf } from 'sprintf-js';
import { ErrorService } from './ErrorService';
import { UserInputService } from './UserInputService';
import { Logger } from '../util/Logger';
import { IMainArgumentsMap } from '../interface/IMainArgumentsMap';
import * as rimraf from 'rimraf';
import * as fs from 'fs';
import { IStringFormatArgumentsMap } from '../interface/IStringFormatArgumentsMap';
import { IStringFormatArgument } from '../interface/IStringFormatArgument';
import { TestCaseArgument } from '../entity/TestCaseArgument';

abstract class FileService {
	protected REPOSITORY_ROOT_PATH: string = '../../';
	protected CHALLENGES_DIR_PATH: string = sprintf('%schallenges/', this.REPOSITORY_ROOT_PATH);
	protected TEMPLATES_DIR_PATH: string = './template/';
	protected REPOSITORY_README_TEXT_TO_SEARCH: string = '| --------- | :------: |';
	protected challenge: Challenge;
	protected challengeDirPath: string;
	protected challengeSolutionDirPath: string;
	public constructor(challenge: Challenge) {
		this.challenge = challenge;
		this.challengeDirPath = sprintf('%s%s/', this.CHALLENGES_DIR_PATH, challenge.getName());
		this.challengeSolutionDirPath = sprintf('%s%s/', this.challengeDirPath, challenge.getLanguage());
	}
	public async updateREADMEFile(): Promise<void> {
		const readmeFilePath: string = sprintf('%sREADME.md', this.REPOSITORY_ROOT_PATH);
		let readmeFile: string = fs.readFileSync(readmeFilePath, 'utf8');
		if (readmeFile.indexOf(this.REPOSITORY_README_TEXT_TO_SEARCH) < 0) {
			Logger.warn(ErrorService.ERRORS.FAILED_TO_UPDATE_README);
			return;
		}
		if (sprintf('[%s]', readmeFile).indexOf(this.challenge.getName()) >= 0) {
			Logger.warn(ErrorService.ERRORS.CHALLENGE_EXISTS_IN_README, this.challenge.getName());
			return;
		}
		fs.writeFileSync(readmeFilePath, readmeFile.split(this.REPOSITORY_README_TEXT_TO_SEARCH).join(sprintf('%s\n| [%s](%s) | [%s](https://github.com/jimmynguyen/codesignal-challenges/tree/master/challenges/%s) |', this.REPOSITORY_README_TEXT_TO_SEARCH, this.challenge.getName(), this.challenge.getLink(), this.challenge.getLanguage().toPascalCase(), this.challenge.getName())));
	}
	public async generateChallengeDirectory(): Promise<void> {
		if (!fs.existsSync(this.challengeDirPath)) {
			fs.mkdirSync(this.challengeDirPath);
		}
		this.createChallengeREADMEFile();
		if (fs.existsSync(this.challengeSolutionDirPath)) {
			const deleteChallengeSolutionDir: boolean = await UserInputService.confirm(UserInputService.INPUTS.DELETE_EXISTING_CHALLENGE_SOLUTION_DIR);
			if (!deleteChallengeSolutionDir) {
				return;
			}
			rimraf.sync(this.challengeSolutionDirPath);
		}
		fs.mkdirSync(this.challengeSolutionDirPath);
		this.createChallengeTestBashFile();
		this.createChallengeSolutionFiles();
	}
	private createChallengeREADMEFile(): void {
		const readmeFilePath = sprintf('%sREADME.md', this.challengeDirPath);
		fs.writeFileSync(readmeFilePath, sprintf('# %s\n\nLink to Challenge: [%s](%s)', this.challenge.getName(), this.challenge.getLink(), this.challenge.getLink()));
	}
	protected createChallengeTestBashFile(): void {
		const testBashFile: string = this.getChallengeTestBashFile();
		const testBashFilePath = sprintf('%stest.sh', this.challengeSolutionDirPath);
		fs.writeFileSync(testBashFilePath, testBashFile);
	}
	protected createMainSolutionFile(mainTemplateFileName: string, mainFileName: string): void {
		const mainTemplateFilePath: string = sprintf('%s%s', this.templatesDirPath, mainTemplateFileName);
		let mainFile: string = fs.readFileSync(mainTemplateFilePath, 'utf8');
		const argumentsMap: IMainArgumentsMap = this.getMainArgumentsMap();
		mainFile = this.replaceArguments(mainFile, argumentsMap);
		const mainFilePath: string = sprintf('%s%s', this.challengeSolutionDirPath, mainFileName);
		fs.writeFileSync(mainFilePath, mainFile);
	}
	protected replaceArguments(file: string, argumentsMap: IMainArgumentsMap): string {
		for (const argument in argumentsMap) {
			file = file.split(sprintf('[%s]', argument)).join(argumentsMap[argument]);
		}
		return file;
	}
	protected getStringFormat(type: string): string {
		const stringFormatArgumentsMap: IStringFormatArgumentsMap = this.getStringFormatArgumentsMap();
		for (const key in stringFormatArgumentsMap) {
			const stringFormatArgument: IStringFormatArgument = stringFormatArgumentsMap[key];
			if (stringFormatArgument.type == type) {
				return stringFormatArgument.format;
			}
		}
		return stringFormatArgumentsMap.DEFAULT.format;
	}
	protected abstract templatesDirPath: string;
	protected abstract getChallengeTestBashFile(): string;
	protected abstract createChallengeSolutionFiles(): void;
	protected abstract getMainArgumentsMap(): IMainArgumentsMap;
	protected abstract getStringFormatArgumentsMap(): IStringFormatArgumentsMap;
	protected abstract getTestCaseArgumentValue(testCaseArgument: TestCaseArgument): string;
}

export { FileService };