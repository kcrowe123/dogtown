package com.dogtown.framework.date;

public class DateConstants
{
	/**
	 * Milliseconds in a day.  1000ms per sec, 60sec per min, 60 min per hour, 24 hours per day.
	 */
	public static final int MILLIS_PER_DAY = 60 * 60 * 24 * 1000;

    /**
     * Milliseconds in a single minute.  1000ms per sec, 60 sec per min.
     */
    public static final int MILLIS_PER_MINUTE = 60 * 1000;

    /**
     * Milliseconds in a single hour.  1000ms per sec, 60 min per sec, 60 min per hour.
     */
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

	/**
	 * SATURDAY
	 */
	public static final int SATURDAY = 7;

	/**
	 * FRIDAY
	 */
	public static final int FRIDAY = 6;

	/**
	 * Calendar Sunday Day
	 */
	public static final int CAL_SUNDAY = 7;

	/**
	 * DEFAULT_DATE_FORMAT
	 */
	public static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy";
    
	/**
	 * DEFAULT_DATE_FORMAT WITH HH:MM
	 */
	public static final String DEFAULT_DATE_FORMAT_WITH_HH_MM = "MM/dd/yyyy hh:mm"; 
	
	/**
	 * DEFAULT_DATE_FORMAT WITH KK:MM:SS (kk represents military time for hours)
	 */	
	public static final String DEFAULT_DATE_FORMAT_WITH_KK_MM_SS = "MM/dd/yyyy kk:mm:ss";

	/**
	 * DEFAULT_DATE_FORMAT WITH KK:MM 
	 */
	public static final String DEFAULT_DATE_FORMAT_WITH_KK_MM = "MM/dd/yyyy kk:mm";
	
	/**
	 * DEFAULT_DATE_FORMAT WITH HH:mm:ss
	 */
	public static final String DATE_FORMAT_WITH_HH_MM_SS = "yy/MM/ddHH:mm:ss";

	/**
	 * SAPCATS_DATE_FORMAT FOR FILENAME
	 */
	public static final String SAPCATS_DATE_FORMAT_FOR_FILENAME = "yyyyMMddHHmmss";

	/**
	 * SAPCATS_DATE_FORMAT 
	 */
	public static final String SAPCATS_DATE_FORMAT = "yyyyMMdd";

	/**
	 * SAPCATS_DATE_FORMAT WITH_TIME
	 */
	public static final String SAPCATS_DATE_FORMAT_WITH_TIME = "yyyyMMdd HHmmss";

	/**
	 * SAPCATS_TIME_FORMAT
	 */
	public static final String SAPCATS_TIME_FORMAT = "HHmmss";

	/**
	 * Date format in MM-dd-yyyy
	 */
	public static final String MMDDYYYY_DASH_DATE_FORMAT = "MM-dd-yyyy";

	/**
	 * Date format in MM-dd-yyyy
	 */
	public static final String YYYYMMDD_DASH_DATE_FORMAT = "yyyy-MM-dd";

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
	 * this will display the hour field 0 - 23
	 */
	public static final String HHMM24_COLON_TIME_FORMAT = "HH:mm";
	
	/**
	 * this will display the hour field 0 - 23
	 */
	public static final String MMDDYYYY_HHMM24_COLON_TIME_FORMAT = "MM/dd/yyyy HH:mm";
	
	/**
	 * this will display the hour field 1 - 24
	 */
	public static final String KKMM_COLON_TIME_FORMAT = "kk:mm";

	public static final String LENEL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";

	private DateConstants()
	{
		super();
	}

}
