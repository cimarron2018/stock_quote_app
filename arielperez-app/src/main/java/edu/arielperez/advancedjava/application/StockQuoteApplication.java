package edu.arielperez.advancedjava.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import edu.arielperez.advancedjava.model.StockQuote;
import edu.arielperez.advancedjava.service.StockService;
import edu.arielperez.advancedjava.service.StockServiceFactory;

public class StockQuoteApplication {

	public static void main(String[] args) {

		String symbol = "";
		Calendar fromDate = Calendar.getInstance();
		Calendar toDate = Calendar.getInstance();

		symbol = args[0];
		
		try {
			fromDate.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(args[1]));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			toDate.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(args[2]));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Call the Factory Class to get the service
		StockService stockServiceImplementation = StockServiceFactory.getSockService();

		// Calls the getQuote method to pull price information between two dates for a
		// stock symbol
		List<StockQuote> listPrices = stockServiceImplementation.getQuote(symbol, fromDate, toDate);

		// Display the data returned from the getQuote method
		System.out.println("Price for stock " + symbol);
		for (StockQuote price : listPrices) {
			System.out.println(price.toString());
		}

		// Get price now
		StockQuote testStockPrice = stockServiceImplementation.getQuote(symbol);

		// Display StockQuote
		System.out.println("\nCurrent price for stock " + symbol);
		System.out.println(testStockPrice.toString());
	}

}
