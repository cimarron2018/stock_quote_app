package edu.arielperez.advancedjava.service;

/**
 * A StockService factory class that returns a concrete implementation of the
 * interface
 * 
 *
 */
public class ServiceFactory {

	/**
	 * Constructor is private
	 */
	private ServiceFactory() {

	}

	/**
	 * Returns an implementation of the StockService interface
	 * 
	 * @return a StockService implementation
	 */
	public static StockService getSockService() {

		// return new BasicStockService();
		return new DatabaseStockService();

	}

	/**
	 * Returns an implementation of the PersonService interface
	 *
	 * @return a PersonService implementation
	 */
	public static PersonService getPersonService() {

		// return new BasicStockService();
		return new DatabasePersonService();

	}

    /**
     * Returns an implementation of the PersonService interface
     *
     * @return a PersonService implementation
     */
    public static QuoteService getQuoteService() {

        // return new BasicStockService();
        return new DatabaseQuoteService();

    }

}
