import { IMainArgumentsMap } from '../IMainArgumentsMap';

interface IMainJavaArgumentsMap extends IMainArgumentsMap {
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
}

export { IMainJavaArgumentsMap };