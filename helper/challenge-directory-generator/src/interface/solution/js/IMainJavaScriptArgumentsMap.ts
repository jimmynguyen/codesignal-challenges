import { IMainArgumentsMap } from '../IMainArgumentsMap';

interface IMainJavaScriptArgumentsMap extends IMainArgumentsMap {
	TEST_INPUTS: string;
	TEST_OUTPUTS: string;
	NUM_TESTS_ASSERTION: string;
	METHOD_NAME: string;
	METHOD_ARGS: string;
	METHOD_ARGS_DEFINITION: string;
	FUNCTION_IMPORTS: string;
}

export { IMainJavaScriptArgumentsMap };