package com.manojbehera.tre.manager;

import com.manojbehera.tre.report.ReportingFrequency;

/**
 * @author Manoj Kumar Behera
 *
 */
public abstract class ReportingFrequencyManager {

	ReportingFrequency processReportingFrequency(String type) {

		ReportingFrequency reportingFrequency = createReportingFrequency(type);

		// Some set of common code can execute here

		return reportingFrequency;
	}

	public abstract ReportingFrequency createReportingFrequency(String type);
}
