import { sprintf } from 'sprintf-js';

import { IArgumentsMap } from '../../interface/solution/IArgumentsMap';
import { JavaScriptSolutionFileService } from './JavaScriptSolutionFileService';
import { TestCase } from '../../entity/TestCase';

class CoffeeScriptSolutionFileService extends JavaScriptSolutionFileService {
	protected setTestInputs(argumentsMap: IArgumentsMap, testCases: TestCase[], index: number, delimiter: string) {
		argumentsMap.TEST_INPUTS += sprintf('input%d = [%s]%s', index, testCases.map(testCase => this.getTestCaseArgumentValue(testCase.getInputs()[index])).join(', '), delimiter);
	}
	protected setNumTestsAssertion(argumentsMap: IArgumentsMap, index: number, delimiter: string) {
		argumentsMap.NUM_TESTS_ASSERTION += sprintf('console.assert input%d.length == expectedOutput.length, "# input%d = #{input%d.length}, # expectedOutput = #{expectedOutput.length}"%s', index, index, index, delimiter);
	}
	protected setMethodArgsStringFormatValues(argumentsMap: IArgumentsMap, index: number, delimiter: string) {
		argumentsMap.METHOD_ARGS_STRING_FORMAT_VALUES += sprintf('#{JSON.stringify input%d}%s', index, delimiter);
	}
}

export { CoffeeScriptSolutionFileService };