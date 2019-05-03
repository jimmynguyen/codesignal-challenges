import { sprintf } from 'sprintf-js';

import { TestCase } from '../../entity/TestCase';
import { TestCaseArgument } from '../../entity/TestCaseArgument';
import { IArgumentsMap } from '../../interface/solution/IArgumentsMap';
import { IStringFormatArgumentsMap } from '../../interface/solution/IStringFormatArgumentsMap';
import { IJavaScriptArgumentsMap } from '../../interface/solution/js/IJavaScriptArgumentsMap';
import { IJavaScriptStringFormatArgumentsMap } from '../../interface/solution/js/IJavaScriptStringFormatArgumentsMap';
import { FileService } from '../FileService';

class JavaScriptSolutionFileService extends FileService {
	protected getMainArgumentsMap(): IArgumentsMap {
		const argumentsMap: IJavaScriptArgumentsMap = {
			METHOD_NAME: this.challenge.getName(),
			TEST_OUTPUTS: '',
			ACTUAL_EXPECTED_COMPARISON: '',
			TEST_INPUTS: '',
			NUM_TESTS_ASSERTION: '',
			METHOD_ARGS: '',
			METHOD_ARGS_DEFINITION: '',
			FUNCTION_IMPORTS: '',
			METHOD_ARGS_STRING_FORMAT_VALUES: ''
		};
		this.setMainArgumentsMapValues(argumentsMap);
		return argumentsMap;
	}
	protected getStringFormatArgumentsMap(): IStringFormatArgumentsMap {
		const map: IJavaScriptStringFormatArgumentsMap = {
			DEFAULT: {
				type: 'default',
				format: '%s'
			}
		}
		return map;
	}
	protected getTestCaseArgumentValue(testCaseArgument: TestCaseArgument): string {
		switch (testCaseArgument.getType()) {
			default:
				return testCaseArgument.getValue();
		}
	}
	protected setMainArgumentsMapValues(argumentsMap: IArgumentsMap): void {
		let delimiter: string;
		let isLastIteration: boolean;
		let functionImports: string[] = [];
		const testCases: TestCase[] = this.challenge.getTestCases();
		const numInputs = testCases[0].getInputs().length;
		for (let index = 0; index < numInputs; index++) {
			isLastIteration = index == numInputs - 1;
			delimiter = isLastIteration ? '' : '\n\t';
			this.setTestInputs(argumentsMap, testCases, index, delimiter);
			this.setNumTestsAssertion(argumentsMap, index, delimiter);
			delimiter = isLastIteration ? '' : ', ';
			this.setMethodArgs(argumentsMap, index, delimiter);
			this.setMethodArgsDefinition(argumentsMap, index, delimiter);
			this.setMethodArgsStringFormatValues(argumentsMap, index, delimiter);
		}
		this.setTestOutputs(argumentsMap, testCases);
		this.setActualExpectedComparison(argumentsMap, functionImports);
		this.setFunctionImports(argumentsMap, functionImports);
	}
	protected setTestInputs(argumentsMap: IArgumentsMap, testCases: TestCase[], index: number, delimiter: string) {
		argumentsMap.TEST_INPUTS += sprintf('const input%d = [%s];%s', index, testCases.map(testCase => this.getTestCaseArgumentValue(testCase.getInputs()[index])).join(', '), delimiter);
	}
	protected setNumTestsAssertion(argumentsMap: IArgumentsMap, index: number, delimiter: string) {
		argumentsMap.NUM_TESTS_ASSERTION += sprintf('console.assert(input%d.length == expectedOutput.length, `# input%d = ${input%d.length}, # expectedOutput = ${expectedOutput.length}`);%s', index, index, index, delimiter);
	}
	protected setMethodArgs(argumentsMap: IArgumentsMap, index: number, delimiter: string) {
		argumentsMap.METHOD_ARGS += sprintf('input%d[i]%s', index, delimiter);
	}
	protected setMethodArgsDefinition(argumentsMap: IArgumentsMap, index: number, delimiter: string) {
		argumentsMap.METHOD_ARGS_DEFINITION += sprintf('input%d%s', index, delimiter);
	}
	protected setMethodArgsStringFormatValues(argumentsMap: IArgumentsMap, index: number, delimiter: string) {
		argumentsMap.METHOD_ARGS_STRING_FORMAT_VALUES += sprintf('${JSON.stringify(input%d)}%s', index, delimiter);
	}
	protected setTestOutputs(argumentsMap: IArgumentsMap, testCases: TestCase[]) {
		argumentsMap.TEST_OUTPUTS += testCases.map(testCase => this.getTestCaseArgumentValue(testCase.getOutput())).join(', ');
	}
	protected setActualExpectedComparison(argumentsMap: IArgumentsMap, functionImports: string[]): void {
		const outputType: string = this.challenge.getTestCases()[0].getOutput().getType();
		if (this.isArray(outputType)) {
			argumentsMap.ACTUAL_EXPECTED_COMPARISON = 'arraysEqual(actualOutput, expectedOutput[i])';
			functionImports.push('arraysEqual');
		} else {
			argumentsMap.ACTUAL_EXPECTED_COMPARISON = 'actualOutput == expectedOutput[i]';
		}
	}
	protected setFunctionImports(argumentsMap: IArgumentsMap, functionImports: string[]): void {
		if (functionImports.length == 0) {
			return;
		}
		let uniqueFunctionImports: string[] = [];
		for (let functionImport of functionImports) {
			if (!uniqueFunctionImports.includes(functionImport)) {
				uniqueFunctionImports.push(functionImport);
			}
		}
		argumentsMap.FUNCTION_IMPORTS += sprintf('\n%s\n', uniqueFunctionImports.sort().map((x) => this.readFile(sprintf('%sfunctions/%s.%s', this.resourcesDirPath, x, this.challenge.getLanguage().fileExtension))).join('\n'));
	}
}

export { JavaScriptSolutionFileService };