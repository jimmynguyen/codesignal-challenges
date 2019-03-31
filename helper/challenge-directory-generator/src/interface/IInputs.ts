import * as prompts from 'prompts';

interface IInputs {
	CHALLENGE_ID: prompts.PromptObject<string>;
	LANGUAGE: prompts.PromptObject<string>;
	DELETE_EXISTING_CHALLENGE_SOLUTION_DIR: prompts.PromptObject<string>;
}

export { IInputs };