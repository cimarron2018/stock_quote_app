package edu.arielperez.advancedjava.service;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

import edu.arielperez.advancedjava.model.StockQuote;

public class BasicStockServiceTest {

	BasicStockService testBasicStockService = new BasicStockService();
	StockQuote testQuote = testBasicStockService.getQuote("ALL");

	// Set dates: from and to dates
	Calendar fromDate = new GregorianCalendar(2018, 0, 31);
	Calendar toDate = new GregorianCalendar(2018, 1, 2);

	// Call the Factory Class to get the service
	StockService stockServiceImplementation = StockServiceFactory.getSockService();

	// Calls the getQuote method to pull price information between two dates for a
	// stock symbol
	List<StockQuote> listPrices = stockServiceImplementation.getQuote("APP", fromDate, toDate);

	@Test
	public void testGetQuote() {
		assertTrue(testQuote.getStockPrice().doubleValue() == 99.99);
	}

	@Test
	public void negTestGetQuote() {
		assertFalse(!(testQuote.getStockPrice().doubleValue() == 99.99));
	}

	@Test
	public void testGetQuoteDate() {
		assertTrue(listPrices instanceof List<?>);
	}

}
