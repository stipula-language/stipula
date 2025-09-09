package ast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Date;  

public class DateUtils {

	final static String DATE_FORMAT = "yyyy/MM/dd:hh:mm";

	public boolean isValidDate(String date_time) 
	{
		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy/MM/dd:hh:mm");

		try {
			Date date = dateParser.parse(date_time);
			return true;
		} catch (ParseException e) {
			return false;
		}

	}


	public int calculateSeconds(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd:HH:mm");
		LocalDateTime toDate = LocalDateTime.parse(str, formatter);
		LocalDateTime fromDate = LocalDateTime.now();

		int seconds = (int) ChronoUnit.SECONDS.between(fromDate, toDate);
		return seconds;
	}



}
