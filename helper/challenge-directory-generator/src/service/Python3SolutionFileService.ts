import { Challenge } from '../entity/Challenge';
import { FileService } from './FileService';
import { sprintf } from 'sprintf-js';
import { TestCase } from '../entity/TestCase';
import { IMainPy3ArgumentsMap } from '../interface/python3/IMainPy3ArgumentsMap';
import { IMainArgumentsMap } from '../interface/IMainArgumentsMap';
import { IPython3StringFormatArgumentsMap } from '../interface/python3/IPython3StringFormatArgumentsMap';
import { IStringFormatArgumentsMap } from '../interface/IStringFormatArgumentsMap';

class Python3SolutionFileService extends FileService {
	private PYTHON3_STRING_FORMAT_ARGUMENTS_MAP: IPython3StringFormatArgumentsMap = {
		DEFAULT: {
			type: 'default',
			format: '{}'
		},
		STRING: {
			type: 'String',
			format: '\\\'%s\\\''
		}
	};
	protected templatesDirPath: string;
	constructor(challenge: Challenge) {
		super(challenge);
		this.templatesDirPath = sprintf('%spython3/', this.TEMPLATES_DIR_PATH);
	}
	protected getChallengeTestBashFile(): string {
		return sprintf('python3 %s.py', this.challenge.getName());
	}
	protected createChallengeSolutionFiles(): void {
		this.createMainSolutionFile('main.py.txt', sprintf('%s.py', this.challenge.getName()));
	}
	protected getMainArgumentsMap(): IMainArgumentsMap {
		const challengeName: string = this.challenge.getName();
		const testCases: TestCase[] = this.challenge.getTestCases();
		const argumentsMap: IMainPy3ArgumentsMap = {
			METHOD_NAME: challengeName,
			TEST_OUTPUTS: testCases.map(testCase => testCase.getOutput().getValue()).join(', '),
			METHOD_ARGS_DEFINITION: '',
			METHOD_ARGS: '',
			METHOD_ARGS_STRING_FORMAT_TEMPLATE: '',
			METHOD_ARGS_STRING_FORMAT_VALUES: '',
			TEST_INPUTS: '',
			NUM_TESTS_ASSERTION: ''
		};
		const inputTypes: string[] = testCases[0].getInputs().map(input => input.getType());
		let delimiter: string;
		let isLastIteration: boolean;
		for (const [index, inputType] of inputTypes.entries()) {
			isLastIteration = index == inputTypes.length - 1;
			delimiter = isLastIteration ? '' : '\n\t';
			argumentsMap.TEST_INPUTS += sprintf('input%d = [%s]%s', index, testCases.map(testCase => testCase.getInputs()[index].getValue()).join(', '), delimiter);
			argumentsMap.NUM_TESTS_ASSERTION += sprintf('assert len(input%d) == len(expectedOutput), \'# input%d = \{\}, # expectedOutput = \{\}\'.format(len(input%d), len(expectedOutput))%s', index, index, index, delimiter);
			delimiter = isLastIteration ? '' : ', ';
			argumentsMap.METHOD_ARGS += sprintf('input%d[i]%s', index, delimiter);
			argumentsMap.METHOD_ARGS_STRING_FORMAT_TEMPLATE += sprintf('%s%s', this.getStringFormat(inputType), delimiter);
			argumentsMap.METHOD_ARGS_STRING_FORMAT_VALUES += sprintf('input%s[i]%s', index, delimiter);
			argumentsMap.METHOD_ARGS_DEFINITION += sprintf('input%s%s', index, delimiter);
		}
		return argumentsMap;
	}
	protected getStringFormatArgumentsMap(): IStringFormatArgumentsMap {
		return this.PYTHON3_STRING_FORMAT_ARGUMENTS_MAP;
	}
}

export { Python3SolutionFileService };