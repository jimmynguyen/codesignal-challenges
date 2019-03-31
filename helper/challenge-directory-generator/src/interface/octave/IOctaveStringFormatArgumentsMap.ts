import { IStringFormatArgument } from '../IStringFormatArgument';
import { IStringFormatArgumentsMap } from '../IStringFormatArgumentsMap';

interface IOctaveStringFormatArgumentsMap extends IStringFormatArgumentsMap {
	STRING: IStringFormatArgument;
	INT: IStringFormatArgument;
	DOUBLE: IStringFormatArgument;
}

export { IOctaveStringFormatArgumentsMap };