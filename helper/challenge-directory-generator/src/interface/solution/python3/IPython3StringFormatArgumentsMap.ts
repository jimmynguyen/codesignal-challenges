import { IStringFormatArgument } from '../IStringFormatArgument';
import { IStringFormatArgumentsMap } from '../IStringFormatArgumentsMap';

interface IPython3StringFormatArgumentsMap extends IStringFormatArgumentsMap {
	STRING: IStringFormatArgument;
	BOOLEAN: IStringFormatArgument;
}

export { IPython3StringFormatArgumentsMap };