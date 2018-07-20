package com.manojbehera.tre.report.frequency.daily.util;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.manojbehera.tre.model.data.Rank;
import com.manojbehera.tre.model.data.TradeData;
import com.manojbehera.tre.model.data.TradeType;

/**
 * @author Manoj Kumar Behera
 *
 */
public class CalculateRank {

	private final static Predicate<TradeData> outgoingPredicate = tradeData -> tradeData.getTradeType()
			.equals(TradeType.BUY);

	private final static Predicate<TradeData> incomingPredicate = tradeData -> tradeData.getTradeType()
			.equals(TradeType.SELL);

	public Map<LocalDate, LinkedList<Rank>> calculateOutgoingRank(Set<TradeData> tradeData) {

		Map<LocalDate, LinkedList<Rank>> calculateRank = calculateRank(tradeData, outgoingPredicate);
		return calculateRank;

	}

	public Map<LocalDate, LinkedList<Rank>> calculateIncomingRank(Set<TradeData> tradeData) {
		Map<LocalDate, LinkedList<Rank>> calculateRank = calculateRank(tradeData, incomingPredicate);
		return calculateRank;
	}

	private Map<LocalDate, LinkedList<Rank>> calculateRank(Set<TradeData> tradeData, Predicate<TradeData> predicate) {

		Map<LocalDate, Set<TradeData>> dateDtaMap = tradeData.stream().filter(predicate)
				.collect(groupingBy(TradeData::getSettlementDate, toSet()));

		final Map<LocalDate, LinkedList<Rank>> ranking = new TreeMap<>();

		dateDtaMap.forEach((date, theSet) -> {

			List<TradeData> collect = theSet.stream()
					.sorted((amt1, amt2) -> amt2.getTotalUsdAmount().compareTo(amt1.getTotalUsdAmount()))
					.collect(Collectors.toList());

			final AtomicInteger rank = new AtomicInteger(1);

			LinkedList<Rank> allRank = collect.stream().map(tradeCalculation -> new Rank(rank.getAndIncrement(),
					tradeCalculation.getEntityName(), date, tradeCalculation.getTotalUsdAmount()))
					.collect(toCollection(LinkedList::new));

			ranking.put(date, allRank);

		});

		return ranking;
	}
}
