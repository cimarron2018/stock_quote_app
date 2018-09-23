package edu.arielperez.advancedjava.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This a simple container class.
 */
public class StockQuote {

	private String stockSymbol;
	private BigDecimal stockPrice;
	private Date dateRecorded;

	/**
	 * Class constructor specifying the stockSymbol, stockPrice, and the
	 * dateRecorded.
	 * 
	 * @param stockSymbolValue  a unique series of letters representing the stock
	 *                          for trading purposes
	 * @param stockPriceValue   the price of the stock
	 * @param dateRecordedValue as-of date
	 */
	public StockQuote(String stockSymbolValue, BigDecimal stockPriceValue, Date dateRecordedValue) {
		super();
		this.stockSymbol = stockSymbolValue;
		this.stockPrice = stockPriceValue;
		this.dateRecorded = dateRecordedValue;
	}

	/**
	 * 
	 * @return the stockSymbol (a unique series of letters representing the stock
	 *         for trading purposes)
	 */
	public String getStockSymbol() {
		return stockSymbol;
	}

	/**
	 * 
	 * @param stockSymbol the stockSymbol to set (a unique series of letters
	 *                    representing the stock for trading purposes)
	 */
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	/**
	 * @return the stockPrice (returns the price of the stock as of dateRecorded)
	 */
	public BigDecimal getStockPrice() {
		return stockPrice;
	}

	/**
	 * @param stockPrice the stockPrice to set (set the price for the stock as of
	 *                   dateRecorded)
	 */
	public void setStockPrice(BigDecimal stockPrice) {
		this.stockPrice = stockPrice;
	}

	/**
	 * @return the dateRecorded (returns the date the price was pulled)
	 */
	public Date getDateRecorded() {
		return dateRecorded;
	}

	/**
	 * @param dateRecorded the dateRecorded to set (sets the date the price was set)
	 */
	public void setDateRecorded(Date dateRecorded) {
		this.dateRecorded = dateRecorded;
	}

	/**
	 * Returns all the attributes of the StockQuote object: symbol, stockPrice,
	 * dateRecorded
	 * 
	 * @return String including symbol, stockPrice, and dateRecorded
	 */
	@Override
	public String toString() {

		return "Symbol: " + stockSymbol + " Date: " + new SimpleDateFormat("MM-dd-yyyy").format(dateRecorded)
				+ " Price: " + NumberFormat.getCurrencyInstance().format(stockPrice);
	}

}
