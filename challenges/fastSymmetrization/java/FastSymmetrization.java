import java.util.Arrays;
import java.util.stream.IntStream;

public class FastSymmetrization {
	public static void main(String[] args) {
		char[][][] input0 = new char[][][] {{{'*','*','c','*'}, {'*','b','*','a'}, {'a','*','*','*'}, {'*','*','c','*'}}, {{'*','a','b','*'}, {'*','a','b','*'}}, {{'*','*'}, {'*','*'}}, {{'*','a'}, {'b','*'}}, {{'a','*'}, {'*','a'}}, {{'*','*'}, {'*','x'}, {'*','*'}, {'*','*'}}};
		char[][][] expectedOutput = new char[][][] {{{'*','c','c','*'}, {'a','b','b','a'}, {'a','b','b','a'}, {'*','c','c','*'}}, {}, {{'*','*'}, {'*','*'}}, {}, {{'a','a'}, {'a','a'}}, {{'*','*'}, {'x','x'}, {'x','x'}, {'*','*'}}};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			char[][] actualOutput = fastSymmetrization(input0[i]);
			assert Arrays.deepEquals(actualOutput, expectedOutput[i]) : String.format("fastSymmetrization(%s) returned %s, but expected %s", Arrays.deepToString(input0[i]), Arrays.deepToString(actualOutput), Arrays.deepToString(expectedOutput[i]));
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static char[][] fastSymmetrization(char[][] a) {
		int nrows = a.length;
		int ncols = a[0].length;
		char[][] b = new char[nrows][ncols];
		for (int i = 0; i < nrows; i++) {
			for (int j = 0, k; j < ncols/2; j++) {
				k = ncols-j-1;
				if (a[i][j] != a[i][k]) {
					if (a[i][j] == '*') {
						b[i][j] = a[i][k];
						b[i][k] = a[i][k];
					} else if (a[i][k] == '*') {
						b[i][j] = a[i][j];
						b[i][k] = a[i][j];
					} else {
						return new char[0][0];
					}
				} else {
					b[i][j] = a[i][j];
					b[i][k] = a[i][k];
				}
			}
		}
		a = b;
		b = new char[nrows][ncols];
		for (int i = 0; i < ncols; i++) {
			for (int j = 0, k; j < nrows/2; j++) {
				k = nrows-j-1;
				if (a[j][i] != a[k][i]) {
					if (a[j][i] == '*') {
						b[j][i] = a[k][i];
						b[k][i] = a[k][i];
					} else if (a[k][i] == '*') {
						b[j][i] = a[j][i];
						b[k][i] = a[j][i];
					} else {
						return new char[0][0];
					}
				} else {
					b[j][i] = a[j][i];
					b[k][i] = a[k][i];
				}
			}
		}
		return b;
	}
}
