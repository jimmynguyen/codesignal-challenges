import { sprintf } from 'sprintf-js';

import { IMainArgumentsMap } from '../../interface/solution/IMainArgumentsMap';
import { JavaScriptSolutionFileService } from './JavaScriptSolutionFileService';
import { TestCase } from '../../entity/TestCase';

class CoffeeScriptSolutionFileService extends JavaScriptSolutionFileService {
	protected setTestInputs(argumentsMap: IMainArgumentsMap, testCases: TestCase[], index: number, delimiter: string) {
		argumentsMap.TEST_INPUTS += sprintf('input%d = [%s]%s', index, testCases.map(testCase => this.getTestCaseArgumentValue(testCase.getInputs()[index])).join(', '), delimiter);
	}
	protected setNumTestsAssertion(argumentsMap: IMainArgumentsMap, index: number, delimiter: string) {
		argumentsMap.NUM_TESTS_ASSERTION += sprintf('console.assert input%d.length == expectedOutput.length, "# input%d = #{input%d.length}, # expectedOutput = #{expectedOutput.length}"%s', index, index, index, delimiter);
	}
	protected setMethodArgsStringFormatValues(argumentsMap: IMainArgumentsMap, index: number, delimiter: string) {
		argumentsMap.METHOD_ARGS_STRING_FORMAT_VALUES += sprintf('#{input%d}%s', index, delimiter);
	}
}

export { CoffeeScriptSolutionFileService };