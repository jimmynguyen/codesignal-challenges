import { ILanguage } from "./ILanguage";

interface ILanguages {
	[index:string] : ILanguage;
	JAVA: ILanguage;
	JAVASCRIPT: ILanguage;
	PYTHON3: ILanguage;
	OCTAVE: ILanguage;
}

export { ILanguages };