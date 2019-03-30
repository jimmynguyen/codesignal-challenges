import { Logger } from './util/Logger';
import { LanguageService } from './service/LanguageService';
import { Challenge } from './entity/Challenge';
import { ChallengeService } from './service/ChallengeService';
import { UserInputService } from './service/UserInputService';
import { FileService } from './service/FileService';

String.prototype.toPascalCase = function (this: string) {
	return this.charAt(0).toUpperCase() + this.substring(1);
}

async function run(): Promise<void> {
	try {
		const language: string = await LanguageService.validateLanguage(await UserInputService.get(UserInputService.INPUTS.LANGUAGE));
		const challenge: Challenge = await ChallengeService.getChallenge(await UserInputService.get(UserInputService.INPUTS.CHALLENGE_ID), language);
		await FileService.generateChallengeDirectory(challenge);
	} catch (e) {
		Logger.error(e);
	}
}

run();