package com.lison.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String DATE_DD_MM_YYYY_PATTERN = "dd/MM/yyyy";

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

	/**
	 * @param value
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parseToDate(final String value, final String pattern) {
		try {
			simpleDateFormat.applyPattern(pattern);
			return simpleDateFormat.parse(value);
		} catch (ParseException pe) {
			System.out.println("DateUtils : Erreur lors du parsing de la date");
		}
		return null;
	}

}
