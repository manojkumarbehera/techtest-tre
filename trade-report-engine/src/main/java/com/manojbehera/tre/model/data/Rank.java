package com.manojbehera.tre.model.data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Manoj Kumar Behera
 *
 */
public class Rank {
	private final int rankNo;
	private final String entity;
	private final LocalDate date;
	private final BigDecimal totalUsdTradeAmount;

	public Rank(int rankNo, String entity, LocalDate date, BigDecimal totalUsdTradeAmount) {
		this.rankNo = rankNo;
		this.entity = entity;
		this.date = date;
		this.totalUsdTradeAmount = totalUsdTradeAmount;
	}

	public int getRankNo() {
		return rankNo;
	}

	public String getEntity() {
		return entity;
	}

	public LocalDate getDate() {
		return date;
	}

	public BigDecimal getTotalUsdTradeAmount() {
		return totalUsdTradeAmount;
	}

	@Override
	public String toString() {
		return "Rank [rankNo=" + rankNo + ", entity=" + entity + ", date=" + date + ", totalUsdTradeAmount="
				+ totalUsdTradeAmount + "]";
	}

}
