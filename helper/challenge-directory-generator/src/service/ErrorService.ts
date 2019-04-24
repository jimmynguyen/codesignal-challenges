import { sprintf } from 'sprintf-js';

import { IErrors } from '../interface/IErrors';

class ErrorService {
	public static ERRORS: IErrors =  {
		UNSUPPORTED_LANGUAGE: 'language "%s" is not supported',
		FAILED_TO_UPDATE_README: 'failed to update repository README.md file'
	};
	public static throw(errorTemplate: string, ...args: any): void {
		throw sprintf('ERR: %s', sprintf(errorTemplate, ...args));
	}
}

export { ErrorService };