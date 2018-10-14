package edu.arielperez.advancedjava.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edu.arielperez.advancedjava.model.StockQuote;

/**
 * JUnit tests for StockServiceFactory class
 * 
 * @author aperez
 *
 */
public class StockServiceFactoryTest {

	StockService testStockService;

	@Before
	public void setup() {
		testStockService = StockServiceFactory.getSockService();
	}

	@Test
	public void testFactoryClass() {
		assertTrue("StockService.getStockService is not an instace of StockService",
				testStockService instanceof StockService);
	}

	@Test
	public void testStockServiceGetQuote() {
		StockQuote testStockQuote = testStockService.getQuote("LLL");
		assertTrue("Implemented StockService class not returning the correct symbol ",
				testStockQuote.getStockSymbol() == "LLL");
	}

	@Test
	public void testStockServiceGetStockPrice() {
		StockQuote testStockQuote = testStockService.getQuote("LLL");
		assertTrue("Implemented StockService class not returning the BigDecimal as a price",
				testStockQuote.getStockPrice() instanceof BigDecimal);
	}

	@Test
	public void testStockServiceGetDateRecorded() {
		StockQuote testStockQuote = testStockService.getQuote("LLL");
		assertTrue("Implemented StockService class not returning the Date as a price date",
				testStockQuote.getDateRecorded() instanceof Date);
	}
	
	
}
