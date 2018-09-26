package edu.arielperez.advancedjava.service;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import edu.arielperez.advancedjava.model.StockQuote;

public class BasicStockServiceTest {

	BasicStockService testBasicStockService = new BasicStockService();
	StockQuote testQuote = testBasicStockService.getQuote("ALL");

	@Test
	public void testGetQuote() {
		assertTrue(testQuote.getStockPrice().doubleValue() == 99.99);
	}

	@Test
	public void negTestGetQuote() {
		assertFalse(!(testQuote.getStockPrice().doubleValue() == 99.99));
	}

}
