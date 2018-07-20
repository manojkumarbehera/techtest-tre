package com.manojbehera.tre.manager;

/**
 * @author Manoj Kumar Behera
 *
 */
public class ReportingFrequencyManagerFactory {

	private ReportingFrequencyManagerFactory() {

	}

	public static ReportingFrequencyManager createReportingFrequencyManager(String frequencyType) {

		if (frequencyType.equals("DAILY")) {
			return new DailyReportingManager();
		} /*
			 * else if (frequencyType.equals("WEEKLY")) { }
			 */

		return null;
	}
}
