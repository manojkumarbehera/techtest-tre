package com.manojbehera.tre.report.frequency.daily;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.manojbehera.tre.model.data.Rank;
import com.manojbehera.tre.model.data.TradeData;
import com.manojbehera.tre.report.ReportingFrequency;
import com.manojbehera.tre.report.frequency.daily.util.CalculateRank;
import com.manojbehera.tre.report.frequency.daily.util.CalculateSettlementDates;
import com.manojbehera.tre.report.frequency.daily.util.CalculateUsdAmount;
import com.manojbehera.tre.repository.TradeRepository;
import com.manojbehera.tre.repository.impl.TradeRepositoryImpl;

/**
 * @author Manoj Kumar Behera
 *
 */
public class DailyReporting extends ReportingFrequency {

	@Override
	public Set<TradeData> collectTradeData() {

		TradeRepository tradeRepository = new TradeRepositoryImpl();
		Set<TradeData> allTradeData = tradeRepository.findAllTradeDta();
		printTradeData(allTradeData);
		return allTradeData;
	}

	@Override
	public void calculateSettlementDates(Set<TradeData> tradeData, CalculateSettlementDates calculateSettlementDates) {

		calculateSettlementDates.calculateSettlementDates(tradeData);

		printUpdatedSettlementDates(tradeData);
	}

	@Override
	public void calculateOutGoingAmount(Set<TradeData> tradeData, CalculateUsdAmount calculateUsdAmount) {

		Map<LocalDate, Map<BigDecimal, List<String>>> outgoingAmount = calculateUsdAmount
				.calculateOutgoingAmount(tradeData);
		printOutGoingAndInComingAmount("OUTGOING (daily)", outgoingAmount);

	}

	@Override
	public void calculateIncomingAmount(Set<TradeData> tradeData, CalculateUsdAmount calculateUsdAmount) {
		Map<LocalDate, Map<BigDecimal, List<String>>> incomingAmount = calculateUsdAmount
				.calculateIncomingAmount(tradeData);
		printOutGoingAndInComingAmount("INCOMING (daily)", incomingAmount);
	}

	@Override
	public void calculateOutgoingRank(Set<TradeData> tradeData, CalculateRank calculateRank) {

		Map<LocalDate, LinkedList<Rank>> outgoingRank = calculateRank.calculateOutgoingRank(tradeData);
		printRank("OUTGOING", outgoingRank);

	}

	@Override
	public void calculateIncomingRank(Set<TradeData> tradeData, CalculateRank calculateRank) {

		Map<LocalDate, LinkedList<Rank>> incomingRank = calculateRank.calculateIncomingRank(tradeData);
		printRank("INCOMING", incomingRank);

	}
	
	public static void printTradeData(Set<TradeData> tradeData) {
		
		System.out.println("=========== " + "Trade Data" + " =========== " + tradeData.size() + " entries");
		
		StringBuilder sb = new StringBuilder();
		sb
	      	.append("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n")
			.append("     Entity \t|\t\t Buy/Sell \t|\t\t AgreedFx \t|\t\t Currency \t|\t\t InstructionDate \t|\t\t SettlementDate \t|\t\t    Units \t|\t\t  Price per unit     \n")
			.append("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		
		for (TradeData each : tradeData) {
			sb
            .append(each.getEntityName()).append("\t\t|\t\t")
            .append(each.getTradeType()).append("\t\t|\t\t")
            .append(each.getAgreedFx()).append("\t\t|\t\t")
            .append(each.getCurrency()).append("\t\t|\t\t")
            .append(each.getInstructionDate()).append("\t\t|\t\t")
            .append(each.getSettlementDate()).append("\t\t|\t\t")
            .append(each.getUnits()).append("\t\t|\t\t")
            .append(each.getPricePerUnit()).append("\t\t|\t\t")
            .append("\n");
		}
		sb.append("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		
		System.out.println(sb);
		
	}

	private void printUpdatedSettlementDates(final Set<TradeData> tradeData) {

		System.out.println("=========== " + "UPDATED SETTLEMENTDATES" + " =========== ");

		StringBuilder sb = new StringBuilder();
		sb.append(
				"\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n")
				.append("     Entity \t|\t\t Currency \t|\t\t Settlement Date \t\t|\t    Updated Settlement Date \t\t|\t\t    Note \t|\t\t   \n")
				.append("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

		for (TradeData each : tradeData) {
			String note = each.getNote();
			if (!note.equals("")) {
				note = note + "\t|";
			}
			sb.append(each.getEntityName()).append("\t\t|\t\t").append(each.getCurrency()).append("\t\t|\t\t")
					.append(each.getSettlementDate()).append("(").append(each.getSettlementDate().getDayOfWeek())
					.append(")").append("\t\t|\t\t").append(each.getUpdatedSettlementDate()).append("(")
					.append(each.getUpdatedSettlementDate().getDayOfWeek()).append(")").append("\t\t|\t").append(note)
					.append("\n");
		}

		System.out.println(sb);

	}

	private void printOutGoingAndInComingAmount(String string,
			Map<LocalDate, Map<BigDecimal, List<String>>> outgoingAmount) {

		System.out.println("=========== " + string + " =========== ");
		StringBuilder sb = new StringBuilder();
		sb.append(
				"\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n")
				.append("     Settlement Date \t\t|\t    Total Amount \t\t|\t\t    Entities with amount \t|\t\t   \n")
				.append("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

		Set<Entry<LocalDate, Map<BigDecimal, List<String>>>> entrySet = outgoingAmount.entrySet();

		for (Entry<LocalDate, Map<BigDecimal, List<String>>> each : entrySet) {

			Map<BigDecimal, List<String>> value = each.getValue();
			Entry<BigDecimal, List<String>> entry = value.entrySet().stream().findFirst().get();

			sb.append(each.getKey()).append("(").append(each.getKey().getDayOfWeek()).append(")").append("\t\t|\t\t")
					.append(entry.getKey()).append("\t\t|\t\t").append(entry.getValue()).append("\t\t\t|\t\t")
					.append("\n");
		}

		System.out.println(sb);

	}

	private void printRank(String type, Map<LocalDate, LinkedList<Rank>> ranks) {

		System.out.println("=========== " + type + " rank" + " =========== ");

		StringBuilder sb = new StringBuilder();
		sb.append(
				"\n--------------------------------------------------------------------------------------------------------------------------------\n")
				.append("     Updated Settlement Date \t|\t Rank \t\t|\t\t Entity \t|\t    Amount \t\t|\t\t    \n")
				.append("---------------------------------------------------------------------------------------------------------------------------\n");

		for (LocalDate date : ranks.keySet()) {
			for (Rank rank : ranks.get(date)) {
				sb.append(date).append("\t\t\t|\t\t").append(rank.getRankNo()).append("\t|\t\t").append(rank.getEntity())
						.append("\t\t|\t\t").append(rank.getTotalUsdTradeAmount()).append("\t|\t\t").append("\n");
			}
		}

		System.out.println(sb);
	}

}
