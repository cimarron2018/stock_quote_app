package edu.arielperez.advancedjava.service;

import edu.arielperez.advancedjava.model.StockQuote;

/**
 * This interface describes a simple API for getting stock data.
 */
interface StockService {
	/**
	 * Return the <CODE>StockData</CODE> for the given symbol for the given date.
	 * Used to get history data for the stock.
	 *
	 * @param symbol the stock symbol of the company you want a quote for. e.g. APPL
	 *               for APPLE
	 *
	 * @return a StockQuote instance
	 */
	StockQuote getQuote(String symbol);
}
