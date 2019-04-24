import { isUndefined } from 'util';

import { ILanguage } from '../interface/ILanguage';
import { ILanguages } from '../interface/ILanguages';
import { ErrorService } from './ErrorService';
import { UserInputService } from './UserInputService';

class LanguageService {
	public static LANGUAGES: ILanguages = {
		JAVA: {
			name: 'java',
			fullName: 'Java'
		},
		JAVASCRIPT: {
			name: 'js',
			fullName: 'JavaScript'
		},
		PYTHON3: {
			name: 'python3',
			fullName: 'Python3'
		},
		OCTAVE: {
			name: 'octave',
			fullName: 'Octave'
		},
		INVALID: {
			name: 'invalid',
			fullName: 'INVALID'
		}
	};
	public static async getLanguage(): Promise<ILanguage> {
		let language: string;
		if (process.argv.length > 2) {
			language = process.argv[2];
		} else {
			language = await UserInputService.get(UserInputService.INPUTS.LANGUAGE);
		}
		return LanguageService.validateLanguage(language);
	}
	private static async validateLanguage(name: string): Promise<ILanguage> {
		let language: ILanguage = this.findLanguageByName(name.toLowerCase())
		if (isUndefined(language)) {
			ErrorService.throw(ErrorService.ERRORS.UNSUPPORTED_LANGUAGE, name);
		}
		return language;
	}
	private static findLanguageByName(name: string): ILanguage {
		for (const languageKey in this.LANGUAGES) {
			if (this.LANGUAGES[languageKey].name == name && this.LANGUAGES[languageKey].name != this.LANGUAGES.INVALID.name) {
				return this.LANGUAGES[languageKey];
			}
		}
		return this.LANGUAGES.INVALID;
	}
}

export { LanguageService };