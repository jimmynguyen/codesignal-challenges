import { sprintf } from 'sprintf-js';

import { TestCase } from '../../entity/TestCase';
import { IArgumentsMap } from '../../interface/solution/IArgumentsMap';
import { ITypeScriptArgumentsMap } from '../../interface/solution/typescript/ITypeScriptArgumentsMap';
import { ErrorService } from '../ErrorService';
import { JavaScriptSolutionFileService } from './JavaScriptSolutionFileService';

class TypeScriptSolutionFileService extends JavaScriptSolutionFileService {
	protected getMainArgumentsMap(): IArgumentsMap {
		const argumentsMap: ITypeScriptArgumentsMap = <ITypeScriptArgumentsMap> super.getMainArgumentsMap();
		argumentsMap.OUTPUT_TYPE = this.getTypeScriptTypeFromJavaType(this.challenge.getTestCases()[0].getOutput().getType());
		return argumentsMap;
	}
	protected setTestInputs(argumentsMap: IArgumentsMap, testCases: TestCase[], index: number, delimiter: string) {
		argumentsMap.TEST_INPUTS += sprintf('const input%d: %s[] = [%s];%s', index, this.getTypeScriptTypeFromJavaType(testCases[0].getInputs()[index].getType()), testCases.map(testCase => this.getTestCaseArgumentValue(testCase.getInputs()[index])).join(', '), delimiter);
	}
	protected setMethodArgsDefinition(argumentsMap: IArgumentsMap, index: number, delimiter: string) {
		argumentsMap.METHOD_ARGS_DEFINITION += sprintf('input%d: %s%s', index, this.getTypeScriptTypeFromJavaType(this.challenge.getTestCases()[0].getInputs()[index].getType()), delimiter);
	}
	private getTypeScriptTypeFromJavaType(javaType: string) {
		const isArray: boolean = this.isArray(javaType);
		if (isArray) {
			javaType = javaType.substring(0, javaType.length - 2);
		}
		let tsType: string = '';
		switch (javaType) {
			case 'int':
			case 'long':
			case 'double':
				tsType = 'number';
				break;
			case 'int[]':
				tsType = this.getTypeScriptTypeFromJavaType(javaType);
				break
			case 'String':
				tsType = 'string';
				break;
			default:
				ErrorService.throw(ErrorService.ERRORS.TYPE_NOT_IMPLEMENTED, sprintf('%s[]', javaType));
		}
		return sprintf('%s%s', tsType, isArray ? '[]' : '');
	}
}

export { TypeScriptSolutionFileService };