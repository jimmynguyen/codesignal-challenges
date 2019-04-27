import { ILanguage } from "./ILanguage";

interface ILanguages {
	[index:string] : ILanguage;
	CSHARP: ILanguage;
	CPLUSPLUS: ILanguage;
	GO: ILanguage;
	GROOVY: ILanguage;
	JAVA: ILanguage;
	JAVASCRIPT: ILanguage;
	KOTLIN: ILanguage;
	OCTAVE: ILanguage;
	PYTHON3: ILanguage;
	TYPESCRIPT: ILanguage
}

export { ILanguages };