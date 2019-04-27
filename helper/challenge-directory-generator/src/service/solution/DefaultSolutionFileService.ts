import { sprintf } from 'sprintf-js';

import { Challenge } from '../../entity/Challenge';
import { TestCaseArgument } from '../../entity/TestCaseArgument';
import { IMainArgumentsMap } from '../../interface/solution/IMainArgumentsMap';
import { IStringFormatArgumentsMap } from '../../interface/solution/IStringFormatArgumentsMap';
import { FileService } from '../FileService';
import { UserInputService } from '../UserInputService';

class DefaultSolutionFileService extends FileService {
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