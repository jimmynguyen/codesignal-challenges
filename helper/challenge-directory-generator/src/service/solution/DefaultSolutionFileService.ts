import { sprintf } from 'sprintf-js';

import { Challenge } from '../../entity/Challenge';
import { TestCaseArgument } from '../../entity/TestCaseArgument';
import { IMainArgumentsMap } from '../../interface/solution/IMainArgumentsMap';
import { IStringFormatArgumentsMap } from '../../interface/solution/IStringFormatArgumentsMap';
import { FileService } from '../FileService';
import { UserInputService } from '../UserInputService';

class DefaultSolutionFileService extends FileService {
	protected resourcesDirPath: string;
	public constructor(challenge: Challenge) {
		super(challenge);
		this.resourcesDirPath = this.RESOURCES_DIR_PATH;
	}
	protected async getChallengeTestBashFile(): Promise<string> {
		return await UserInputService.get(UserInputService.INPUTS.TEST_BASH_FILE);
	}
	protected createChallengeSolutionFiles(): void {
		this.createMainSolutionFile(undefined, sprintf('%s.%s', this.challenge.getName(), this.challenge.getLanguage().fileExtension))
	}
	protected getMainArgumentsMap(): IMainArgumentsMap {
		throw new Error('Method not implemented.');
	}
	protected getStringFormatArgumentsMap(): IStringFormatArgumentsMap {
		throw new Error('Method not implemented.');
	}
	protected getTestCaseArgumentValue(testCaseArgument: TestCaseArgument): string {
		throw new Error('Method not implemented.');
	}
	protected setMainArgumentsMapValues(argumentsMap: IMainArgumentsMap): void {
		throw new Error('Method not implemented.');
	}
}

export { DefaultSolutionFileService };