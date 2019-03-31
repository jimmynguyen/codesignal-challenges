import { sprintf } from 'sprintf-js';

class MarkdownLink {
	private text: string;
	private link: string;
	public constructor(text: string, link: string) {
		this.text = text;
		this.link = link;
	}
	public getText(): string {
		return this.text;
	}
	public getLink(): string {
		return this.link;
	}
	public toString(): string {
		return sprintf('[%s](%s)', this.text, this.link);
	}
}

export { MarkdownLink };