package edu.arielperez.advancedjava.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.arielperez.advancedjava.model.StockQuote;

/**
 * Basic implementation of the StockService interface
 */
class BasicStockService implements StockService {

	/**
	 * Constructor set to private
	 */
	BasicStockService() {

	}

	/**
	 * Return the <CODE>StockData</CODE> for the given symbol for the given date.
	 * Used to get history data for the stock.
	 *
	 * @param symbol the stock symbol of the company you want a quote for. e.g. APPL
	 *               for APPLE
	 *
	 * @return a StockQuote instance
	 */
	@Override
	public StockQuote getQuote(String symbol) {

		BigDecimal price;
		// hard-coded values
		if (symbol.equalsIgnoreCase("ALL")) {
			price = new BigDecimal(99.99); // ALL -> Allstate Corporation
		} else {
			price = new BigDecimal(Math.random() * 100);
		}
		return new StockQuote(symbol, price, new Date());
	}

	/**
	 * 
	 * Get a historical list of stock quotes for the provided symbol
	 * 
	 * @param symbol the stock symbol to search for
	 * @param from   the date of the first stock quote
	 * @param until  the date of the last stock quote
	 * @return a list of StockQuote instances. One for each day in the range
	 *         specified.
	 */
	public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {

		// Create List of StockQuote objects to return
		List<StockQuote> stockQuoteList = new ArrayList<StockQuote>();

		// Add one day to the until variable to ensure the last date is included in the
		// results
		until.add(Calendar.DATE, 1);

		// Loop through the dates and pulls the price for each date
		for (Calendar dates = from; dates.before(until); dates.add(Calendar.DATE, 1)) {
			// At this time not a real implementation
			stockQuoteList.add(new StockQuote(symbol, new BigDecimal(93.99), dates.getTime()));

		}

		return stockQuoteList;
	}

}
