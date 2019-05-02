// https://stackoverflow.com/questions/3115982/how-to-check-if-two-arrays-are-equal-with-javascript
function arraysEqual(a: any[], b: any[]): boolean {
	if (a === b) return true;
	if (a == null || b == null) return false;
	if (a.length != b.length) return false;
	for (let i: number = 0; i < a.length; ++i) {
		if (a[i] !== b[i]) return false;
	}
	return true;
}