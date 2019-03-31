import { FileService } from './FileService';
import { Challenge } from '../entity/Challenge';
import { sprintf } from 'sprintf-js';
import { IMainArgumentsMap } from '../interface/IMainArgumentsMap';
import { IStringFormatArgumentsMap } from '../interface/IStringFormatArgumentsMap';
import { IOctaveStringFormatArgumentsMap } from '../interface/octave/IOctaveStringFormatArgumentsMap';
import { TestCaseArgument } from '../entity/TestCaseArgument';
import { TestCase } from '../entity/TestCase';
import { IMainMArgumentsMap } from '../interface/octave/IMainMArgumentsMap';

class OctaveSolutionFileService extends FileService {
	private OCTAVE_STRING_FORMAT_ARGUMENTS_MAP: IOctaveStringFormatArgumentsMap = {
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
		}
	};
	protected templatesDirPath: string;
	constructor(challenge: Challenge) {
		super(challenge);
		this.templatesDirPath = sprintf('%soctave/', this.TEMPLATES_DIR_PATH);
	}
	protected getChallengeTestBashFile(): string {
		return sprintf('octave --eval "test %s"', this.challenge.getName());
	}
	protected createChallengeSolutionFiles(): void {
		this.createMainSolutionFile('main.m.txt', sprintf('%s.m', this.challenge.getName()));
	}
	protected getMainArgumentsMap(): IMainArgumentsMap {
		const challengeName: string = this.challenge.getName();
		const testCases: TestCase[] = this.challenge.getTestCases();
		const argumentsMap: IMainMArgumentsMap = {
			METHOD_NAME: challengeName,
			METHOD_ARGS_DEFINITION: '',
			TESTS: ''
		};
		let delimiter: string;
		let isLastIteration: boolean;
		for (let index = 0; index < testCases[0].getInputs().length; index++) {
			isLastIteration = index == testCases[0].getInputs().length - 1;
			delimiter = isLastIteration ? '' : ', ';
			argumentsMap.METHOD_ARGS_DEFINITION += sprintf('input%d%s', index, delimiter);
		}
		for (const [index, testCase] of testCases.entries()) {
			isLastIteration = index == testCases.length - 1;
			delimiter = isLastIteration ? '' : '\n';
			argumentsMap.TESTS += sprintf('%%!assert(%s(%s), %s)%s', challengeName, this.getMethodArgsStringFormatValues(testCase), this.getTestCaseArgumentValue(testCase.getOutput()), delimiter);
		}
		return argumentsMap;
	}
	private getMethodArgsStringFormatValues(testCase: TestCase): string {
		let methodArgsStringFormatValues: string = '';
		let delimiter: string;
		let isLastIteration: boolean;
		for (const [index, input] of testCase.getInputs().entries()) {
			isLastIteration = index == testCase.getInputs().length - 1;
			delimiter = isLastIteration ? '' : ', ';
			methodArgsStringFormatValues += sprintf('%s%s', this.getTestCaseArgumentValue(input), delimiter);
		}
		return methodArgsStringFormatValues;
	}
	protected getStringFormatArgumentsMap(): IStringFormatArgumentsMap {
		return this.OCTAVE_STRING_FORMAT_ARGUMENTS_MAP;
	}
	protected getTestCaseArgumentValue(testCaseArgument: TestCaseArgument): string {
		switch (testCaseArgument.getType()) {
			default:
				return testCaseArgument.getValue();
		}
	}
}

export { OctaveSolutionFileService };