package edu.arielperez.advancedjava.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.arielperez.advancedjava.model.StockQuote;

/**
 * JUNIT test for BasicStockService class
 * 
 * @author aperez
 *
 */
public class BasicStockServiceTest {

	private StockService stockServiceImplementation;
	private Calendar fromDate;
	private Calendar toDate;
	private String symbol = "APPL";
	private List<StockQuote> listPrices;

	@Before
	public void setup() {
		fromDate = new GregorianCalendar(2018, 0, 31);
		toDate = new GregorianCalendar(2018, 1, 2);
		stockServiceImplementation = new BasicStockService();
        try {
            listPrices = stockServiceImplementation.getQuote(symbol, fromDate, toDate);
        } catch (StockServiceException e) {
            e.printStackTrace();
        }
    }

	/**
	 * Test the getQuote method returns a BigDecimal
	 */
	@Test
	public void testGetQuote() {
        StockQuote testQuote = null;
        try {
            testQuote = stockServiceImplementation.getQuote(symbol);
        } catch (StockServiceException e) {
            e.printStackTrace();
        }
        assertTrue(testQuote.getStockPrice() instanceof BigDecimal);
	}

	@Test
	public void testGetQuoteDate() {
		assertTrue(listPrices instanceof List<?>);
	}

	@Test
	public void testGetQuoteDateFromDate() {
		assertTrue(listPrices.get(0).getDateRecorded().equals(fromDate.getTime()));
	}

	@Test
	public void testGetQuoteDateToDate() {
		assertTrue(listPrices.get(listPrices.size()-1).getDateRecorded().equals(toDate.getTime()));
	}

	@Test
	public void testGetQuoteDateStockSymbol() {
		assertTrue(listPrices.get(0).getStockSymbol().equalsIgnoreCase(symbol));
	}

}
