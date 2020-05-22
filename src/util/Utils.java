package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {
	public static java.sql.Timestamp dateToTime(java.util.Date date) {
		String strDate = dateToStr(date, "yyyy-MM-dd HH:mm:ss SSS");
		return strToSqlDate(strDate, "yyyy-MM-dd HH:mm:ss SSS");
	}

	public static String dateToStr(java.util.Date date, String strFormat) {
		SimpleDateFormat sf = new SimpleDateFormat(strFormat);
		String str = sf.format(date);
		return str;
	}

	public static java.sql.Timestamp strToSqlDate(String strDate, String dateFormat) {
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		java.util.Date date = null;
		try {
			date = sf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());
		return dateSQL;
	}

	public static String dateToStr(java.sql.Timestamp time, String strFormat) {
		DateFormat df = new SimpleDateFormat(strFormat);
		String str = df.format(time);
		return str;
	}

	public static String dateToStr(java.sql.Timestamp time) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = df.format(time);
		return str;
	}

	public static String dateToStr2(java.sql.Timestamp time) {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String str = df.format(time);
		return str;
	}

	public static void main(String[] age) {
		System.out.println(strToSqlDate("2020-09-24 13:59:59", "yyyy-MM-dd HH:mm:ss"));
	}

}
