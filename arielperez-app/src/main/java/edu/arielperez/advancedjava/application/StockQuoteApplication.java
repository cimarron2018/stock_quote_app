package edu.arielperez.advancedjava.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import edu.arielperez.advancedjava.model.StockQuote;
import edu.arielperez.advancedjava.service.IntervalEnum;
import edu.arielperez.advancedjava.service.StockService;
import edu.arielperez.advancedjava.service.StockServiceFactory;
import javax.validation.constraints.NotNull;
public class StockQuoteApplication {

	public static void main(@NotNull String[] args) {

		String symbol = "";
		Calendar fromDate = Calendar.getInstance();
		Calendar toDate = Calendar.getInstance();

		if (args.length < 3) {
			System.out.println("Missing parameter(s): java StockQuoteApplication param1 param2 param3");
			System.out.println("param1: symbol, param2: date mm/dd/yyyy, param3: date mm/dd/yyyy");
			System.exit(0);
		}

		symbol = args[0];

		try {
			fromDate.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(args[1]));
		} catch (ParseException e1) {
			System.out.println("Invalid date format. Correct format is mm/dd/yyyy");
			System.exit(0);
		}
		try {
			toDate.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(args[2]));
		} catch (ParseException e) {
			System.out.println("Invalid date format. Correct format is mm/dd/yyyy");
			System.exit(0);
		}

		// Call the Factory Class to get the service
		StockService stockServiceImplementation = StockServiceFactory.getSockService();

		// Get price now
		StockQuote testStockPrice = stockServiceImplementation.getQuote(symbol);

		// Display StockQuote
		System.out.println("\nCurrent price for stock " + symbol);
		System.out.println(testStockPrice.toString());

		// Calls the getQuote method to pull price information between two dates for a
		// stock symbol
		List<StockQuote> listPrices = stockServiceImplementation.getQuote(symbol, fromDate, toDate);

		// Display the data returned from the getQuote method
		System.out.println("Price for stock " + symbol);
		for (StockQuote price : listPrices) {
			System.out.println(price.toString());
		}

		// Calls the getQuote method to pull price information between two dates for a
		// stock symbol
		List<StockQuote> listWeeklyPrices = stockServiceImplementation.getQuote(symbol, fromDate, toDate,
				IntervalEnum.WEEKLY);

		// Display the data returned from the getQuote method
		System.out.println("\nPrice for stock (weekly)" + symbol);
		for (StockQuote price : listWeeklyPrices) {
			System.out.println(price.toString());
		}

		List<StockQuote> listMonthlyPrices = stockServiceImplementation.getQuote(symbol, fromDate, toDate,
				IntervalEnum.MONTHLY);

		// Display the data returned from the getQuote method
		System.out.println("\nPrice for stock (monthly)" + symbol);
		for (StockQuote price : listMonthlyPrices) {
			System.out.println(price.toString());
		}

		List<StockQuote> listYearlyPrices = stockServiceImplementation.getQuote(symbol, fromDate, toDate,
				IntervalEnum.YEARLY);

		// Display the data returned from the getQuote method
		System.out.println("\nPrice for stock (yearly)" + symbol);
		for (StockQuote price : listYearlyPrices) {
			System.out.println(price.toString());
		}

	}

}
