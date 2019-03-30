import { ErrorService } from './ErrorService';
import { ILanguages } from '../interface/ILanguages';

class LanguageService {
	public static LANGUAGES: ILanguages = {
		JAVA: 'java'
	};
	public static async validateLanguage(language: string): Promise<string> {
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