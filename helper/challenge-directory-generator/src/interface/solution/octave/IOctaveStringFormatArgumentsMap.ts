import { IStringFormatArgument } from '../IStringFormatArgument';
import { IStringFormatArgumentsMap } from '../IStringFormatArgumentsMap';

interface IOctaveStringFormatArgumentsMap extends IStringFormatArgumentsMap {
	STRING: IStringFormatArgument;
	INT: IStringFormatArgument;
	DOUBLE: IStringFormatArgument;
	INT_ARRAY_ARRAY: IStringFormatArgument;
}

export { IOctaveStringFormatArgumentsMap };