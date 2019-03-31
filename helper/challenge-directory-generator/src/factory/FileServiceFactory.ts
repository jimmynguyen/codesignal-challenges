import { Challenge } from "../entity/Challenge";
import { FileService } from "../service/FileService";
import { LanguageService } from "../service/LanguageService";
import { JavaSolutionFileService } from "../service/JavaSolutionFileService";
import { Python3SolutionFileService } from "../service/Python3SolutionFileService";
import { OctaveSolutionFileService } from "../service/OctaveSolutionFileService";

class FileServiceFactory {
	public static getByLanguage(challenge: Challenge): FileService | undefined {
		let fileService: FileService | undefined;
		switch (challenge.getLanguage()) {
			case LanguageService.LANGUAGES.JAVA:
				fileService = new JavaSolutionFileService(challenge);
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