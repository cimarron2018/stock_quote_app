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
     * Constructor only accessible in the package
     */
    BasicStockService() {

    }

    /**
     * Return the <CODE>StockData</CODE> for the given symbol for the given date.
     * Used to get history data for the stock.
     *
     * @param symbol the stock symbol of the company you want a quote for. e.g. APPL
     *               for APPLE
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
     * Get a historical list of stock quotes for the provided symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances. One for each day in the range
     * specified.
     */
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {

        // Create List of StockQuote objects to return
        List<StockQuote> stockQuoteList = new ArrayList<StockQuote>();
        Calendar fromDate = (Calendar) from.clone();
        Calendar toDate = (Calendar) until.clone();

        // Add one day to the until variable to ensure the last date is included in the
        // results
        toDate.add(Calendar.DATE, 1);

        // Loop through the dates and pulls the price for each date
        for (Calendar dates = fromDate; dates.before(toDate); dates.add(Calendar.DATE, 1)) {
            // At this time not a real implementation
            stockQuoteList.add(new StockQuote(symbol, new BigDecimal(93.99), dates.getTime()));

        }

        return stockQuoteList;
    }

    /**
     * Get a historical list of stock quotes for the provided symbol This method
     * will return an StockQuote per interval specified
     *
     * @param symbol   the stock symbol to search for
     * @param from     the date of the first stock quote
     * @param until    the date of the last stock quote
     * @param interval the number of StockQuotes to get, E.g. if Interval.DAILY was
     *                 specified one StockQuote per day will be returned.
     * @return a list of StockQuote instances. One for each day in the range
     * specified.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval) {
        // Create List of StockQuote objects to return
        List<StockQuote> stockQuoteList = new ArrayList<StockQuote>();
        Calendar fromDate = (Calendar) from.clone();
        Calendar toDate = (Calendar) until.clone();

        // Add one day to the until variable to ensure the last date is included in the
        // results
        until.add(Calendar.DATE, 1);

        // Variable to hold interval
        int intervalVar = Calendar.DATE;

        switch (interval) {
            case DAILY:
                intervalVar = Calendar.DATE;
                break;
            case WEEKLY:
                intervalVar = Calendar.DATE;
                break;
            case MONTHLY:
                intervalVar = Calendar.MONTH;
                break;
            case YEARLY:
                intervalVar = Calendar.YEAR;
                break;
        }

        // Loop through the dates and pulls the price for each date
        for (Calendar dates = fromDate; dates.before(toDate); dates.add(intervalVar, 1)) {
            // At this time not a real implementation
            stockQuoteList.add(new StockQuote(symbol, new BigDecimal(93.99), dates.getTime()));
        }

        return stockQuoteList;
    }

}
