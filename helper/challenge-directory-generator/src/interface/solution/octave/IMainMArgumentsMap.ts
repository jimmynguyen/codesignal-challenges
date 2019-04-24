import { IMainArgumentsMap } from '../IMainArgumentsMap';

interface IMainMArgumentsMap extends IMainArgumentsMap {
    METHOD_NAME: string;
	METHOD_ARGS_DEFINITION: string;
	TESTS: string;
}

export { IMainMArgumentsMap };