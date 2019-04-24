import { Challenge } from '../entity/Challenge';
import { FileService } from '../service/FileService';
import { LanguageService } from '../service/LanguageService';
import { JavaScriptSolutionFileService } from '../service/solution/JavaScriptSolutionFileService';
import { JavaSolutionFileService } from '../service/solution/JavaSolutionFileService';
import { OctaveSolutionFileService } from '../service/solution/OctaveSolutionFileService';
import { Python3SolutionFileService } from '../service/solution/Python3SolutionFileService';

class FileServiceFactory {
	public static getByLanguage(challenge: Challenge): FileService | undefined {
		let fileService: FileService | undefined;
		switch (challenge.getLanguage()) {
			case LanguageService.LANGUAGES.JAVA:
				fileService = new JavaSolutionFileService(challenge);
				break;
			case LanguageService.LANGUAGES.JAVASCRIPT:
				fileService = new JavaScriptSolutionFileService(challenge);
				break;
			case LanguageService.LANGUAGES.PYTHON3:
				fileService = new Python3SolutionFileService(challenge);
				break;
			case LanguageService.LANGUAGES.OCTAVE:
				fileService = new OctaveSolutionFileService(challenge);
				break;
		}
		return fileService;
	}
}

export { FileServiceFactory };