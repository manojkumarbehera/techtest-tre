package com.manojbehera.tre.report.frequency.daily.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.manojbehera.tre.model.data.TradeData;
import com.manojbehera.tre.model.data.TradeType;

/**
 * @author Manoj Kumar Behera
 *
 */
public class CalculateUsdAmount {

	private final static Predicate<TradeData> outgoingPredicate = tradeData -> tradeData.getTradeType()
			.equals(TradeType.BUY);

	private final static Predicate<TradeData> incomingPredicate = tradeData -> tradeData.getTradeType()
			.equals(TradeType.SELL);

	public Map<LocalDate, Map<BigDecimal, List<String>>> calculateOutgoingAmount(Set<TradeData> tradeData) {

		return calculateTotalAmountPerSettlementDate(tradeData, outgoingPredicate);
	}

	public Map<LocalDate, Map<BigDecimal, List<String>>> calculateIncomingAmount(Set<TradeData> tradeData) {

		return calculateTotalAmountPerSettlementDate(tradeData, incomingPredicate);
	}

	private Map<LocalDate, Map<BigDecimal, List<String>>> calculateTotalAmountPerSettlementDate(Set<TradeData> trade,
			Predicate<TradeData> predicate) {

		Set<TradeData> inOutList = trade.stream().filter(predicate).collect(Collectors.toSet());

		Map<LocalDate, Map<BigDecimal, List<String>>> dateAmountMap = new HashMap<>();

		inOutList.forEach((each -> {

			LocalDate settlementDate = each.getSettlementDate();
			Map<BigDecimal, List<String>> amountEntitiesMap = dateAmountMap.get(settlementDate);

			if (amountEntitiesMap == null) {

				List<String> entities = new ArrayList<>();
				entities.add(each.getEntityName() + "(" + each.getTotalUsdAmount() + ")");
				Map<BigDecimal, List<String>> amountEntitiesMap1 = new HashMap<>();
				amountEntitiesMap1.put(each.getTotalUsdAmount(), entities);

				dateAmountMap.put(settlementDate, amountEntitiesMap1);

			} else {

				Entry<BigDecimal, List<String>> entry = amountEntitiesMap.entrySet().stream().findFirst().get();

				BigDecimal oldWithNewAmount = entry.getKey().add(each.getTotalUsdAmount());
				List<String> list = new ArrayList<>(entry.getValue());
				list.add(each.getEntityName() + "(" + each.getTotalUsdAmount() + ")");

				Map<BigDecimal, List<String>> amountEntitiesMap1 = new HashMap<>();
				amountEntitiesMap1.put(oldWithNewAmount, list);

				dateAmountMap.put(settlementDate, amountEntitiesMap1);

			}

		}));


		return dateAmountMap;
	}

}
