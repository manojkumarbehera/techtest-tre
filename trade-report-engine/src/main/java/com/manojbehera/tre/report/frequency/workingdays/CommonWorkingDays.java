package com.manojbehera.tre.report.frequency.workingdays;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Manoj Kumar Behera
 *
 */
public enum CommonWorkingDays {

	MONDAY(DayOfWeek.MONDAY, true), 
	TUESDAY(DayOfWeek.TUESDAY, true),
	WEDNESDAY(DayOfWeek.WEDNESDAY, true),
	THURSDAY(DayOfWeek.THURSDAY, true),
	FRIDAY(DayOfWeek.FRIDAY, true),
	SATURDAY(DayOfWeek.SATURDAY, false),
	SUNDAY(DayOfWeek.SUNDAY, false);

	private DayOfWeek day;
	private boolean isWorkingDay;
	private static Map<DayOfWeek, Boolean> workingDayMap;

	CommonWorkingDays(DayOfWeek day, boolean isWorkingDay) {
		this.day = day;
		this.isWorkingDay = isWorkingDay;

	}

	public static Map<DayOfWeek, Boolean> getWorkingDaysMap() {

		workingDayMap = new HashMap<>();

		CommonWorkingDays[] values = CommonWorkingDays.values();

		for (CommonWorkingDays each : values) {
			workingDayMap.put(each.getDay(), each.isWorkingDay);
		}

		return workingDayMap;

	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public boolean isWorkingDay() {
		return isWorkingDay;
	}

	public void setWorkingDay(boolean isWorkingDay) {
		this.isWorkingDay = isWorkingDay;
	}

	public Map<DayOfWeek, Boolean> getWorkingDayMap() {
		return workingDayMap;
	}

}
