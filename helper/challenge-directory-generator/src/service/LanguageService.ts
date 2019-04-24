import { ILanguages } from '../interface/ILanguages';
import { ErrorService } from './ErrorService';
import { UserInputService } from './UserInputService';

class LanguageService {
	public static LANGUAGES: ILanguages = {
		JAVA: 'java',
		PYTHON3: 'python3',
		OCTAVE: 'octave'
	};
	public static async getLanguage(): Promise<string> {
		let language: string;
		if (process.argv.length > 2) {
			language = process.argv[2];
		} else {
			language = await UserInputService.get(UserInputService.INPUTS.LANGUAGE);
		}
		return LanguageService.validateLanguage(language);
	}
	private static async validateLanguage(language: string): Promise<string> {
		language = language.toLowerCase();
		if (!LanguageService.isSupported(language)) {
			ErrorService.throw(ErrorService.ERRORS.UNSUPPORTED_LANGUAGE, language);
		}
		return language;
	}
	private static isSupported(language: string): boolean {
		for (const languageKey in this.LANGUAGES) {
			if (this.LANGUAGES[languageKey] == language) {
				return true;
			}
		}
		return false;
	}
}

export { LanguageService };