import { IArgumentsMap } from '../IArgumentsMap';

interface IJavaArgumentsMap extends IArgumentsMap {
	CLASS_NAME: string;
	TEST_INPUTS: string;
	OUTPUT_TYPE: string;
	TEST_OUTPUTS: string;
	NUM_TESTS_ASSERTION: string;
	METHOD_NAME: string;
	METHOD_ARGS: string;
	ACTUAL_EXPECTED_COMPARISON: string;
	METHOD_ARGS_STRING_FORMAT_TEMPLATE: string;
	OUTPUT_TYPE_STRING_FORMAT_TEMPLATE: string;
	METHOD_ARGS_STRING_FORMAT_VALUES: string;
	METHOD_ARGS_DEFINITION: string;
	ACTUAL_OUTPUT_STRING_FORMAT_VALUE: string;
	EXPECTED_OUTPUT_STRING_FORMAT_VALUE: string;
	IMPORTS: string;
}

export { IJavaArgumentsMap };