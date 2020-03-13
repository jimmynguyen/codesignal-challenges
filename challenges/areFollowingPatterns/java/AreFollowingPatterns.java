import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class AreFollowingPatterns {
	public static void main(String[] args) {
		String[][] input0 = new String[][] {{"cat", "dog", "dog"}, {"cat", "dog", "doggy"}, {"cat", "dog", "dog"}, {"aaa"}, {"aaa", "aaa", "aaa"}, {"aaa", "aab", "aaa"}, {"re", "jjinh", "rnz", "frok", "frok", "hxytef", "hxytef", "frok"}, {"kwtfpzm", "kwtfpzm", "kwtfpzm", "kwtfpzm", "kwtfpzm", "wfktjrdhu", "anx", "kwtfpzm"}, {"ato", "ato", "jflywws", "ato", "ato", "se", "se", "kiolm", "wizdkdqke"}, {"syf", "syf", "oxerkx", "oxerkx", "syf", "xgwatff", "pmnfaw", "t", "ajyvgwd", "xmhb", "ajg", "syf", "syf", "wjddgkopae", "fgrpstxd", "t", "i", "psw", "wjddgkopae", "wjddgkopae", "oxerkx", "zf", "jvdtdxbefr", "rbmphtrmo", "syf", "yssdddhyn", "syf", "jvdtdxbefr", "funnd", "syf", "syf", "wd", "syf", "vnntavj", "wjddgkopae", "yssdddhyn", "wcvk", "wjddgkopae", "fh", "zf", "gpkdcwf", "qkbw", "zf", "teppnr", "jvdtdxbefr", "fmn", "i", "hzmihfrmq", "wjddgkopae", "syf", "vnntavj", "dung", "kn", "qkxo", "ajyvgwd", "fs", "kanixyaepl", "syf", "tl", "yzhaa", "dung", "wa", "syf", "jtucivim", "tl", "kanixyaepl", "oxerkx", "wjddgkopae", "ey", "ai", "zf", "di", "oxerkx", "dung", "i", "oxerkx", "wmtqpwzgh", "t", "beascd", "me", "akklwhtpi", "nxl", "cnq", "bighexy", "ddhditvzdu", "funnd", "wmt", "dgx", "fs", "xmhb", "qtcxvdcl", "thbmn", "pkrisgmr", "mkcfscyb", "x", "oxerkx", "funnd", "iesr", "funnd", "t"}};
		String[][] input1 = new String[][] {{"a", "b", "b"}, {"a", "b", "b"}, {"a", "b", "c"}, {"aaa"}, {"aaa", "bbb", "aaa"}, {"aaa", "aaa", "aaa"}, {"kzfzmjwe", "fgbugiomo", "ocuijka", "gafdrts", "gafdrts", "ebdva", "ebdva", "gafdrts"}, {"z", "z", "z", "hhwdphhnc", "zejhegjlha", "xgxpvhprdd", "e", "u"}, {"ofnmiqelt", "ofnmiqelt", "flqmwoje", "ofnmiqelt", "zdohw", "jyk", "ujddjtxt", "s", "kw"}, {"enrylabgky", "enrylabgky", "dqlqaihd", "dqlqaihd", "enrylabgky", "ramsnzhyr", "tkibsntkbr", "l", "bgtws", "xwuaep", "o", "enrylabgky", "enrylabgky", "e", "auljuhtj", "l", "d", "jfzokgt", "e", "e", "dqlqaihd", "fgglhiedk", "nj", "quhv", "enrylabgky", "oadats", "enrylabgky", "nj", "zwupro", "enrylabgky", "enrylabgky", "pyw", "enrylabgky", "bedpuycdp", "e", "oadats", "i", "e", "fobyfznrxm", "fgglhiedk", "irxtd", "oyvf", "fgglhiedk", "ebpp", "nj", "p", "d", "cufxylz", "e", "enrylabgky", "bedpuycdp", "mitzb", "shsnw", "papmvh", "bgtws", "chtp", "pze", "enrylabgky", "klp", "wpx", "mitzb", "fo", "enrylabgky", "bvcigrirhe", "klp", "pze", "dqlqaihd", "e", "iufunacwjo", "bubgww", "fgglhiedk", "og", "dqlqaihd", "mitzb", "d", "dqlqaihd", "mysidv", "l", "naj", "clftmrwl", "fjb", "zjjnrffb", "sh", "gcn", "ouispza", "zwupro", "c", "rdank", "chtp", "xwuaep", "jufhm", "iyntbgm", "sufs", "mkivpe", "bxdd", "dqlqaihd", "zwupro", "vzxbbculgv", "zwupro", "l"}};
		boolean[] expectedOutput = new boolean[] {true, false, false, true, false, false, true, false, false, true};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			boolean actualOutput = areFollowingPatterns(input0[i], input1[i]);
			assert actualOutput == expectedOutput[i] : String.format("areFollowingPatterns(%s, %s) returned %b, but expected %b", Arrays.deepToString(input0[i]), Arrays.deepToString(input1[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	private static boolean areFollowingPatterns(String[] strings, String[] patterns) {
		Map<String, String> string2pattern = new HashMap<>();
		Map<String, String> pattern2string = new HashMap<>();
		for (int i = 0; i < strings.length; i++) {
			if ((string2pattern.containsKey(strings[i])
					&& !string2pattern.get(strings[i]).equals(patterns[i]))
					|| (pattern2string.containsKey(patterns[i])
					&& !pattern2string.get(patterns[i]).equals(strings[i]))) {
				return false;
			} else {
				string2pattern.put(strings[i], patterns[i]);
				pattern2string.put(patterns[i], strings[i]);
			}
		}
		return true;
	}
}
