import { sprintf } from 'sprintf-js';

import { TestCase } from '../../entity/TestCase';
import { ICPlusPlusArgumentsMap } from '../../interface/solution/c++/ICPlusPlusArgumentsMap';
import { IArgumentsMap } from '../../interface/solution/IArgumentsMap';
import { ErrorService } from '../ErrorService';
import { JavaSolutionFileService } from './JavaSolutionFileService';

class CPlusPlusSolutionFileService extends JavaSolutionFileService {
	private functionImports: string[] = [];
	protected importTemplateString: string = '#include <%s>\n';
	protected getChallengeTestBashFileParameter(): string {
		return this.challenge.getName();
	}
	protected getMainSolutionFileName(): string {
		return this.challenge.getName();
	}
	protected getMainArgumentsMap(): IArgumentsMap {
		this.functionImports = [];
		let argumentsMap: ICPlusPlusArgumentsMap = <ICPlusPlusArgumentsMap> super.getMainArgumentsMap();
		this.setFunctionImports(argumentsMap, this.functionImports);
		return argumentsMap;
	}
	protected initializeImports(): string[] {
		return ['iostream', 'sstream', 'string', 'vector'];
	}
	protected setFunctionImports(argumentsMap: IArgumentsMap, functionImports: string[]): void {
		argumentsMap.FUNCTION_IMPORTS = '';
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
	protected setOutputType(argumentsMap: IArgumentsMap) {
		argumentsMap.OUTPUT_TYPE = this.getCPlusPlusTypeFromJavaType(this.challenge.getTestCases()[0].getOutput().getType());
	}
	protected setTestInputs(argumentsMap: IArgumentsMap, inputType: string, testCases: TestCase[], index: number, delimiter: string) {
		if (delimiter.length > 0) {
			delimiter = '\n\t';
		}
		argumentsMap.TEST_INPUTS += sprintf('std::vector<%s> input%d{%s};%s', this.getCPlusPlusTypeFromJavaType(inputType), index, testCases.map(testCase => this.getTestCaseArgumentValue(testCase.getInputs()[index])).join(', '), delimiter);
	}
	protected setNumTestsAssertion(argumentsMap: IArgumentsMap, index: number, delimiter: string) {
		argumentsMap.NUM_TESTS_ASSERTION += sprintf('sprintf(message, "# input%d = %%d, # expectedOutput = %%d", (int)input%d.size(), (int)expectedOutput.size());\n\tcustom_assert(input%d.size() == expectedOutput.size(), std::string(message));%s', index, index, index, delimiter);
	}
	protected setMethodArgsDefinition(argumentsMap: IArgumentsMap, inputType: string, index: number, delimiter: string) {
		argumentsMap.METHOD_ARGS_DEFINITION += sprintf('%s input%d%s', this.getCPlusPlusTypeFromJavaType(inputType), index, delimiter);
	}
	protected setActualExpectedComparison(argumentsMap: IArgumentsMap, imports: string[]): void {
		argumentsMap.ACTUAL_EXPECTED_COMPARISON = 'actualOutput == expectedOutput[i]';
	}
	protected getStringFormatValue(type: string, variable: string, imports: string[]): string {
		if (this.isArray(type)) {
			this.functionImports.push('vector_to_c_str');
			return sprintf('vector_to_c_str(%s)', variable);
		} else {
			return variable;
		}
	}
	private getCPlusPlusTypeFromJavaType(javaType: string) {
		const isArray: boolean = this.isArray(javaType);
		if (isArray) {
			javaType = javaType.substring(0, javaType.length - 2);
		}
		let cppType: string = '';
		switch (javaType) {
			case 'int':
			case 'long':
			case 'double':
				cppType = javaType;
				break;
			case 'String':
				cppType = 'string';
				break;
			default:
				ErrorService.throw(ErrorService.ERRORS.TYPE_NOT_IMPLEMENTED, javaType);
		}
		if (isArray) {
			cppType = sprintf('std::vector<%s>', cppType);
		}
		return cppType;
	}
}

export { CPlusPlusSolutionFileService };