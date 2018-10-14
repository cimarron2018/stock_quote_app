package edu.arielperez.advancedjava.application;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class StockQuoteApplicationTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void exitsMissingParameters() {
        exit.expectSystemExit();
        StockQuoteApplication.main(new String[]{});
    }

    @Test
    public void exitsMissingParameterFromDate() {
        exit.expectSystemExit();
        StockQuoteApplication.main(new String[]{"LLL","","2/2/2018"});
    }

    @Test
    public void exitsMissingParameterToDate() {
        exit.expectSystemExit();
        StockQuoteApplication.main(new String[]{"LLL","2/2/2018",""});
    }

    @Test
    public void exitsWrongFromDateFormat() {
        exit.expectSystemExit();
        StockQuoteApplication.main(new String[]{"LLL","24-2-2018","2/10/2018"});
    }

    @Test
    public void exitsWrongToDateFormat() {
        exit.expectSystemExit();
        StockQuoteApplication.main(new String[]{"LLL","2/2/2018","24-10-2018"});
    }

    @Test
    public void noSystemExit() {
        StockQuoteApplication.main(new String[]{"APPL","1/1/2000","1/8/2000"});
        //passes
    }


}
