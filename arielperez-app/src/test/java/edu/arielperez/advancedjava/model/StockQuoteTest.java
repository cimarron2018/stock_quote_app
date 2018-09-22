package edu.arielperez.advancedjava.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

public class StockQuoteTest {

	StockQuote testStockQuote = new StockQuote("LLL", new BigDecimal(21.22), new Date(8099));

	@Test
	public void testGetStockPrice() {
		assertTrue(testStockQuote.getStockPrice().doubleValue() == 21.22);
	}

	@Test
	public void testGetDateRecorded() {
		assertTrue(testStockQuote.getDateRecorded().equals(new Date(8099)));
	}

	@Test
	public void testGet() {
		assertTrue(testStockQuote.getStockSymbol().equalsIgnoreCase("LLL"));
	}

	@Test
	public void negTestGetStockPrice() {
		assertFalse(!(testStockQuote.getStockPrice().doubleValue() == 21.22));
	}

	@Test
	public void negTestGetDateRecorded() {
		assertFalse(!(testStockQuote.getDateRecorded().equals(new Date(8099))));
	}

	@Test
	public void negTestGetStickSymbol() {
		assertFalse(!(testStockQuote.getStockSymbol().equalsIgnoreCase("LLL")));
	}

}
