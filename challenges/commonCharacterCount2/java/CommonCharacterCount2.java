import java.util.Arrays;
import java.util.stream.IntStream;

public class CommonCharacterCount2 {
	public static void main(String[] args) {
		String[][] input0 = new String[][] {{"aabcc", "adcaa", "acdba"}, {"aabcc", "adcaa", "ddddddbbbbbabbd"}, {"aabcc", "adcaa"}, {"zzzz", "zzzzzzz"}, {"zzzz", "yyyyyyy"}, {"aabcc", "adcaa", "aaaaaaaaaaa", "bbbbbbbbb"}, {"abcdefghxyzttw", "hgfedcbaabcwwt"}, {"zza", "zzz"}, {"abcdefabcdef"}, {"afcdbceccfecfafdfbddaebbaadefdeaadfaedefacebfdcadcfafbaabedbfeda", "cccabfacfbcfabbfaefeddcecafdffbaafaddfaaecaeeebdebecbbbfedbaafcedaddfecbedfae", "dccddbcedccdaeacdfffeacccafafebebdbeaeadeeeaeeaeddbafdfdfaacafceedfcbdcadecdbafafeacadaeeaacaaafb", "bcaecaafcdacadaadcfadfccdaffefabaffdfbfffcdeabecdacaecebffcaaebceecacabfeeeddbccd", "afcfaacbaceaadadbfedfeccefcebdabaaebbaffacaadbcdaccecbdbdcbcddfeefafebfdfbaf"}, {"kcegkkdfikcfgffhibdejdagiejhchackdiddaeibfjbchfifgkkckdfijdffcejiafgjj", "hbehcdbbajkjbedjkjdidkaiichhhaidfhhhkbddgekddde", "djbahbcjhkhcdi", "badddeajheeccifjiefikihaakhghbcajj", "dkcbhbhegkgafgccjkhiadjec"}, {"dcuceeizkgnrqmacwanczkjmbrkxwvtoddgshqigwzpqtwzjudhjmrqxdkrpbxkasggvyphbsvtjajwsccinrznvncusitucqug", "ardqxukrdagkqgmbcsgviiibremjdrwushudvythvjldtzezgnqmcnscxgchwvutdeggxwpcnrnqxspzckjwuewrcsajitvekqt", "drpecxnwutxavncgimcvrgkjuqgdhbxrnwqtrzkmzievqcrwsajqugqzatthrsucydijwgscxcsjdwkpsmkhnvg", "qhsaiuqcgtmqpmmdtwxsvgenwkiigevvthyvrgjswkrwaexjazcquszjdvtcbcndugkdwsznyridzsrguenwjwcopchurqkmecx", "cgwnuvkmnrsynuguekddqtpmeyrhzgjzisgzwcvcsriadiqvrawgccmmkyvtksxqcxrjzwqtghgqbhtdvknxopckhwmjjasudu"}, {"caedcbdcbecdbfcfbcedadbafbfeefbedaacbceafddfeeadbdaffecbaffaefdeafedfaefacc", "ddefeededaecbaadeddacbeddebeaeccbafdcaecaffcfdffecaeeaedefbadabffccbbffebffbaddbcfdaaedfabfaecc", "cfbacfcffbaeccefdedeaffbcdadbdfcaeebdafffbaeefcabecabcfddceefebceb", "eafeddfbcfcbfcbfceefeebefdfbdafffeecfacbbaadfbbcdccaaaeeeebdcabd", "eaebcffbffacdefefebfbeaaacceaedfbbdcccfddebdedafdeeacabbecbfffcfdca", "afeecdcebaedfeabfdafcabbdcacfdfaaaaefbffaceaffaecfebdccffbaecbfbccddcbdbcbbeecfceee", "abeeefcdfbacedacecdeaafbbfbfffeecabdbafdfdfabcabefcfedcdcebcefedf", "feeadefaeebfdbfbcdfdaaaaaffdbbddbcebcefdedcfcaccdfaffbcfecbdabffcedeceaeefcaffdeeecfafbb", "bdffafbcfbbbefbccdcfcdceeceddcfdedffaabfefecbeffcaceebdaeacebdefadafaecaffeabdebcad", "eabcaafbfcaabeaacecfabbfcecdddbdedfdefdbfeddcbbfcbfdceefbcaefaaeeffdeefabffcaccaceafc"}};
		int[] expectedOutput = new int[] {3, 1, 3, 4, 0, 0, 10, 2, 12, 63, 14, 85, 63};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = commonCharacterCount2(input0[i]);
			assert actualOutput == expectedOutput[i] : String.format("commonCharacterCount2(%s) returned %d, but expected %d", Arrays.deepToString(input0[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static int commonCharacterCount2(String[] s) {
		boolean halt = false;
		int count = 0;
		while (!halt) {
			Character letter = null;
			count++;
			for (int i = 0; i < s.length; i++) {
				if (s[i].length() == 0) {
					count--;
					halt = true;
					break;
				}
				if (letter == null) {
					letter = s[i].charAt(0);
				}
				int ndx = s[i].indexOf(letter);
				if (ndx >= 0) {
					s[i] = s[i].substring(0, ndx) + s[i].substring(ndx+1);
				} else {
					count--;
					break;
				}
			}
		}
		return count;
	}
}
