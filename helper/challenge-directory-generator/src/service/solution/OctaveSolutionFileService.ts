import { sprintf } from 'sprintf-js';

import { TestCase } from '../../entity/TestCase';
import { TestCaseArgument } from '../../entity/TestCaseArgument';
import { IArgumentsMap } from '../../interface/solution/IArgumentsMap';
import { IStringFormatArgumentsMap } from '../../interface/solution/IStringFormatArgumentsMap';
import { IOctaveArgumentsMap } from '../../interface/solution/octave/IOctaveArgumentsMap';
import { IOctaveStringFormatArgumentsMap } from '../../interface/solution/octave/IOctaveStringFormatArgumentsMap';
import { FileService } from '../FileService';

class OctaveSolutionFileService extends FileService {
	protected getMainArgumentsMap(): IArgumentsMap {
		const challengeName: string = this.challenge.getName();
		const testCases: TestCase[] = this.challenge.getTestCases();
		const argumentsMap: IOctaveArgumentsMap = {
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
		this.setMainArgumentsMapValues(argumentsMap);
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
		const map: IOctaveStringFormatArgumentsMap = {
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
			INT_ARRAY_ARRAY: {
				type: 'int[][]',
				format: '%s'
			}
		};
		return map;
	}
	protected getTestCaseArgumentValue(testCaseArgument: TestCaseArgument): string {
		switch (testCaseArgument.getType()) {
			case this.getStringFormatArgumentsMap().INT_ARRAY_ARRAY.type:
				let value = testCaseArgument.getValue();
				return sprintf('{%s}', value.substring(1, value.length-1));
			default:
				return testCaseArgument.getValue();
		}
	}
	protected setMainArgumentsMapValues(argumentsMap: IArgumentsMap): void {
		return;
	}
}

export { OctaveSolutionFileService };