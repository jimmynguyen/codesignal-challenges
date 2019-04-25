import { Challenge } from './entity/Challenge';
import { FileServiceFactory } from './factory/FileServiceFactory';
import { ILanguage } from './interface/ILanguage';
import { ChallengeService } from './service/ChallengeService';
import { FileService } from './service/FileService';
import { LanguageService } from './service/LanguageService';
import { Logger } from './util/Logger';

String.prototype.toPascalCase = function (this: string) {
	return this.charAt(0).toUpperCase() + this.substring(1);
}

async function run(): Promise<void> {
	try {
		const language: ILanguage = await LanguageService.getLanguage();
		const challenge: Challenge = await ChallengeService.getChallengeByLanguage(language);
		const fileService: FileService = FileServiceFactory.getByLanguage(challenge);
		await fileService.generateChallengeDirectory();
		await fileService.updateREADMEFile();
	} catch (e) {
		Logger.error(e);
	}
}

run();