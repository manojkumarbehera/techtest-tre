package com.manojbehera.tre.report.frequency.workingdays;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public enum SundayWorkingDays {

	SUNDAY(DayOfWeek.SUNDAY, true),
	MONDAY(DayOfWeek.MONDAY, true),
	TUESDAY(DayOfWeek.TUESDAY, true),
	WEDNESDAY(DayOfWeek.WEDNESDAY, true),
	THURSDAY(DayOfWeek.THURSDAY, true),
	FRIDAY(DayOfWeek.FRIDAY, false),
	SATURDAY(DayOfWeek.SATURDAY, false);

	private DayOfWeek day;
	private boolean isWorkingDay;
	private static Map<DayOfWeek, Boolean> workingDayMap;

	SundayWorkingDays(DayOfWeek day, boolean isWorkingDay) {
		this.day = day;
		this.isWorkingDay = isWorkingDay;

	}

	public static Map<DayOfWeek, Boolean> getWorkingDaysMap() {

		workingDayMap = new HashMap<>();

		SundayWorkingDays[] values = SundayWorkingDays.values();

		for (SundayWorkingDays each : values) {
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
