import { Challenge } from '../entity/Challenge';
import { FileService } from '../service/FileService';
import { LanguageService } from '../service/LanguageService';
import { CoffeeScriptSolutionFileService } from '../service/solution/CoffeeScriptSolutionFileService';
import { CPlusPlusSolutionFileService } from '../service/solution/CPlusPlusSolutionFileService';
import { CSharpSolutionFileService } from '../service/solution/CSharpSolutionFileService';
import { DefaultSolutionFileService } from '../service/solution/DefaultSolutionFileService';
import { JavaScriptSolutionFileService } from '../service/solution/JavaScriptSolutionFileService';
import { JavaSolutionFileService } from '../service/solution/JavaSolutionFileService';
import { OctaveSolutionFileService } from '../service/solution/OctaveSolutionFileService';
import { Python3SolutionFileService } from '../service/solution/Python3SolutionFileService';
import { TypeScriptSolutionFileService } from '../service/solution/TypeScriptSolutionFileService';

class FileServiceFactory {
	public static getByLanguage(challenge: Challenge): FileService {
		let fileService: FileService;
		switch (challenge.getLanguage()) {
			case LanguageService.LANGUAGES.COFFEESCRIPT:
				fileService = new CoffeeScriptSolutionFileService(challenge);
				break;
			case LanguageService.LANGUAGES.CPLUSPLUS:
				fileService = new CPlusPlusSolutionFileService(challenge);
				break;
			case LanguageService.LANGUAGES.CSHARP:
				fileService = new CSharpSolutionFileService(challenge);
				break;
			case LanguageService.LANGUAGES.JAVA:
				fileService = new JavaSolutionFileService(challenge);
				break;
			case LanguageService.LANGUAGES.JAVASCRIPT:
				fileService = new JavaScriptSolutionFileService(challenge);
				break;
			case LanguageService.LANGUAGES.OCTAVE:
				fileService = new OctaveSolutionFileService(challenge);
				break;
			case LanguageService.LANGUAGES.PYTHON2:
			case LanguageService.LANGUAGES.PYTHON3:
				fileService = new Python3SolutionFileService(challenge);
				break;
			case LanguageService.LANGUAGES.TYPESCRIPT:
				fileService = new TypeScriptSolutionFileService(challenge);
				break;
			default:
				fileService = new DefaultSolutionFileService(challenge);
				break;
		}
		return fileService;
	}
}

export { FileServiceFactory };