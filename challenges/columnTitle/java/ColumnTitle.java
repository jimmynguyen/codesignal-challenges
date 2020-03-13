import java.util.stream.IntStream;

public class ColumnTitle {
	public static void main(String[] args) {
		int[] input0 = new int[] {27, 2, 16808, 282475250, 28, 13, 1622650074, 984943659, 1144108931, 470211273, 101027545, 1457850879, 1458777924, 2007237710, 823564441, 1115438166, 1784484493, 74243043, 114807988, 1137522504, 1441282328, 16531730, 823378841, 143542613, 896544304, 1474833170, 1264817710, 1998097158, 1817129561, 1131570934, 197493100, 1404280279, 893351817, 1505795336, 1954899098, 1636807827, 563613513, 101929268};
		String[] expectedOutput = new String[] {"AA", "B", "XVL", "WTCPTR", "AB", "M", "EFNUWXF", "CDWICFK", "CRGPXUQ", "AMNXZTY", "HMAZZU", "DRRENCQ", "DRTFGMF", "FLXKHNJ", "BQHEHOK", "COVWRKX", "ETDYOXY", "FFLBYQ", "IQFBGV", "CQSFEON", "DQGXVKR", "AJDOET", "BQGTSZY", "LBBYCS", "BWKWNYF", "DTCISVR", "DBKTTBZ", "FLDKFZR", "EVXJYLM", "CQFEOLZ", "PPDMNL", "DNDYOQY", "BWDWXIG", "DVSCIWF", "FHMWLNV", "EGSUKIE", "AUKIETU", "HOAHXL"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = columnTitle(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("columnTitle(%d) returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String columnTitle(int number) {
		String title = "";
		int remainder;
		while (number > 0) {
			remainder = number % 26;
			title = (char)((int)'A' + remainder - (remainder == 0 ? -25 : 1)) + title;
			number = (number - (remainder == 0 ? 26 : remainder)) / 26;
		}
		return title;
	}
}
