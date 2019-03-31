class Logger {
	public static log(...args: any) {
		console.log(...args);
	}
	public static error(...args: any) {
		console.error(...args);
	}
	public static warn(...args: any) {
		console.warn(...args);
	}
}

export { Logger };