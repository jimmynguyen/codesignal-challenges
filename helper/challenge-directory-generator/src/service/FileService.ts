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

class FileService {
	private static REPOSITORY_ROOT_PATH: string = '../../';
	private static CHALLENGES_DIR_PATH: string = sprintf('%schallenges/', FileService.REPOSITORY_ROOT_PATH);
	public static TEMPLATES_DIR_PATH: string = './template/';
	public static async generateChallengeDirectory(challenge: Challenge): Promise<void> {
		const challengeDirPath = sprintf('%s%s/', FileService.CHALLENGES_DIR_PATH, challenge.getName());
		if (fs.existsSync(challengeDirPath)) {
			const deleteChallengeDir: boolean = await UserInputService.confirm(UserInputService.INPUTS.DELETE_EXISTING_CHALLENGE_DIR);
			if (!deleteChallengeDir) {
				return;
			}
			rimraf.sync(challengeDirPath);
		}
		fs.mkdirSync(challengeDirPath);
		FileService.createREADMEFile(challengeDirPath, challenge);
		FileService.createTestBashFile(challengeDirPath, challenge);
		FileService.createSolutionFiles(challengeDirPath, challenge);
	}
	private static createREADMEFile(challengeDirPath: string, challenge: Challenge): void {
		const readmeFilePath = sprintf('%sREADME.md', challengeDirPath);
		fs.writeFileSync(readmeFilePath, sprintf('# %s\n\nLink to Challenge: [%s](%s)', challenge.getName(), challenge.getLink(), challenge.getLink()));
	}
	private static createTestBashFile(challengeDirPath: string, challenge: Challenge): void {
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
	private static createSolutionFiles(challengeDirPath: string, challenge: Challenge): void {
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