import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.IntStream;

public class MissedClasses {
	public static void main(String[] args) {
		int[] input0 = new int[] {2015, 1900, 2100, 1956, 2067, 2000, 1995, 2045, 2014, 2100};
		int[][] input1 = new int[][] {{2, 3}, {}, {1, 4, 7}, {1, 4, 6, 7}, {1, 2, 3, 4, 5, 6, 7}, {}, {1, 2, 3}, {1, 2, 3, 5}, {2, 3}, {}};
		String[][] input2 = new String[][] {{"11-04", "02-22", "02-23", "03-07", "03-08", "05-09"}, {}, {"10-28", "05-03", "10-02", "05-07", "05-25", "09-04", "10-30", "03-03", "09-02", "11-08"}, {"03-17", "04-03", "03-08", "09-18", "05-28", "02-14", "10-20", "01-02", "01-22", "10-04", "02-02", "10-07", "09-30", "05-20", "05-23", "09-22", "01-12", "05-02", "10-21", "03-20"}, {"01-20", "02-09", "01-25", "09-01", "05-30", "12-24", "09-05", "10-15", "09-25", "10-23", "10-10", "05-29", "02-05", "11-19", "04-28", "02-17", "05-04", "01-26", "05-31", "03-19", "12-31", "09-26", "05-19", "05-14", "09-03", "05-21", "02-08", "11-09", "09-09", "04-21"}, {}, {"10-28", "05-26", "09-24", "11-28", "09-17", "03-29", "09-08", "05-13", "10-23", "11-29", "04-26", "10-27", "09-26", "09-09", "12-07"}, {"11-12", "09-10", "11-10", "05-12", "05-03", "03-04", "02-14", "12-25", "09-24", "11-17", "09-22", "09-14", "12-04", "01-24", "03-24", "05-26", "09-01", "11-20", "04-30", "03-20", "10-04", "11-21", "01-14", "05-11", "12-03", "11-01"}, {"11-04", "02-22", "02-23", "03-07", "03-08", "05-09"}, {}};
		int[] expectedOutput = new int[] {3, 0, 4, 13, 30, 0, 5, 15, 1, 0};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		assert input1.length == expectedOutput.length : String.format("# input1 = %d, # expectedOutput = %d", input1.length, expectedOutput.length);
		assert input2.length == expectedOutput.length : String.format("# input2 = %d, # expectedOutput = %d", input2.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			int actualOutput = missedClasses(input0[i], input1[i], input2[i]);
			assert actualOutput == expectedOutput[i] : String.format("missedClasses(%d, %s, %s) returned %d, but expected %d", input0[i], Arrays.toString(input1[i]), Arrays.deepToString(input2[i]), actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static int missedClasses(int year, int[] daysOfTheWeek, String[] holidays) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String firstSemesterYear = Integer.toString(year);
		String secondSemesterYear = Integer.toString(year+1);
		String yearStr;
		int holidayDayOfTheWeek;
		int month;
		int missedClasses = 0;
		for (String holiday : holidays) {
			month = Integer.parseInt(holiday.substring(0, 2));
			yearStr = month >= 9 && month <= 12 ? firstSemesterYear : secondSemesterYear;
			try {
				calendar.setTime(dateFormat.parse(yearStr+"-"+holiday));
			} catch (ParseException e) {
				System.err.println(e.getStackTrace());
				return -1;
			}
			holidayDayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK);
			holidayDayOfTheWeek = holidayDayOfTheWeek == 1 ? 7 : holidayDayOfTheWeek-1;
			for (int dayOfTheWeek : daysOfTheWeek) {
				if (holidayDayOfTheWeek == dayOfTheWeek) {
					missedClasses++;
					break;
				}
			}
		}
		return missedClasses;
	}
}
