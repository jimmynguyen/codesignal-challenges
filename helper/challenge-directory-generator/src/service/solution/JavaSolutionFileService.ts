import { sprintf } from 'sprintf-js';

import { Challenge } from '../../entity/Challenge';
import { TestCase } from '../../entity/TestCase';
import { TestCaseArgument } from '../../entity/TestCaseArgument';
import { IMainArgumentsMap } from '../../interface/solution/IMainArgumentsMap';
import { IStringFormatArgumentsMap } from '../../interface/solution/IStringFormatArgumentsMap';
import { IJavaStringFormatArgumentsMap } from '../../interface/solution/java/IJavaStringFormatArgumentsMap';
import { IMainJavaArgumentsMap } from '../../interface/solution/java/IMainJavaArgumentsMap';
import { FileService } from '../FileService';

class JavaSolutionFileService extends FileService {
	private JAVA_STRING_FORMAT_ARGUMENTS_MAP: IJavaStringFormatArgumentsMap = {
		DEFAULT: {
			type: 'default',
			format: '%s'
		},
		STRING: {
			type: 'String',
			format: '\\"%s\\"'
		},
		INT: {
			type: 'int',
			format: '%d'
		},
		DOUBLE: {
			type: 'double',
			format: '%f'
		},
		BOOLEAN: {
			type: 'boolean',
			format: '%b'
		},
		INT_ARRAY: {
			type: 'int[]',
			format: '%s'
		}
	};
	protected templatesDirPath: string;
	constructor(challenge: Challenge) {
		super(challenge);
		this.templatesDirPath = sprintf('%sjava/', this.TEMPLATES_DIR_PATH);
	}
	protected getChallengeTestBashFile(): string {
		return sprintf('javac %s.java && java -ea %s', this.challenge.getName().toPascalCase(), this.challenge.getName().toPascalCase());
	}
	protected createChallengeSolutionFiles(): void {
		this.createMainSolutionFile('Main.java', sprintf('%s.java', this.challenge.getName().toPascalCase()));
	}
	protected getMainArgumentsMap(): IMainArgumentsMap {
		const challengeName: string = this.challenge.getName();
		const outputType: string = this.challenge.getTestCases()[0].getOutput().getType();
		const testCases: TestCase[] = this.challenge.getTestCases();
		const argumentsMap: IMainJavaArgumentsMap = {
			CLASS_NAME: challengeName.toPascalCase(),
			OUTPUT_TYPE: outputType,
			METHOD_NAME: challengeName,
			ACTUAL_EXPECTED_COMPARISON: outputType.charAt(0) == outputType.charAt(0).toUpperCase() ? 'actualOutput.equals(expectedOutput[i])' : 'actualOutput == expectedOutput[i]',
			OUTPUT_TYPE_STRING_FORMAT_TEMPLATE: this.getStringFormat(outputType),
			TEST_OUTPUTS: testCases.map(testCase => this.getTestCaseArgumentValue(testCase.getOutput())).join(', '),
			TEST_INPUTS: '',
			NUM_TESTS_ASSERTION: '',
			METHOD_ARGS: '',
			METHOD_ARGS_STRING_FORMAT_TEMPLATE: '',
			METHOD_ARGS_STRING_FORMAT_VALUES: '',
			METHOD_ARGS_DEFINITION: ''
		};
		const inputTypes: string[] = testCases[0].getInputs().map(input => input.getType());
		let delimiter: string;
		let isLastIteration: boolean;
		for (const [index, inputType] of inputTypes.entries()) {
			isLastIteration = index == inputTypes.length - 1;
			delimiter = isLastIteration ? '' : '\n\t\t';
			argumentsMap.TEST_INPUTS += sprintf('%s[] input%d = new %s[] {%s};%s', inputType, index, inputType, testCases.map(testCase => this.getTestCaseArgumentValue(testCase.getInputs()[index])).join(', '), delimiter);
			argumentsMap.NUM_TESTS_ASSERTION += sprintf('assert input%d.length == expectedOutput.length : String.format("# input%d = %%d, # expectedOutput = %%d", input%d.length, expectedOutput.length);%s', index, index, index, delimiter);
			delimiter = isLastIteration ? '' : ', ';
			argumentsMap.METHOD_ARGS += sprintf('input%d[i]%s', index, delimiter);
			argumentsMap.METHOD_ARGS_STRING_FORMAT_TEMPLATE += sprintf('%s%s', this.getStringFormat(inputType), delimiter);
			argumentsMap.METHOD_ARGS_STRING_FORMAT_VALUES += sprintf('input%d[i]%s', index, delimiter);
			argumentsMap.METHOD_ARGS_DEFINITION += sprintf('%s input%d%s', inputType, index, delimiter);
		}
		return argumentsMap;
	}
	protected getStringFormatArgumentsMap(): IStringFormatArgumentsMap {
		return this.JAVA_STRING_FORMAT_ARGUMENTS_MAP;
	}
	protected getTestCaseArgumentValue(testCaseArgument: TestCaseArgument): string {
		switch (testCaseArgument.getType()) {
			case this.JAVA_STRING_FORMAT_ARGUMENTS_MAP.INT_ARRAY.type:
				return testCaseArgument.getValue().replace('[', '{').replace(']', '}');
			default:
				return testCaseArgument.getValue();
		}
	}
}

export { JavaSolutionFileService };