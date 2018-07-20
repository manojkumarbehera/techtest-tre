package com.manojbehera.tre.repository;

import java.util.Set;

import com.manojbehera.tre.model.data.TradeData;

/**
 * @author Manoj Kumar Behera
 *
 */
public interface TradeRepository {
	public Set<TradeData> findAllTradeDta();
}
