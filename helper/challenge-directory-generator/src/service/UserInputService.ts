import * as prompts from 'prompts';
import { IInputs } from '../interface/IInputs';

class UserInputService {
	public static INPUTS: IInputs = {
		CHALLENGE_ID: {
			type: 'text',
			name: 'challengeId',
			message: 'What is the CodeSignal challenge id?'
		},
		LANGUAGE: {
			type: 'text',
			name: 'language',
			message: 'What is the programming language for the solution?'
		},
		DELETE_EXISTING_CHALLENGE_DIR: {
			type: 'confirm',
			name: 'deleteChallengeDir',
			message: 'Challenge directory exists. Do you want to delete it?'
		}
	}
	public static async get(question: prompts.PromptObject<string>): Promise<string> {
		const response: prompts.Answers<string> = await prompts([question]);
		return response[question.name.toString()];
	}
	public static async confirm(question: prompts.PromptObject<string>): Promise<boolean> {
		const response: prompts.Answers<string> = await prompts([question]);
		return response[question.name.toString()];
	}
}

export { UserInputService };