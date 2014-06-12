package com.dogtown.framework.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.dogtown.framework.exception.DogtownSystemException;

public class DateUtil
{
	private static final String DATE_PARSE_EXCEPTION_MSG = "Parse Exception while parsing Date";

	/**
	 * Minutes in a single hour.
	 */
	private static final int MINUTES_PER_HOUR = 60;

	/**
	 * Milliseconds in a day.  1000ms per sec, 60sec per min, 60 min per hour, 24 hours per day.
	 */
	public static final long MILLIS_PER_DAY = 60 * 60 * 24 * 1000;

	/**
	 * Milliseconds in a single hour.  1000ms per sec, 60 min per hour.
	 */
	public static final int MILLIS_PER_HOUR = 60000;

	public static final int MILLIS_PER_HOUR_CORRECT = 60 * 60 * 1000;

	/**
	 * Days in a week.
	 */
	public static final int DAYS_IN_WEEK = 7;

	/**
	 * Year
	 */
	public static final int YEAR = 1;

	/**
	 * Month
	 */
	public static final int MONTH = 2;

	/**
	 * Day
	 */
	public static final int DAY = 3;

	/**
	 * Hour
	 */
	public static final int HOUR = 4;

	/**
	 * Minute
	 */
	public static final int MINUTE = 5;

	/**
	 * Second.
	 */
	public static final int SECOND = 6;

	/**
	 * Millisecond.
	 */
	public static final int MILLISECOND = 7;

	/**
	 * SUNDAY
	 */
	public static final int SUNDAY = 1;

	/**
	 * MONDAY
	 */
	public static final int MONDAY = 2;
	
	public static final int TUESDAY = 3;
	
	public static final int WEDNESDAY = 4;
	
	public static final int THURSDAY = 5;	

	/**
	 * FRIDAY
	 */
	public static final int FRIDAY = 6;
	/**
	 * SATURDAY
	 */
	public static final int SATURDAY = 7;

	/**
	 * DEFAULT_DATE_FORMAT
	 */
	public static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy";

	/**
	 * Date format in MM-dd-yyyy
	 */
	public static final String MMDDYYYY_DASH_DATE_FORMAT = "MM-dd-yyyy";
	

	/**
	 * Date format in MM.dd.yyyy
	 */
	public static final String MMDDYYYY_DOT_DATE_FORMAT = "MM.dd.yyyy";

	/**
	 * Date format in MM-dd-yy
	 */
	public static final String MMDDYY_DASH_DATE_FORMAT = "MM-dd-yy";

	/**
	 * Date format in MM/dd/yy
	 */
	public static final String MMDDYY_SLASH_DATE_FORMAT = "MM/dd/yy";

	/**
	 * Date format in MM.dd.yy
	 */
	public static final String MMDDYY_DOT_DATE_FORMAT = "MM.dd.yy";

	/**
	 * Date format in MM.dd
	 */
	public static final String MMDD_DOT_DATE_FORMAT = "MM.dd";

	/**
	 * Date format in MM/dd
	 */
	public static final String MMDD_SLASH_DATE_FORMAT = "MM/dd";

	/**
	 * Date format in MM-dd
	 */
	public static final String MMDD_DASH_DATE_FORMAT = "MM-dd";

	/**
	 * Calendar Sunday Day
	 */
	public static final int CAL_SUNDAY = 7;

	/**
	* SimpleDateFormat
	*/
	static SimpleDateFormat sdf = null;

	/**
	 * Creates a date using the current system date.
	 *
	 * @param setTimeToZero pass true if the time portion of the date should be set to zero
	 * @return
	 */
	public static Date createDate(boolean setTimeToZero)
	{
		Date date = new Date();
		if (!setTimeToZero)
		{
			return date;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	/**
	 * Creates a date given the supplied year, month and day.
	 *
	 * @param year the year
	 * @param month the month where january = 1
	 * @param day the day of the month, where the 1st day of the month = 1
	 * @return
	 */
	public static Date createDate(int year, int month, int day)
	{
		return createDate(year, month, day, 0, 0, 0, 0);
	}

	/**
	 * Creates a date given the supplied year, month, day, hour, minute and second.
	 *
	 * @param year the year
	 * @param month the month where january = 1
	 * @param day the day of the month, where the 1st day of the month = 1
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static Date createDate(int year, int month, int day, int hour, int minute, int second)
	{
		return createDate(year, month, day, hour, minute, second, 0);
	}

	/**
	 * Creates a date given the supplied year, month, day, hour, minute, second and millisecond.
	 *
	 * @param year the year
	 * @param month the month where january = 1
	 * @param day the day of the month, where the 1st day of the month = 1
	 * @param hour
	 * @param minute
	 * @param second
	 * @param millisecond
	 * @return
	 */
	public static Date createDate(int year, int month, int day, int hour, int minute, int second, int millisecond)
	{
		Calendar cal = createCalendar(year, month, day, hour, minute, second, millisecond);

		return cal.getTime();
	}

	/**
	 * Creates a calendar given the supplied year, month and day.
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Calendar createCalendar(int year, int month, int day)
	{
		return createCalendar(year, month, day, 0, 0, 0, 0);
	}

	/**
	 * Creates a calendar given the supplied year, month, day, hour, minute and second.
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static Calendar createCalendar(int year, int month, int day, int hour, int minute, int second)
	{
		return createCalendar(year, month, day, hour, minute, second, 0);
	}

	/**
	 * Creates a calendar given the supplied year, month, day, hour, minute, second and millisecond.
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @param millisecond
	 * @return
	 */
	public static Calendar createCalendar(
		int year,
		int month,
		int day,
		int hour,
		int minute,
		int second,
		int millisecond)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, millisecond);

		return cal;
	}

	/**
	 * Creates a date by copying the given date.
	 *
	 * @param existingDate date object to copy
	 * @param setTimeToZero if true, the time portion of the date is set to zero
	 * @return
	 */
	public static Date copyDate(Date existingDate, boolean setTimeToZero)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(existingDate.getTime());
		if (setTimeToZero)
		{
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
		}
		return cal.getTime();
	}

	/**
	 * Gets the duration in seconds between startTime and endTime.
	 *
	 * @param startTime the start time of the duration.
	 * @param endTime the end time of the duration.
	 * @param factor the granularity of the interval to be measured.
	 * @return
	 */
	public static int getDuration(Date startTime, Date endTime, int factor)
	{
		if (startTime == null || endTime == null || factor == 0)
		{
			return 0;
		}
		return (int) Math.round(((endTime.getTime() - startTime.getTime())) / factor);
	}

	/**
	 * Returns true if the time part of the given date is not zero.
	 * @param existingDate date to examine
	 * @return
	 */
	public static boolean isTimeSet(Date existingDate)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(existingDate.getTime());
		return cal.get(Calendar.HOUR_OF_DAY) != 0
			|| cal.get(Calendar.MINUTE) != 0
			|| cal.get(Calendar.SECOND) != 0
			|| cal.get(Calendar.MILLISECOND) != 0;
	}

	/**
	 * Adds a value to a date.
	 *
	 * @param field the part of the date to add to
	 * @param value the amount to add
	 * @param date the date to be added to.
	 * @return a new date with the added value
	 */
	public static Date add(int field, int value, Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());

		switch (field)
		{
			case YEAR :
				cal.add(Calendar.YEAR, value);
				break;
			case MONTH :
				cal.add(Calendar.MONTH, value);
				break;
			case DAY :
				cal.add(Calendar.DAY_OF_MONTH, value);
				break;
			case HOUR :
				cal.add(Calendar.HOUR_OF_DAY, value);
				break;
			case MINUTE :
				cal.add(Calendar.MINUTE, value);
				break;
			case SECOND :
				cal.add(Calendar.SECOND, value);
				break;
			case MILLISECOND :
				cal.add(Calendar.MILLISECOND, value);
				break;
			default :
				throw new IllegalArgumentException("add(...) called without a valid field - doing nothing.");
		}

		return cal.getTime();
	}

	/**
	 * Converts a date to the default string format.
	 *
	 * @param date
	 * @return
	 */
	public static String toString(Date date)
	{
		return toString(date, DEFAULT_DATE_FORMAT);
	}

	/**
	 * Converts a date to a string format.
	 *
	 * @param date
	 * @param pattern
	 *
	 * @return String
	 */
	public static String toString(Date date, String pattern)
	{
		if (date == null)
		{
			return "";
		}

		sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * Converts a date to a string using the standard date format.
	 *
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parseString(String date) throws ParseException
	{
		Date returnValue = null;

		if (date != null)
		{
			String[] dateArray = splitDate(date.trim());
			if (isDateValid(dateArray))
			{
				returnValue = parseString(getFormattedDate(dateArray), DEFAULT_DATE_FORMAT);
			}
		}

		return returnValue;
	}

	/**
	 * Converts a date to a string using the supplied date format.
	 *
	 * @param date
	 * @param pattern
	 *
	 * @return Date
	 *
	 * @throws ParseException
	 */
	public static Date parseString(String date, String pattern) throws ParseException
	{
		if ((date == null) || ("".equals(date)))
		{
			return null;
		}
		
		if (MMDD_SLASH_DATE_FORMAT.equals(pattern))
		{
			Calendar cal = Calendar.getInstance();
			date = date + "/" + Integer.toString(cal.get(Calendar.YEAR));
			pattern = "MM/dd/yyyy";
		}
		sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(false);
		return new Date(sdf.parse(date).getTime());
	}

	/**
	 * Checks if date is in MM<sep>dd<sep>YYYY or MM<sep>dd<sep>YY or MM<sep>DD or M<sep>DD<sep>YY format or not.
	 *
	 * This method is a work-around for a problem observed in the java date parsing that gives odd results for
	 * things such as 3 digit years.
	 *
	 * This logic uses regular expession to parse the string.  Multiple regular expessions are used because
	 * mixed formats (e.g., hyphen and slash) are not supported.
	 *
	 * @param date string
	 *
	 * @return boolean
	 *
	 */
	protected static boolean isDateValid(String[] date)
	{
		boolean valid = false;
		//Check the length of the Array containing day, month and year
		if ((date != null) && (date.length >= 2))
		{
			// Month should be of length 2. 5/5/2005 is invalid while 05/5/2005 is valid.
			if (date[0].length() == 2 || date[0].length() == 1)
			{
				valid = true;
			}
			else
			{
				return false;
			}

			// Day part should be of length 2. 5/5/2005 is invalid while 5/05/2005 is valid.
			if (date[1].length() == 2 || date[1].length() == 1)
			{
				valid = true;
			}
			else
			{
				return false;
			}

			if (date.length > 2)
			{
				if (date[2].length() == 2 || date[2].length() == 4)
				{
					valid = true;
				}
				else
				{
					return false;
				}
			}
		}

		return valid;
	}

	protected static String getFormattedDate(String[] date)
	{
		String newDate = new String();
		String year = new String();
		if (date.length >= 2)
		{
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(createDate(true).getTime());
			if (date.length == 3)
			{
				date[2] = date[2].trim();
				//Year specified - must be YYYY or YY or of zero length.
				switch (date[2].length())
				{
					case 0 :
						//add the default current year part
						year = Integer.toString(cal.get(Calendar.YEAR));
						break;
					case 2 :
						//add the century part in the year
						year = Integer.toString(cal.get(Calendar.YEAR)).substring(0, 2).concat(date[2]);
						break;
					case 4 :
						year = date[2];
						break;
				}
			}
			else // Year is null
				{
				year = Integer.toString(cal.get(Calendar.YEAR));
			}

			newDate = date[0] + "/" + date[1] + "/" + year;
		}

		return newDate;
	}

	public static String[] splitDate(String date)
	{
		String[] dateArray = null;
		if (isSlash(date))
		{
			dateArray = date.split("/");
		}
		else if (isDot(date))
		{
			dateArray = date.split("\\.");
		}
		else if (isDashed(date))
		{
			dateArray = date.split("-");
		}
		else if (isColon(date))
		{
			dateArray = date.split(":");
		}

		return dateArray;
	}
	
	/**
	 * This method will add or substract the hours, minutes and second to the given date
	 * based on the boolean condition to add or substract. The expected String format are
	 * hh:mm:ss:milli, hh.mm.ss.milli
	 *
	 * @param hhmmss
	 * @return
	 */
	public static Date addTimeToDate(Date date, String time, boolean add)
	{

		Date retVal = date;
		String sign = "";
		String[] timeArray = null;

		if (!add)
		{
			sign = "-";
		}

		if (time != null && !time.trim().equals(""))
		{

			timeArray = splitTime(time);

			if (timeArray != null)
			{
				switch (timeArray.length)
				{

					case 4 :
						{
							int value =
								new Integer(timeArray[0]).intValue() < 0
									? new Integer(timeArray[0]).intValue()
									: new Integer(sign + timeArray[0]).intValue();

							retVal = DateUtil.add(DateUtil.HOUR, value, retVal);

							value =
								new Integer(timeArray[1]).intValue() < 0
									? new Integer(timeArray[1]).intValue()
									: new Integer(sign + timeArray[1]).intValue();

							retVal = DateUtil.add(DateUtil.MINUTE, value, retVal);

							value =
								new Integer(timeArray[2]).intValue() < 0
									? new Integer(timeArray[2]).intValue()
									: new Integer(sign + timeArray[2]).intValue();

							retVal = DateUtil.add(DateUtil.SECOND, value, retVal);

							value =
								new Integer(timeArray[3]).intValue() < 0
									? new Integer(timeArray[3]).intValue()
									: new Integer(sign + timeArray[3]).intValue();

							retVal = DateUtil.add(DateUtil.MILLISECOND, value, retVal);

							break;

						}
					case 3 :
						{

							int value =
								new Integer(timeArray[0]).intValue() < 0
									? new Integer(timeArray[0]).intValue()
									: new Integer(sign + timeArray[0]).intValue();

							retVal = DateUtil.add(DateUtil.HOUR, value, retVal);

							value =
								new Integer(timeArray[1]).intValue() < 0
									? new Integer(timeArray[1]).intValue()
									: new Integer(sign + timeArray[1]).intValue();

							retVal = DateUtil.add(DateUtil.MINUTE, value, retVal);

							value =
								new Integer(timeArray[2]).intValue() < 0
									? new Integer(timeArray[2]).intValue()
									: new Integer(sign + timeArray[2]).intValue();

							retVal = DateUtil.add(DateUtil.SECOND, value, retVal);

							break;
						}
					case 2 :
						{
							int value =
								new Integer(timeArray[0]).intValue() < 0
									? new Integer(timeArray[0]).intValue()
									: new Integer(sign + timeArray[0]).intValue();

							retVal = DateUtil.add(DateUtil.HOUR, value, retVal);

							value =
								new Integer(timeArray[1]).intValue() < 0
									? new Integer(timeArray[1]).intValue()
									: new Integer(sign + timeArray[1]).intValue();

							retVal = DateUtil.add(DateUtil.MINUTE, value, retVal);

							break;
						}
					case 1 :
						{
							int value =
								new Integer(timeArray[0]).intValue() < 0
									? new Integer(timeArray[0]).intValue()
									: new Integer(sign + timeArray[0]).intValue();

							retVal = DateUtil.add(DateUtil.HOUR, value, retVal);
							break;
						}
				}

			}

		}

		return retVal;
	}

	public static String extractYear(String[] date)
	{
		String year = null;
		if (date != null)
		{
			year = (date.length == 3 ? date[2] : null);
		}

		return year;
	}

	public static String getDateFormat(String date)
	{
		if (isSlash(date))
		{
			return getSlashDateFormat(date);
		}
		else if (isDot(date))
		{
			return getDottedDateFormat(date);
		}
		else if (isDashed(date))
		{
			return getDashDateFormat(date);
		}
		else
		{
			return null;
		}
	}

	private static boolean isDashed(String date)
	{
		return (date != null && date.indexOf("-") > 0);
	}

	private static boolean isDot(String date)
	{
		return (date != null && date.indexOf('.') > 0);
	}

	private static boolean isSlash(String date)
	{
		return (date != null && date.indexOf("/") > 0);
	}

	private static boolean isColon(String date)
	{
		return (date != null && date.indexOf(":") > 0);
	}

	protected static String getSlashDateFormat(String date)
	{
		// Note, there is no default case below as this will
		// act as the default case.
		String year = extractYear(splitDate(date));
		String format = DateUtil.DEFAULT_DATE_FORMAT;
		if (year != null)
		{
			switch (year.length())
			{
				case 0 : // "MM/dd"
					format = DateUtil.MMDD_SLASH_DATE_FORMAT;
					break;

				case 2 : // "MM/dd/yy"
					format = DateUtil.MMDDYY_SLASH_DATE_FORMAT;
					break;

				case 4 : // "MM/dd/yyyy"
					format = DateUtil.DEFAULT_DATE_FORMAT;
					break;
			}
		}

		return format;
	}

	protected static String getDottedDateFormat(String date)
	{
		// Default case
		String year = extractYear(splitDate(date));
		String format = DateUtil.MMDDYYYY_DOT_DATE_FORMAT;
		if (year != null)
		{
			switch (year.length())
			{
				case 0 : // "MM.dd"
					format = DateUtil.MMDD_DOT_DATE_FORMAT;
					break;

				case 2 : // "MM.dd.yy"
					format = DateUtil.MMDDYY_DOT_DATE_FORMAT;
					break;

				case 4 : // "MM.dd.yyyy"
					format = DateUtil.MMDDYYYY_DOT_DATE_FORMAT;
					break;
			}
		}

		return format;
	}

	protected static String getDashDateFormat(String date)
	{
		// Default case
		String year = extractYear(splitDate(date));
		String format = DateUtil.MMDD_DASH_DATE_FORMAT;
		if (year != null)
		{
			switch (year.length())
			{
				case 0 : // "MM-dd"
					format = DateUtil.MMDD_DASH_DATE_FORMAT;
					break;

				case 2 : // "MM-dd-yy"
					format = DateUtil.MMDDYY_DASH_DATE_FORMAT;
					break;

				case 4 : // "MM-dd-yyyy"
					format = DateUtil.MMDDYYYY_DASH_DATE_FORMAT;
					break;
			}
		}

		return format;
	}

	/**
	 * returns the days difference in number of days between the two dates passed.
	 *
	 * @param Date fromDate
	 * @param Date toDate
	 *
	 * @return int
	 */
	public static int calculateDayDifference(Date fromDate, Date toDate)
	{

		if ((fromDate == null) || (toDate == null))
		{
			throw new IllegalArgumentException("Null Parameter passed.Start Date" + fromDate + "End Date" + toDate);
		}

		GregorianCalendar gcFrom = (GregorianCalendar) Calendar.getInstance();
		GregorianCalendar gcTo = (GregorianCalendar) Calendar.getInstance();
		gcFrom.setLenient(false);
		gcTo.setLenient(false);
		gcFrom.setTime(fromDate);
		gcTo.setTime(toDate);

		gcFrom.set(gcFrom.get(Calendar.YEAR), gcFrom.get(Calendar.MONTH), gcFrom.get(Calendar.DATE), 11, 0, 0);

		gcTo.set(gcTo.get(Calendar.YEAR), gcTo.get(Calendar.MONTH), gcTo.get(Calendar.DATE), 11, 0, 0);

		return Math.round((float) ((gcTo.getTime().getTime() - gcFrom.getTime().getTime()) / 86400000.0));

	}

	/**
	 * This method converts the hours in double to minutes.
	 * @param time
	 * @return
	 */
	public static int convertHoursToDuration(double hours)
	{
		double duration = hours * MINUTES_PER_HOUR;

		return (int) Math.round(duration);
	}

	protected static String[] splitTime(String time)
	{
		String[] timeArray = null;

		if (isDot(time))
		{
			timeArray = time.split("\\.");
		}
		else if (isColon(time))
		{
			timeArray = time.split(":");
		}

		return timeArray;
	}

	/**
	 * getPreviousSunday - Given a date, find the previous date that was a Sunday.
	 *
	 * @param date - The date from which to start the search.
	 * @return Date
	 */
	public static Date getPreviousSunday(Date date)
	{
		Date targetDate = date;
		while (!compareDay(targetDate, SUNDAY))
		{
			targetDate = DateUtil.add(DateUtil.DAY, -1, targetDate);
		}

		return targetDate;
	}

	/**
	 * getPreviousSunday - Given a date, find the previous date that was a Sunday.
	 *
	 * @param date - The date from which to start the search.
	 * @param date - The Number of Sunday to count back
	 * @return Date
	 */
	public static Date getPreviousSunday(Date date, int previousSundayCount)
	{
		Date targetDate = date;
		while (!compareDay(targetDate, SUNDAY))
		{
			targetDate = DateUtil.add(DateUtil.DAY, -1, targetDate);
		}

		targetDate =
			DateUtil.add(
				DateUtil.DAY,
				(DAYS_IN_WEEK - DAYS_IN_WEEK * previousSundayCount),
				targetDate);

		return targetDate;
	}

	/**
	 * getPreviousPeriodMonday - Given a date, find the prior period Monday.  A period
	 * 								is defined as Monday through Sunday.  This method skips
	 * 								the current periods Monday (the Monday that the target date
	 * 								uses as its starting date).
	 *
	 * @param date - The date from which to start the search.
	 * @return Date
	 */
	public static Date getPreviousPeriodMonday(Date date)
	{
		Date targetDate = date;
		boolean secondTime = false;
		while (!secondTime)
		{
			// Find current Monday and subtract a week
			if (compareDay(targetDate, MONDAY))
			{
				secondTime = true;
				targetDate = DateUtil.add(DateUtil.DAY, -7, targetDate);
			}
			else
			{
				targetDate = DateUtil.add(DateUtil.DAY, -1, targetDate);
			}
		}

		return targetDate;
	}
	
	/**
		 * getPreviousMonday - Given a date, find the prior  Monday. 
		 *
		 * @param date - The date from which to start the search.
		 * @return Date
		 */
		public static Date getPreviousMonday(Date date)
		{
			Date targetDate = date;
			boolean secondTime = false;
			while (!secondTime)
			{
				// Find current Monday 
				if (compareDay(targetDate, MONDAY))
				{
					secondTime = true;
					targetDate = DateUtil.add(DateUtil.DAY, -0, targetDate);
				}
				else
				{
					targetDate = DateUtil.add(DateUtil.DAY, -1, targetDate);
				}
			}

			return targetDate;
		}
	/**
	 * Given a date, finds next week Monday date.  
	 *
	 * @param date - The date from which to start the search.
	 * @return Date
	 */
	public static Date getNextWeekMonday(Date date)
	{
		Date targetDate = date;
		boolean secondTime = false;
		if (compareDay(targetDate, DateUtil.MONDAY))
		{
			secondTime = true;
			targetDate = DateUtil.add(DateUtil.DAY, 7, targetDate);
			return targetDate;
		}
		while (!secondTime)
		{
			if (compareDay(targetDate, DateUtil.MONDAY))
			{
				secondTime = true;
			}
			else
			{
				targetDate = DateUtil.add(DateUtil.DAY, 1, targetDate);
			}
		}

		return targetDate;
	}
	
	/**
	 * Given a date, finds next week Monday date.  
	 *
	 * @param date - The date from which to start the search.
	 * @return Date
	 */
	public static Date getNextWeekMonday(Date date, int count)
	{
		Date targetDate = date;
		while (!compareDay(targetDate, Calendar.MONDAY))
		{
			targetDate = DateUtil.add(DateUtil.DAY, -1, targetDate);
		}
		return DateUtil.add(DateUtil.DAY, 7*count, targetDate);
	}
		
	/**
	 * isSunday - Return true if supplied date is a Sunday.
	 *
	 * @param date - The date to compare.
	 * @return boolean
	 */
	public static boolean isSunday(Date date)
	{
		return compareDay(date, SUNDAY);
	}

	/**
	 * isMonday - Return true if supplied date is a Monday.
	 *
	 * @param date - The date to compare.
	 * @return boolean
	 */
	public static boolean isMonday(Date date)
	{
		return compareDay(date, MONDAY);
	}
	
	public static boolean isTuesday(Date date)
	{
		return compareDay(date, TUESDAY);
	}
	
	public static boolean isWednesday(Date date)
	{
		return compareDay(date, WEDNESDAY);
	}
	
	/**
	 * isFriday - Return true if supplied date is a Friday.
	 *
	 * @param date - The date to compare.
	 * @return boolean
	 */
	public static boolean isFriday(Date date)
	{
		return compareDay(date, FRIDAY);
	}

	public static boolean compareDay(Date date, int day)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return (dayOfWeek == day);

	}

	/**
	 * This method converts the input datestring to the required format
	 * @param date
	 * @param initialFormat
	 * @param newFormat
	 * @return
	 * @throws ParseException
	 */
	public static Date convertDateFormat(String date, String initialFormat, String newFormat) throws ParseException
	{
		Date inputDate = parseString(date, initialFormat);
		Date returnDate;
		date = DateUtil.toString(inputDate, newFormat);
		returnDate = parseString(date, newFormat);
		return returnDate;
	}

	/**
	 * This method changes the Date value passed to the date of Day of week passed.
	 * Expecting
	 * 1 : Monday
	 * 2 : Tuesday
	 * 3 : Wednesday
	 * 4 : Thrusday
	 * 5 : Friday
	 * 6 : Saturday
	 * 7 : Sunday
	 * @param date
	 * @param DayOfWeek
	 * @return
	 */
	public static Date convertDateToWeekDayDate(Date date, int DayOfWeek)
	{
		if (DayOfWeek > 0 && DayOfWeek < 8)
		{
			int calWeekOfDay = getDayOfWeekByDate(date);
			if (calWeekOfDay != DayOfWeek)
			{
				date = DateUtil.add(DateUtil.DAY, (DayOfWeek - calWeekOfDay), date);
			}
		}
		else
		{
			throw new IllegalArgumentException("Invalid Day Of week");
		}
		return date;
	}

	/**
	 * Get the date of the week of days
	 * MONDAY - 1
	 * SUNDAY - 7
	 * @param date
	 * @return
	 */
	public static int getDayOfWeekByDate(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		int calWeekOfDay = cal.get(Calendar.DAY_OF_WEEK);
		if (calWeekOfDay == SUNDAY)
		{
			calWeekOfDay = CAL_SUNDAY;
		}
		else
		{
			calWeekOfDay = calWeekOfDay - 1;
		}
		return calWeekOfDay;
	}

	public static Date getMaxDate(Date lhs, Date rhs)
	{
		Date maxDate = null;
		if (lhs.after(rhs))
		{
			maxDate = lhs;
		}
		else if (rhs.after(lhs))
		{
			maxDate = rhs;
		}
		else // Doesn't matter, they should be the same
			{
			maxDate = lhs;
		}

		return maxDate;
	}

	public static Date getMinDate(Date lhs, Date rhs)
	{
		Date minDate = null;
		if (lhs.before(rhs))
		{
			minDate = lhs;
		}
		else if (rhs.before(lhs))
		{
			minDate = rhs;
		}
		else // Doesn't matter, they should be the same
			{
			minDate = lhs;
		}

		return minDate;
	}

	/**
	 * This method parse the Date from the string format.
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Calendar parseDateString(String dateString) throws ParseException
	{
		Date utilDate = DateUtil.parseString(dateString);
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(utilDate.getTime());
		return cal;
	}

	/**
	 * This method parse the Time String
	 * @param timeString
	 * @return
	 * @throws ParseException
	 */
	public static Calendar parseTimeString(Calendar scheduleCal, String timeString) throws ParseException
	{
		String[] timeParts = splitDate(timeString);
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(scheduleCal.getTime().getTime());
		if (timeParts.length >= 3)
		{
			// assume hours:minutes:seconds
			cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeParts[0]));
			cal.set(Calendar.MINUTE, Integer.parseInt(timeParts[1]));
			cal.set(Calendar.SECOND, Integer.parseInt(timeParts[2]));
		}
		else if (timeParts.length == 2)
		{
			// assume hours/minutes
			cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeParts[0]));
			cal.set(Calendar.MINUTE, Integer.parseInt(timeParts[1]));
		}
		else if (timeParts.length == 1)
		{
			// assume hours
			cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeParts[0]));
		}
		return cal;
	}

	/**
	 * This method create a Date Infinite
	 * @return
	 */
	public static Date createInfiniteDate()
	{
		Date infiniteDate = DateUtil.createDate(9999, 12, 31);
		return infiniteDate;
	}

	/**
	 * isSaturday - Return true if supplied date is a Saturday.
	 *
	 * @param date - The date to compare.
	 * @return boolean
	 */
	public static boolean isSaturday(Date date)
	{
		return compareDay(date, SATURDAY);
	}

	/**
	 * isWeekend - Returns true if supplied date is a Saturday or a Sunday
	 * @param date
	 * @return
	 */
	public static boolean isWeekend(Date date)
	{
		return isSaturday(date) || isSunday(date);
	}

	/**
	 * Returns the Previous Month End Date
	 * @param date
	 * @return
	 */
	public static Date getPreviousMonthEndDate(Date date)
	{
		Date targetDate = date;
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(targetDate.getTime());

		cal.set(Calendar.DAY_OF_MONTH, 1);

		targetDate = DateUtil.add(DateUtil.DAY, -1, cal.getTime());

		return targetDate;

	}

	public static Date toDate(String dt) throws DogtownSystemException
	{
		Date date;
		try
		{
			date = parseString(dt);
		}
		catch (Exception e)
		{
			throw new DogtownSystemException(DATE_PARSE_EXCEPTION_MSG, e);
		}

		return date;
	}

	/**
	 * This method compares the Calendar.DATE of two dates to see if 
	 * they are the same.
	 * 
	 * @param firstDate
	 * @param secondDate
	 * @return boolean true means that they are the same
	 *                 false means that they are not
	 */
	public static boolean areSameDay(Date firstDate, Date secondDate)
	{
		Calendar cal1 = Calendar.getInstance();
		
		Calendar cal2 = Calendar.getInstance();
		
		cal1.setTime(firstDate);
		cal2.setTime(secondDate);
		
		if (cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * This method sets the time of a date to the end of a day (24:00)
	 * 
	 * @param date
	 * @return 
	 */
	public static Date setTimeToEndOfDay(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 12);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.AM_PM, Calendar.PM);
		return cal.getTime();
	}
	
	/**
	 * This method sets the time of the date to the start of a day (00:00)
	 * 
	 * @param date
	 * @return
	 */
	public static Date setTimeToStartOfDay(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 00);
		cal.set(Calendar.MINUTE, 00);
		return cal.getTime();
	}
	/**
	 * gets the last regulary scheduled working day prior to the given date
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastScheduledWorkingDay(Date date)
	{
		if (isMonday(date))
		{
			date = getPreviousPeriodMonday(date);
			date = convertDateToWeekDayDate(date, 5);
		}
		else if (isSaturday(date))
		{
			date = convertDateToWeekDayDate(date, 5);
		}
		else if (isSunday(date))
		{
			date = convertDateToWeekDayDate(date, 5);
		}
		else
		{
			int day = getDayOfWeekByDate(date);
			day = day-1;
			date = convertDateToWeekDayDate(date, day);
		}
		return date;
	}
	/**
	 * gets the next regulary scheduled working day after the given date
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextScheduledWorkingDay(Date date)
	{
		if (isFriday(date))
		{
			date = add(DAY, 3, date);
		}
		else if (isSaturday(date))
		{
			date = add(DAY, 2, date);
		}
		else if (isSunday(date))
		{
			date = add(DAY, 1, date);
		}
		else
		{
			date = add(DAY, 1, date);
		}
		return date;
	}
	
	/**
	 * Determines whether a the year is part of a leap year
	 * @param int
	 * @return
	 */
	public static boolean isLeapYear(int year) 
	{
		GregorianCalendar cal = (GregorianCalendar)Calendar.getInstance();

		return cal.isLeapYear(year);	
	}

	/**
	 * Returns the year for the specified date
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		return cal.get(Calendar.YEAR);
	}
	
	/**
	 * Returns the month for the specified date
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		return cal.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Returns the day for the specified date
	 * 
	 * @param date
	 * @return
	 */
	public static int getDay(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Given two dates, this method determines the number of days between the two dates.
	 * @param Date fromDate
	 * @param Date toDate
	 * @return long number of days
	 */
	public static long getDurationInDays(Date fromDate, Date toDate)
	{
		if (fromDate == null || toDate == null)
		{
			return 0;
		}
		
		long fromTime = fromDate.getTime();
		long toTime = toDate.getTime();

		long difference = toTime - fromTime;

		long days = (difference/(1000*60*60*24)); // no. of days between the two dates
		
		return days;
	}

}
