package edu.arielperez.advancedjava.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class StockServiceFactoryTest {

	StockService testStockService = StockServiceFactory.getSockService();

	@Test
	public void testFactoryClass() {
		assertTrue(testStockService instanceof StockService);
	}

	@Test
	public void negTestFactoryClass() {
		assertFalse(!(testStockService instanceof StockService));
	}

}
