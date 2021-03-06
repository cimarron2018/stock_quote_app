package edu.arielperez.advancedjava.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import edu.arielperez.advancedjava.model.StockQuote;
import edu.arielperez.advancedjava.service.IntervalEnum;
import edu.arielperez.advancedjava.service.StockService;
import edu.arielperez.advancedjava.service.StockServiceException;
import edu.arielperez.advancedjava.service.StockServiceFactory;

import javax.validation.constraints.NotNull;

public class StockQuoteApplication {

    public static void main(@NotNull String[] args) {

        String symbol = "";
        Calendar fromDate = Calendar.getInstance();
        Calendar toDate = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");

        if (args.length < 3) {
            System.out.println("Missing parameter(s): java StockQuoteApplication param1 param2 param3");
            System.out.println("param1: symbol, param2: date mm/dd/yyyy, param3: date mm/dd/yyyy");
            System.exit(1);
        }

        symbol = args[0];

        try {
            fromDate.setTime(dateFormat.parse(args[1]));
        } catch (ParseException e1) {
            System.out.println("Invalid date format. Correct format is mm/dd/yyyy");
            System.exit(1);
        }
        try {
            toDate.setTime(dateFormat.parse(args[2]));
        } catch (ParseException e) {
            System.out.println("Invalid date format. Correct format is mm/dd/yyyy");
            System.exit(1);
        }

        // Call the Factory Class to get the service
        StockService stockServiceImplementation = StockServiceFactory.getSockService();

        // Get price now
        StockQuote testStockPrice = null;
        try {
            testStockPrice = stockServiceImplementation.getQuote(symbol);
        } catch (StockServiceException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        // Display StockQuote
        System.out.println("\nCurrent price for stock " + symbol);
        System.out.println(testStockPrice.toString() + "\n\n");

        // Calls the getQuote method to pull price information between two dates for a
        // stock symbol
        List<StockQuote> listPrices = null;
        try {
            listPrices = stockServiceImplementation.getQuote(symbol, fromDate, toDate);
        } catch (StockServiceException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        // Display the data returned from the getQuote method
        System.out.println("\n\nPrice for stock " + symbol + " between " + dateFormat.format(fromDate.getTime()) + " and "
                + dateFormat.format(toDate.getTime()));
        for (StockQuote price : listPrices) {
            System.out.println(price.toString());
        }

    }

}
