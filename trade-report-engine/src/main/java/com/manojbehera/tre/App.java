package com.manojbehera.tre;

import com.manojbehera.tre.manager.ReportingFrequencyManager;
import com.manojbehera.tre.manager.ReportingFrequencyManagerFactory;
import com.manojbehera.tre.report.ReportingFrequency;

/**
 * @author Manoj Kumar Behera
 *
 */
public class App {

	public static void main(String[] args) {

		ReportingFrequencyManager frequencyManager = ReportingFrequencyManagerFactory
				.createReportingFrequencyManager("DAILY");

		tradeDailyReporting(frequencyManager);
	}

	private static void tradeDailyReporting(ReportingFrequencyManager frequencyManager) {

		ReportingFrequency dailyReporting = frequencyManager.createReportingFrequency("DAILY");
		System.out.println("=========== " + dailyReporting.getReportingType() + " Reprting ===========");

		dailyReporting.processToGenerateReport();

	}

}
