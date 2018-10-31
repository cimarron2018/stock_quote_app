package edu.arielperez.advancedjava.application;


import edu.arielperez.advancedjava.model.Quote;
import edu.arielperez.advancedjava.model.Stock;
import edu.arielperez.advancedjava.model.Stocks;
import edu.arielperez.advancedjava.service.QuoteService;
import edu.arielperez.advancedjava.service.QuoteServiceException;
import edu.arielperez.advancedjava.service.ServiceFactory;
import edu.arielperez.advancedjava.utilities.DatabaseInitializationException;
import edu.arielperez.advancedjava.utilities.DatabaseUtils;
import edu.arielperez.advancedjava.utilities.InvalidXMLException;
import edu.arielperez.advancedjava.utilities.XMLUtils;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMLStockApplication {

    public static void main(String[] args) throws JAXBException {

        // Get new QuoteService
        QuoteService quoteServiceImplementation = ServiceFactory.getQuoteService();

        // Init Database with original records
        try {
            DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
        } catch (DatabaseInitializationException e) {
            System.out.println("Not able to initialize DB." + e.getMessage());
            System.exit(-1);
        }

        // XML file to load into database
        String xmlFilePath = "./src/main/resources/xml/stock_info.xml";
        File xmlFile = new File(xmlFilePath);

        // Unmarshall XML file
        Stocks stocks = null;
        try {
            stocks = (Stocks) XMLUtils.unmarshall(xmlFile, Stocks.class, "/xml/stock_info.xsd");
        } catch (InvalidXMLException e) {
            System.out.println("Not able to parse XML file." + e.getMessage());
            System.exit(-1);
        }

        // Create Quote objects
        List<Quote> quoteList = createQuoteList(stocks);

        // Add quote to table
        for (Quote quote : quoteList) {
            try {
                quoteServiceImplementation.addOrUpdateQuote(quote);
            } catch (QuoteServiceException e) {
                System.out.println("Not able to add records to database." + e.getMessage());
            }
        }

    }

    /**
     * Creates a list of Quote objects with data from XMLDomainObject
     *
     * @param stocks XML file stored in specified XML Domain Object using JAXB
     * @return list of Quote objects
     */
    private static List<Quote> createQuoteList(Stocks stocks) {

        // Create Quote objects
        List<Quote> quoteList = new ArrayList<>();
        Quote quote = new Quote();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parsedTimeStamp = null;
        for (Stock stock : stocks.getStock()) {
            quote = new Quote();
            // create quote
            if (stock != null) {
                quote.setSymbol(stock.getSymbol());
                quote.setPrice(new BigDecimal(stock.getPrice()));

                try {
                    parsedTimeStamp = dateFormat.parse(stock.getTime());
                } catch (ParseException e) {
                    System.out.println("Not able to parse the date, verify the time field in the XML is correct." + e.getMessage());
                    System.exit(-1);
                }
                if (parsedTimeStamp != null) {
                    quote.setTime(new Timestamp(parsedTimeStamp.getTime()));
                }
            }
            quoteList.add(quote);
        }
        return quoteList;
    }

}

