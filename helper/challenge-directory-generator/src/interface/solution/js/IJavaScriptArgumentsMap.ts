import { IArgumentsMap } from '../IArgumentsMap';

interface IJavaScriptArgumentsMap extends IArgumentsMap {
	TEST_INPUTS: string;
	TEST_OUTPUTS: string;
	NUM_TESTS_ASSERTION: string;
	METHOD_NAME: string;
	METHOD_ARGS: string;
	ACTUAL_EXPECTED_COMPARISON: string;
	METHOD_ARGS_STRING_FORMAT_VALUES: string;
	FUNCTION_IMPORTS: string;
	METHOD_ARGS_DEFINITION: string;
}

export { IJavaScriptArgumentsMap };