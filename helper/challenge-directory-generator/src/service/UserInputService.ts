import * as prompts from 'prompts';

import { IInputs } from '../interface/IInputs';

class UserInputService {
	public static INPUTS: IInputs = {
		USERNAME: {
			type: 'text',
			name: 'username',
			message: 'What is your CodeSignal username or email?'
		},
		PASSWORD: {
			type: 'text',
			name: 'password',
			message: 'What is your CodeSignal password?'
		},
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
		LANGUAGE_FULL_NAME: {
			type: 'text',
			name: 'languageFullName',
			message: 'What is the full name of the programming language for the solution?'
		},
		LANGUAGE_FILE_EXTENSION: {
			type: 'text',
			name: 'languageFileExtension',
			message: 'What is the file extension of the programming language for the solution?'
		},
		RUN_HEADLESS: {
			type: 'confirm',
			name: 'headless',
			message: 'Do you want to run the program headless?'
		},
		TEST_BASH_FILE: {
			type: 'text',
			name: 'testBaseFile',
			message: 'What is the file contents for the test.sh file for the solution?'
		},
		DELETE_EXISTING_CHALLENGE_SOLUTION_DIR: {
			type: 'confirm',
			name: 'deleteChallengeSolutionDir',
			message: 'Challenge solution directory exists. Do you want to delete it?'
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