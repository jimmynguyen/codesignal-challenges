import { sprintf } from 'sprintf-js';

import { TestCaseArgument } from '../../entity/TestCaseArgument';
import { IArgumentsMap } from '../../interface/solution/IArgumentsMap';
import { JavaSolutionFileService } from './JavaSolutionFileService';

class CSharpSolutionFileService extends JavaSolutionFileService {
	protected importTemplateString: string = 'using %s;\n';
	protected initializeImports(): string[] {
		return ['System', 'System.Diagnostics'];
	}
	protected setNumTestsAssertion(argumentsMap: IArgumentsMap, index: number, delimiter: string) {
		argumentsMap.NUM_TESTS_ASSERTION += sprintf('Assert(input%d.Length == expectedOutput.Length, String.Format("# input%d = {0}, # expectedOutput = {1}", input%d.Length, expectedOutput.Length));%s', index, index, index, delimiter);
	}
	protected setActualOutputStringFormatTemplate(argumentsMap: IArgumentsMap, outputType: string, numInputs: number): void {
		argumentsMap.ACTUAL_OUTPUT_STRING_FORMAT_TEMPLATE += sprintf('{%d}', numInputs);
	}
	protected setExpectedOutputStringFormatTemplate(argumentsMap: IArgumentsMap, outputType: string, numInputs: number): void {
		argumentsMap.EXPECTED_OUTPUT_STRING_FORMAT_TEMPLATE += sprintf('{%d}', numInputs + 1);
	}
	protected setActualExpectedComparison(argumentsMap: IArgumentsMap, imports: string[]): void {
		const outputType: string = this.challenge.getTestCases()[0].getOutput().getType();
		if (this.isArray(outputType)) {
			argumentsMap.ACTUAL_EXPECTED_COMPARISON = 'actualOutput.SequenceEqual(expectedOutput[i])';
			imports.push('System.Linq');
		} else {
			argumentsMap.ACTUAL_EXPECTED_COMPARISON = 'actualOutput == expectedOutput[i]';
		}
	}
	protected getStringFormatValue(type: string, variable: string, imports: string[]): string {
		if (this.isArray(type)) {
			return sprintf('String.Format("[{0}]", String.Join(", ", %s))', variable);
		} else {
			return variable;
		}
	}
	protected getTestCaseArgumentValue(testCaseArgument: TestCaseArgument): string {
		switch (testCaseArgument.getType()) {
			case this.getStringFormatArgumentsMap().INT_ARRAY.type:
				return sprintf('new int[] %s', testCaseArgument.getValue().replace('[', '{').replace(']', '}'));
			default:
				return testCaseArgument.getValue();
		}
	}
	protected setMethodArgsStringFormatTemplate(argumentsMap: IArgumentsMap, inputType: string, index: number, delimiter: string) {
		argumentsMap.METHOD_ARGS_STRING_FORMAT_TEMPLATE += sprintf('{%d}%s', index, delimiter);
	}	
}

export { CSharpSolutionFileService };