import { ISolutionFileService } from '../interface/ISolutionFileService';
import { Challenge } from '../entity/Challenge';
import * as fs from 'fs';
import { FileService } from './FileService';
import { sprintf } from 'sprintf-js';
import { IMainJavaArgumentsMap } from '../interface/java/IMainJavaArgumentsMap';
import { IJavaStringFormatArgumentsMap } from '../interface/java/IJavaStringFormatArgumentsMap';
import { IJavaStringFormatArgument } from '../interface/java/IJavaStringFormatArgument';
import { TestCase } from '../entity/TestCase';

class JavaSolutionFileService implements ISolutionFileService {
	private JAVA_STRING_FORMAT_ARGUMENTS_MAP: IJavaStringFormatArgumentsMap = {
		DEFAULT: {
			type: 'default',
			format: '%s'
		},
		STRING: {
			type: 'String',
			format: '%s'
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
	private challenge: Challenge;
	private challengeDirPath: string;
	private templatesDirPath: string;
	constructor(challenge: Challenge, challengeDirPath: string) {
		this.challenge = challenge;
		this.challengeDirPath = challengeDirPath;
		this.templatesDirPath = sprintf('%sjava/', FileService.TEMPLATES_DIR_PATH);
	}
	public createSolutionFiles(): void {
		this.createMainJavaFile();
	}
	private createMainJavaFile(): void {
		const mainJavaTemplateFilePath: string = sprintf('%sMain.java', this.templatesDirPath);
		let mainJavaFile: string = fs.readFileSync(mainJavaTemplateFilePath, 'utf8');
		const argumentsMap: IMainJavaArgumentsMap = this.getMainJavaArgumentsMap();
		mainJavaFile = this.replaceMainJavaArguments(mainJavaFile, argumentsMap);
		const mainJavaFilePath: string = sprintf('%s%s.java', this.challengeDirPath, this.challenge.getName().toPascalCase());
		fs.writeFileSync(mainJavaFilePath, mainJavaFile);
	}
	private replaceMainJavaArguments(mainJavaFile: string, argumentsMap: IMainJavaArgumentsMap): string {
		for (const argument in argumentsMap) {
			mainJavaFile = mainJavaFile.split(sprintf('[%s]', argument)).join(argumentsMap[argument]);
		}
		return mainJavaFile;
	}
	private getMainJavaArgumentsMap(): IMainJavaArgumentsMap {
		const challengeName: string = this.challenge.getName();
		const outputType: string = this.challenge.getTestCases()[0].getOutput().getType();
		const testCases: TestCase[] = this.challenge.getTestCases();
		const argumentsMap: IMainJavaArgumentsMap = {
			CLASS_NAME: challengeName.toPascalCase(),
			OUTPUT_TYPE: outputType,
			METHOD_NAME: challengeName,
			ACTUAL_EXPECTED_COMPARISON: outputType.charAt(0) == outputType.charAt(0).toUpperCase() ? 'actualOutput.equals(expectedOutput[i])' : 'actualOutput == expectedOutput[i]',
			OUTPUT_TYPE_STRING_FORMAT_TEMPLATE: this.getStringFormat(outputType),
			TEST_OUTPUTS: testCases.map(testCase => testCase.getOutput().getValue()).join(', '),
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
			argumentsMap.TEST_INPUTS += sprintf('%s[] input%d = new %s[] {%s};%s', inputType, index, inputType, testCases.map(testCase => testCase.getInputs()[index].getValue()).join(', '), delimiter);
			argumentsMap.NUM_TESTS_ASSERTION += sprintf('assert input%d.length == expectedOutput.length : String.format("# input%d = %%d, # expectedOutput = %%d", input%d.length, expectedOutput.length);%s', index, index, index, delimiter);
			delimiter = isLastIteration ? '' : ', ';
			argumentsMap.METHOD_ARGS += sprintf('input%d[i]%s', index, delimiter);
			argumentsMap.METHOD_ARGS_STRING_FORMAT_TEMPLATE += sprintf('\\"%s\\"%s', this.getStringFormat(inputType), delimiter);
			argumentsMap.METHOD_ARGS_STRING_FORMAT_VALUES += sprintf('input%d[i]%s', index, delimiter);
			argumentsMap.METHOD_ARGS_DEFINITION += sprintf('%s input%d%s', inputType, index, delimiter);
		}
		return argumentsMap;
	}
	private getStringFormat(type: string): string {
		for (const key in this.JAVA_STRING_FORMAT_ARGUMENTS_MAP) {
			const stringFormatArgument: IJavaStringFormatArgument = this.JAVA_STRING_FORMAT_ARGUMENTS_MAP[key];
			if (stringFormatArgument.type == type) {
				return stringFormatArgument.format;
			}
		}
		return this.JAVA_STRING_FORMAT_ARGUMENTS_MAP.DEFAULT.format;
	}
}

export { JavaSolutionFileService };