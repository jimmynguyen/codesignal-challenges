import { Challenge } from '../entity/Challenge';
import { FileService } from '../service/FileService';
import { LanguageService } from '../service/LanguageService';
import { JavaScriptSolutionFileService } from '../service/solution/JavaScriptSolutionFileService';
import { JavaSolutionFileService } from '../service/solution/JavaSolutionFileService';
import { OctaveSolutionFileService } from '../service/solution/OctaveSolutionFileService';
import { Python3SolutionFileService } from '../service/solution/Python3SolutionFileService';
import { DefaultSolutionFileService } from '../service/solution/DefaultSolutionFileService';

class FileServiceFactory {
	public static getByLanguage(challenge: Challenge): FileService {
		let fileService: FileService;
		switch (challenge.getLanguage()) {
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
			default:
				fileService = new DefaultSolutionFileService(challenge);
				break;
		}
		return fileService;
	}
}

export { FileServiceFactory };