package edu.arielperez.advancedjava.service;

import edu.arielperez.advancedjava.model.Quote;

import java.util.List;

/**
 * QuoteService interface
 */
public interface QuoteService {

    /**
     * Get a list of all quotes
     *
     * @return a list of Quote instances
     * @throws QuoteServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<Quote> getQuote() throws QuoteServiceException;

    /**
     * Add a new person or update an existing Quote's data
     *
     * @param quote a person object to either update or create
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    void addOrUpdateQuote(Quote quote) throws QuoteServiceException;


}
