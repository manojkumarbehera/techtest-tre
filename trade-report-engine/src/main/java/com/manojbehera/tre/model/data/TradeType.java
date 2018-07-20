package com.manojbehera.tre.model.data;

/**
 * @author Manoj Kumar Behera
 *
 */
public enum TradeType {

	BUY("B"), 
	SELL("S");

	private String text;

	TradeType(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

}
