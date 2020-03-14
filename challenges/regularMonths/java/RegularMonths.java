import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.IntStream;

public class RegularMonths {
	public static void main(String[] args) {
		String[] input0 = new String[] {"02-2016", "05-2027", "09-2099", "01-1970", "07-2024"};
		String[] expectedOutput = new String[] {"08-2016", "11-2027", "02-2100", "06-1970", "09-2025"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = regularMonths(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("regularMonths(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	public static String regularMonths(String currMonth) {
		DateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormat.parse(currMonth));
		} catch (ParseException e) {
			System.err.println(e.getStackTrace());
			return null;
		}
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		do {
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
		} while (calendar.get(Calendar.DAY_OF_WEEK) != 2);
		return dateFormat.format(calendar.getTime());
	}
}
