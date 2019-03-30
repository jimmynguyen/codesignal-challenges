class Logger {
	public static log(...args: any) {
		console.log(...args);
	}
	public static error(...args: any) {
		console.error(...args);
	}
}

export { Logger };