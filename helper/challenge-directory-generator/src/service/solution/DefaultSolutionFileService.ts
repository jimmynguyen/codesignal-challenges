import { TestCaseArgument } from '../../entity/TestCaseArgument';
import { IArgumentsMap } from '../../interface/solution/IArgumentsMap';
import { IStringFormatArgumentsMap } from '../../interface/solution/IStringFormatArgumentsMap';
import { FileService } from '../FileService';

class DefaultSolutionFileService extends FileService {
	protected getMainArgumentsMap(): IArgumentsMap {
		throw new Error('Method not implemented.');
	}
	protected getStringFormatArgumentsMap(): IStringFormatArgumentsMap {
		throw new Error('Method not implemented.');
	}
	protected getTestCaseArgumentValue(testCaseArgument: TestCaseArgument): string {
		throw new Error('Method not implemented.');
	}
	protected setMainArgumentsMapValues(argumentsMap: IArgumentsMap): void {
		throw new Error('Method not implemented.');
	}
}

export { DefaultSolutionFileService };