package edu.arielperez.advancedjava.service;

import edu.arielperez.advancedjava.model.Person;
import edu.arielperez.advancedjava.model.PersonTest;
import edu.arielperez.advancedjava.model.Quote;
import edu.arielperez.advancedjava.model.QuoteTest;
import edu.arielperez.advancedjava.utilities.DatabaseUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Junit test for DatabasePersonService class
 */
public class DatabaseQuoteServiceTest {

    private QuoteService quoteService;

    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    // do not assume db is correct
    @Before
    public void setUp() throws Exception {
        // we could also copy db state here for later restore before initializing
        initDb();
        quoteService = ServiceFactory.getQuoteService();
    }

    // clean up after ourselves. (this could also restore db from initial state
    //@After
    //public void tearDown() throws Exception {
    //    initDb();
    //}

    @Test
    public void testGetInstance() {
        assertNotNull("Make sure quoteService is available", quoteService);
    }

    @Test
    public void testGetQuote() throws QuoteServiceException {
        List<Quote> quoteList = quoteService.getQuote();
        assertFalse("Make sure we get some Quote objects from service", quoteList.isEmpty());
    }

    @Test
    public void testAddOrUpdateQuote() throws QuoteServiceException {
        Quote newQuote = QuoteTest.createQuote();
        quoteService.addOrUpdateQuote(newQuote);
        List<Quote> quoteList = quoteService.getQuote();
        System.out.println(quoteList.get(0).toString());
        assertFalse("List is empty",quoteList.isEmpty());
        boolean found = false;
        for (Quote quote : quoteList) {
            if (quote.getSymbol().equalsIgnoreCase(QuoteTest.symbol) && quote.getPrice().equals(QuoteTest.price) && quote.getTime().equals(QuoteTest.time))

                {
                found = true;
                break;
            }
        }
        assertTrue("Found the quote we added", found);
    }


}
