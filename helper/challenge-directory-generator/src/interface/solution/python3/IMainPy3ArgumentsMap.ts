import { IMainArgumentsMap } from '../IMainArgumentsMap';

interface IMainPy3ArgumentsMap extends IMainArgumentsMap {
    METHOD_NAME: string;
	METHOD_ARGS_DEFINITION: string;
	TEST_INPUTS: string;
	TEST_OUTPUTS: string;
	NUM_TESTS_ASSERTION: string;
	METHOD_ARGS: string;
	METHOD_ARGS_STRING_FORMAT_TEMPLATE: string;
	METHOD_ARGS_STRING_FORMAT_VALUES: string;
}

export { IMainPy3ArgumentsMap };