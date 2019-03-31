import { IStringFormatArgumentsMap } from '../IStringFormatArgumentsMap';
import { IStringFormatArgument } from '../IStringFormatArgument';

interface IJavaStringFormatArgumentsMap extends IStringFormatArgumentsMap {
	STRING: IStringFormatArgument;
	INT: IStringFormatArgument;
	DOUBLE: IStringFormatArgument;
	BOOLEAN: IStringFormatArgument;
	INT_ARRAY: IStringFormatArgument;
}

export { IJavaStringFormatArgumentsMap };