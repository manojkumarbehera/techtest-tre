package com.manojbehera.tre.manager;

import com.manojbehera.tre.report.ReportingFrequency;
import com.manojbehera.tre.report.frequency.daily.DailyReporting;

/**
 * @author Manoj Kumar Behera
 *
 */
public class DailyReportingManager extends ReportingFrequencyManager {

	@Override
	public ReportingFrequency createReportingFrequency(String type) {

		ReportingFrequency dailyReporting = new DailyReporting();
		dailyReporting.setReportingType("DAILY");

		return dailyReporting;
	}

	// Daily Reporting specific code

}
