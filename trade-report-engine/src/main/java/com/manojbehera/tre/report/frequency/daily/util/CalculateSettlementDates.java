package com.manojbehera.tre.report.frequency.daily.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Map;
import java.util.Set;

import com.manojbehera.tre.model.data.TradeData;
import com.manojbehera.tre.report.frequency.workingdays.CommonWorkingDays;
import com.manojbehera.tre.report.frequency.workingdays.SundayWorkingDays;

/**
 * @author Manoj Kumar Behera
 *
 */
public class CalculateSettlementDates {

	public void calculateSettlementDates(Set<TradeData> tradeData) {

		tradeData.stream().forEach(eachData -> {

			LocalDate newSettlementDate = calculateSettlementDate(eachData);

			eachData.setUpdatedSettlementDate(newSettlementDate);

			if (eachData.getSettlementDate().compareTo(newSettlementDate) != 0) {
				eachData.setNote("The settlement date get changed");
			}
		});

	}

	public LocalDate calculateSettlementDate(TradeData tradeData) {

		Map<DayOfWeek, Boolean> workingDays = calculateWorkingDays(tradeData.getCurrency());
		final LocalDate updatedSettlementDate = calculateFirstWorkingDate(tradeData.getSettlementDate(), workingDays);

		return updatedSettlementDate;

	}

	private LocalDate calculateFirstWorkingDate(LocalDate date, Map<DayOfWeek, Boolean> workingDays) {

		final DayOfWeek inputDay = date.getDayOfWeek();

		if (workingDays.get(inputDay)) {
			return date;
		} else {
			return calculateFirstWorkingDate(date.plusDays(1), workingDays);
		}
	}

	private static Map<DayOfWeek, Boolean> calculateWorkingDays(Currency currency) {

		Map<DayOfWeek, Boolean> workingDaysMap = null;

		if ((currency.getCurrencyCode().equals("AED")) || (currency.getCurrencyCode().equals("SAR"))) {

			workingDaysMap = SundayWorkingDays.getWorkingDaysMap();

		} else {

			workingDaysMap = CommonWorkingDays.getWorkingDaysMap();
		}

		return workingDaysMap;

	}

}
