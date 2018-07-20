package com.manojbehera.tre.report;

import java.util.Set;

import com.manojbehera.tre.model.data.TradeData;
import com.manojbehera.tre.report.frequency.daily.util.CalculateRank;
import com.manojbehera.tre.report.frequency.daily.util.CalculateSettlementDates;
import com.manojbehera.tre.report.frequency.daily.util.CalculateUsdAmount;

/**
 * @author Manoj Kumar Behera
 *
 */
public abstract class ReportingFrequency {

	private String reportingType;

	public final void processToGenerateReport() {

		CalculateSettlementDates calculateSettlementDates = new CalculateSettlementDates();
		CalculateUsdAmount calculateUsdAmount = new CalculateUsdAmount();
		CalculateRank calculateRank = new CalculateRank();

		Set<TradeData> tradeData = collectTradeData();

		calculateSettlementDates(tradeData, calculateSettlementDates);
		calculateOutGoingAmount(tradeData, calculateUsdAmount);
		calculateIncomingAmount(tradeData, calculateUsdAmount);
		calculateOutgoingRank(tradeData, calculateRank);
		calculateIncomingRank(tradeData, calculateRank);

	}

	public abstract Set<TradeData> collectTradeData();

	public abstract void calculateSettlementDates(Set<TradeData> tradeData,
			CalculateSettlementDates calculateSettlementDates);

	public abstract void calculateOutGoingAmount(Set<TradeData> tradeData, CalculateUsdAmount calculateUsdAmount);

	public abstract void calculateIncomingAmount(Set<TradeData> tradeData, CalculateUsdAmount calculateUsdAmount);

	public abstract void calculateOutgoingRank(Set<TradeData> tradeData, CalculateRank calculateRank);

	public abstract void calculateIncomingRank(Set<TradeData> tradeData, CalculateRank calculateRank);

	public String getReportingType() {
		return reportingType;
	}

	public void setReportingType(String reportingType) {
		this.reportingType = reportingType;
	}

}
