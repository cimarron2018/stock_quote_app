package edu.arielperez.advancedjava.application;

import org.junit.Test;

public class StockQuoteApplicationTest {

	@Test(expected = NullPointerException.class)
	public void testMainAppNullPoinrerException() {
		StockQuoteApplication.main(null);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testMainAppIndexOutOfBounds() {
		StockQuoteApplication.main(new String[] { "ALL", "2/2/2018" });
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testMainAppIndexOutOfBounds2() {
		StockQuoteApplication.main(new String[] { "ALL" });
	}

}
