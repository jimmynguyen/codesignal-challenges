import { IStringFormatArgument } from '../IStringFormatArgument';
import { IStringFormatArgumentsMap } from '../IStringFormatArgumentsMap';

interface IJavaStringFormatArgumentsMap extends IStringFormatArgumentsMap {
	STRING: IStringFormatArgument;
	INT: IStringFormatArgument;
	DOUBLE: IStringFormatArgument;
	BOOLEAN: IStringFormatArgument;
	INT_ARRAY: IStringFormatArgument;
	INT_ARRAY_ARRAY: IStringFormatArgument;
}

export { IJavaStringFormatArgumentsMap };