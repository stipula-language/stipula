package ast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
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

	public long calculateSeconds(String text) {
		if (text == null) return 0L;
		String s = text.trim();
		if (s.isEmpty()) return 0L;

		ZoneId zone = ZoneId.systemDefault();
		ZonedDateTime now = ZonedDateTime.now(zone);

		if (s.matches("\\d{4}-\\d{2}-\\d{2}")) {
			try {
				LocalDate d = LocalDate.parse(s, DateTimeFormatter.ISO_LOCAL_DATE);
				ZonedDateTime target = d.atStartOfDay(zone);
				long secs = Duration.between(now, target).getSeconds();
				return Math.max(0L, secs);
			} catch (DateTimeParseException e) {
				// fall through
			}
		}

		DateTimeFormatter[] fmts = new DateTimeFormatter[] {
				DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
				DateTimeFormatter.ISO_LOCAL_DATE_TIME
		};

		for (DateTimeFormatter fmt : fmts) {
			try {
				LocalDateTime ldt = LocalDateTime.parse(s, fmt);
				ZonedDateTime target = ldt.atZone(zone);
				long secs = Duration.between(now, target).getSeconds();
				return Math.max(0L, secs);
			} catch (DateTimeParseException ignore) {
				// try next format
			}
		}

		if (s.matches("-?\\d+(?:\\.\\d+)?")) {
			double minutes = Double.parseDouble(s);
			return (long) Math.round(minutes * 60.0);
		}

		return 0L;
	}




}
