import { sprintf } from 'sprintf-js';

import { IErrors } from '../interface/IErrors';

class ErrorService {
	public static ERRORS: IErrors =  {
		FAILED_TO_UPDATE_README: 'failed to update repository README.md file',
		TYPE_NOT_IMPLEMENTED: 'type "%s" not implemented'
	};
	public static throw(errorTemplate: string, ...args: any): never  {
		throw sprintf('ERR: %s', sprintf(errorTemplate, ...args));
	}
}

export { ErrorService };