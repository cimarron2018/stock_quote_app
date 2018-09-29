package edu.arielperez.advancedjava.service;


/**
 * A StockService factory class that returns a concrete implementation of the
 * interface
 * 
 * @author aperez
 *
 */
public class StockServiceFactory {

	/**
	 * Constructor is private
	 */
	private StockServiceFactory() {

	}

	/**
	 * Returns an implementation of the StockService interface
	 * 
	 * @return a StockService implementation
	 */
	public static StockService getSockService() {

		return new BasicStockService();

	}
}
