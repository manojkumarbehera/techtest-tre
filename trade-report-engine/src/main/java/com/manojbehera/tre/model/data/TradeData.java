package com.manojbehera.tre.model.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

/**
 * @author Manoj Kumar Behera
 *
 */
public class TradeData {

	private final String entityName;
	private final TradeType tradeType;
	private final LocalDate instructionDate;
	private final LocalDate settlementDate;
	private final Currency currency;
	private final BigDecimal agreedFx;
	private final int units;
	private final BigDecimal pricePerUnit;

	private LocalDate updatedSettlementDate;
	private final BigDecimal totalUsdAmount;
	private String note = "";

	public TradeData(String entityName, TradeType tradeType, LocalDate instructionDate, LocalDate settlementDate,
			Currency currency, BigDecimal agreedFx, int units, BigDecimal pricePerUnit) {
		this.entityName = entityName;
		this.tradeType = tradeType;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.currency = currency;
		this.agreedFx = agreedFx;
		this.units = units;
		this.pricePerUnit = pricePerUnit;

		this.totalUsdAmount = calculateTotalUsdAmount(this);
	}

	private BigDecimal calculateTotalUsdAmount(TradeData tcd) {
		return tcd.getPricePerUnit().multiply(BigDecimal.valueOf(tcd.getUnits())).multiply(tcd.getAgreedFx());
	}

	public String getEntityName() {
		return entityName;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public Currency getCurrency() {
		return currency;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public int getUnits() {
		return units;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public LocalDate getUpdatedSettlementDate() {
		return updatedSettlementDate;
	}

	public void setUpdatedSettlementDate(LocalDate updatedSettlementDate) {
		this.updatedSettlementDate = updatedSettlementDate;
	}

	public BigDecimal getTotalUsdAmount() {
		return totalUsdAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "TradeData [entityName=" + entityName + ", tradeType=" + tradeType + ", instructionDate="
				+ instructionDate + ", settlementDate=" + settlementDate + ", currency=" + currency + ", agreedFx="
				+ agreedFx + ", units=" + units + ", pricePerUnit=" + pricePerUnit + ", updatedSettlementDate="
				+ updatedSettlementDate + ", totalUsdAmount=" + totalUsdAmount + ", note=" + note + "]";
	}

}
