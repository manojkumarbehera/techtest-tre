package com.manojbehera.tre.repository.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import com.manojbehera.tre.model.data.TradeData;
import com.manojbehera.tre.model.data.TradeType;

/**
 * @author Manoj Kumar Behera
 *
 */
public class TradeDummyData {

	public static Set<TradeData> findAllTradeDummyData() {

		TradeData[] tradeDataArr = {

				new TradeData("foofo1", 
							   TradeType.BUY, 
							   LocalDate.of(2016, 1, 1), 
							   LocalDate.of(2016, 1, 2),
						   				Currency.getInstance("SGD"),
						   				BigDecimal.valueOf(0.50), 
						   				200,
						   				BigDecimal.valueOf(100.25)),
				
				new TradeData("foofo2", 
						   TradeType.BUY, 
						   LocalDate.of(2016, 1, 1), 
						   LocalDate.of(2016, 1, 2),
					   				Currency.getInstance("SGD"),
					   				BigDecimal.valueOf(0.51), 
					   				200,
					   				BigDecimal.valueOf(100.25)),
				
				new TradeData("foo-1", 
						   TradeType.BUY, 
						   LocalDate.of(2016, 1, 2), 
						   LocalDate.of(2016, 1, 5),
						   		
						   				Currency.getInstance("SGD"),
						   				BigDecimal.valueOf(0.58), 
						   				123,
						   				BigDecimal.valueOf(200.35)),
				
				new TradeData("barbar", 
						   TradeType.SELL, 
						   LocalDate.of(2016, 1, 5), 
						   LocalDate.of(2016, 1, 7),
						   	
						   				Currency.getInstance("AED"),
						   				BigDecimal.valueOf(0.52), 
						   				250,
						   				BigDecimal.valueOf(76.5)),
				
				new TradeData("indsat1", 
						   TradeType.BUY, 
						   LocalDate.of(2018, 1, 5), 
						   LocalDate.of(2018, 7, 14),
						   		
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(1.52), 
						   				152,
						   				BigDecimal.valueOf(123.5)),
				
				new TradeData("indsat2", 
						   TradeType.BUY, 
						   LocalDate.of(2018, 1, 5), 
						   LocalDate.of(2018, 7, 14),
						   		
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(1.53), 
						   				152,
						   				BigDecimal.valueOf(123.5)),
				
				new TradeData("indtue1", 
						   TradeType.SELL, 
						   LocalDate.of(2018, 1, 5), 
						   LocalDate.of(2018, 7, 17),
						   		
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(0.73), 
						   				99,
						   				BigDecimal.valueOf(88.5)),
				
				new TradeData("indTue2", 
						   TradeType.SELL, 
						   LocalDate.of(2018, 1, 5), 
						   LocalDate.of(2018, 7, 17),
						   	
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(0.74), 
						   				99,
						   				BigDecimal.valueOf(88.5)),
				
				new TradeData("indtue3", 
						   TradeType.SELL, 
						   LocalDate.of(2018, 1, 5), 
						   LocalDate.of(2018, 7, 17),
						   	
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(0.22), 
						   				99,
						   				BigDecimal.valueOf(88.5)),
				
				new TradeData("indtue4", 
						   TradeType.SELL, 
						   LocalDate.of(2018, 1, 5), 
						   LocalDate.of(2018, 7, 17),
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(0.99), 
						   				99,
						   				BigDecimal.valueOf(88.5)),
				
				new TradeData("ArabFri", 
						   TradeType.BUY, 
						   LocalDate.of(2018, 1, 5), 
						   LocalDate.of(2018, 7, 13),
						   				Currency.getInstance("AED"),
						   				BigDecimal.valueOf(0.39), 
						   				123,
						   				BigDecimal.valueOf(98.5)),
				
				new TradeData("ArabSun", 
						   TradeType.SELL, 
						   LocalDate.of(2018, 1, 5), 
						   LocalDate.of(2018, 7, 15),
						   				Currency.getInstance("AED"),
						   				BigDecimal.valueOf(0.50), 
						   				350,
						   				BigDecimal.valueOf(182.5)),
				
				new TradeData("t1+t2-1", 
						   TradeType.SELL, 
						   LocalDate.of(2018, 7, 6), 
						   LocalDate.of(2018, 7, 18),
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(2), 
						   				300,
						   				BigDecimal.valueOf(8.9)),
				
				new TradeData("t1+t2-2", 
						   TradeType.SELL, 
						   LocalDate.of(2018, 7, 6), 
						   LocalDate.of(2018, 7, 18),
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(8), 
						   				100,
						   				BigDecimal.valueOf(4.9)),
				
				new TradeData("t1+t2-3", 
						   TradeType.SELL, 
						   LocalDate.of(2018, 7, 6), 
						   LocalDate.of(2018, 7, 18),
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(7.98), 
						   				900,
						   				BigDecimal.valueOf(4.9)),
				
				new TradeData("t3+t4-1", 
						   TradeType.BUY, 
						   LocalDate.of(2018, 7, 6), 
						   LocalDate.of(2018, 7, 18),
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(9.89), 
						   				400,
						   				BigDecimal.valueOf(9.9)),
				
				new TradeData("t3+t4-2", 
						   TradeType.BUY, 
						   LocalDate.of(2018, 7, 6), 
						   LocalDate.of(2018, 7, 18),
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(2.9), 
						   				1200,
						   				BigDecimal.valueOf(5.9)),
				
				
				new TradeData("t3+t4-3", 
						   TradeType.BUY, 
						   LocalDate.of(2018, 7, 6), 
						   LocalDate.of(2018, 7, 18),
						   				Currency.getInstance("INR"),
						   				BigDecimal.valueOf(3), 
						   				150,
						   				BigDecimal.valueOf(4))
				};
				

		return new HashSet<>(Arrays.asList(tradeDataArr));

	}
}
