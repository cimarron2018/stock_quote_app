package edu.arielperez.advancedjava.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Junit test for Quote class
 */
public class QuoteTest {

    public static final String symbol = "VNET";
    public static final BigDecimal price = new BigDecimal(112);
    public static final Timestamp time = Timestamp.valueOf("2017-11-15 00:00:00.000");

    /**
     * Testing helper method for generating Person test data
     *
     * @return a Person object that uses static constants for data.
     */
    public static Quote createQuote() {
        Quote quote = new Quote();
        quote.setSymbol(symbol);
        quote.setPrice(price);
        quote.setTime(time);
        return quote;
    }

    @Test
    public void testPersonSettersAndGetters() {
        Quote quote = createQuote();
        int id = 10;
        quote.setId(id);
        assertEquals("Symbol", symbol, quote.getSymbol());
        assertEquals("Time", time, quote.getTime());
        assertEquals("Price", price, quote.getPrice());
        assertEquals("id", id, quote.getId());

    }

}
