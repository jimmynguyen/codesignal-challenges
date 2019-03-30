import { IJavaStringFormatArgument } from "./IJavaStringFormatArgument";

interface IJavaStringFormatArgumentsMap {
	[index:string]: IJavaStringFormatArgument;
	STRING: IJavaStringFormatArgument;
	INT: IJavaStringFormatArgument;
	DOUBLE: IJavaStringFormatArgument;
	BOOLEAN: IJavaStringFormatArgument;
	INT_ARRAY: IJavaStringFormatArgument;
	DEFAULT: IJavaStringFormatArgument;
}

export { IJavaStringFormatArgumentsMap };