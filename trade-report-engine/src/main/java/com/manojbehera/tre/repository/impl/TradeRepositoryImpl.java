package com.manojbehera.tre.repository.impl;

import java.util.Set;

import com.manojbehera.tre.model.data.TradeData;
import com.manojbehera.tre.repository.TradeRepository;

/**
 * @author Manoj Kumar Behera
 *
 */
public class TradeRepositoryImpl implements TradeRepository {

	@Override
	public Set<TradeData> findAllTradeDta() {
		Set<TradeData> findAllTradeDummyData = TradeDummyData.findAllTradeDummyData();
		return findAllTradeDummyData;
	}

}
