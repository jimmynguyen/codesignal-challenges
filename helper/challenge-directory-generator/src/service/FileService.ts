import { Challenge } from '../entity/Challenge';
import { sprintf } from 'sprintf-js';
import * as fs from 'fs';
import { LanguageService } from './LanguageService';
import { ErrorService } from './ErrorService';
import { isUndefined } from 'util';
import { UserInputService } from './UserInputService';
import { JavaSolutionFileService } from './JavaSolutionFileService';
import { ISolutionFileService } from '../interface/ISolutionFileService';
import * as rimraf from 'rimraf';
import { Logger } from '../util/Logger';

class FileService {
	private static REPOSITORY_ROOT_PATH: string = '../../';
	private static CHALLENGES_DIR_PATH: string = sprintf('%schallenges/', FileService.REPOSITORY_ROOT_PATH);
	public static TEMPLATES_DIR_PATH: string = './template/';
	public static async updateREADMEFile(challenge: Challenge): Promise<void> {
		const readmeFilePath: string = sprintf('%sREADME.md', FileService.REPOSITORY_ROOT_PATH);
		let readmeFile: string = fs.readFileSync(readmeFilePath, 'utf8');
		let textToSearch: string = '| --------- | :------: |';
		if (readmeFile.indexOf(textToSearch) < 0) {
			Logger.warn(ErrorService.ERRORS.FAILED_TO_UPDATE_README);
			return;
		}
		fs.writeFileSync(readmeFilePath, readmeFile.split(textToSearch).join(sprintf('%s\n| [%s](%s) | [%s](https://github.com/jimmynguyen/codesignal-challenges/tree/master/challenges/%s) |', textToSearch, challenge.getName(), challenge.getLink(), challenge.getLanguage().toPascalCase(), challenge.getName())));
	}
	public static async generateChallengeDirectory(challenge: Challenge): Promise<void> {
		const challengeDirPath: string = sprintf('%s%s/', FileService.CHALLENGES_DIR_PATH, challenge.getName());
		if (fs.existsSync(challengeDirPath)) {
			const deleteChallengeDir: boolean = await UserInputService.confirm(UserInputService.INPUTS.DELETE_EXISTING_CHALLENGE_DIR);
			if (!deleteChallengeDir) {
				return;
			}
			rimraf.sync(challengeDirPath);
		}
		fs.mkdirSync(challengeDirPath);
		FileService.createChallengeREADMEFile(challengeDirPath, challenge);
		FileService.createChallengeTestBashFile(challengeDirPath, challenge);
		FileService.createChallengeSolutionFiles(challengeDirPath, challenge);
	}
	private static createChallengeREADMEFile(challengeDirPath: string, challenge: Challenge): void {
		const readmeFilePath = sprintf('%sREADME.md', challengeDirPath);
		fs.writeFileSync(readmeFilePath, sprintf('# %s\n\nLink to Challenge: [%s](%s)', challenge.getName(), challenge.getLink(), challenge.getLink()));
	}
	private static createChallengeTestBashFile(challengeDirPath: string, challenge: Challenge): void {
		const testBashFile: string | undefined = FileService.getTestBashFileByLanguage(challenge);
		if (isUndefined(testBashFile)) {
			ErrorService.throw(ErrorService.ERRORS.UNSUPPORTED_LANGUAGE, challenge.getLanguage());
		}
		const testBashFilePath = sprintf('%stest.sh', challengeDirPath);
		fs.writeFileSync(testBashFilePath, testBashFile);
	}
	private static getTestBashFileByLanguage(challenge: Challenge): string | undefined {
		const language: string = challenge.getLanguage();
		const challengeName: string = challenge.getName();
		let testBashFile: string | undefined;
		switch (language) {
			case LanguageService.LANGUAGES.JAVA:
				testBashFile = sprintf('java -ea %s.java', challengeName.toPascalCase());
				break;
		}
		return testBashFile;
	}
	private static createChallengeSolutionFiles(challengeDirPath: string, challenge: Challenge): void {
		let solutionFileService: ISolutionFileService | undefined;
		switch (challenge.getLanguage()) {
			case LanguageService.LANGUAGES.JAVA:
				solutionFileService = new JavaSolutionFileService(challenge, challengeDirPath);
				break;
		}
		if (isUndefined(solutionFileService)) {
			ErrorService.throw(ErrorService.ERRORS.UNSUPPORTED_LANGUAGE, challenge.getLanguage());
		} else {
			solutionFileService.createSolutionFiles();
		}
	}
}

export { FileService };