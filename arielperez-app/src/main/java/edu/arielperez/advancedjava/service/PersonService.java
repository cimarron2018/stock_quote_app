package edu.arielperez.advancedjava.service;

import edu.arielperez.advancedjava.model.Person;

import java.util.List;

/**
 *
 */
public interface PersonService {

    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<Person> getPerson() throws PersonServiceException;

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    //void addOrUpdatePerson(Person person) throws PersonServiceException;

    /**
     * Get a list of all a person's stocks.
     *
     * @return a list of stocks instances
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    //List<String> getStocks(Person person) throws PersonServiceException;

    /**
     * Assign a hobby to a person.
     *
     * @param stock  The stock to assign
     * @param person The person to assign the stock too.
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    //public void addHobbyToPerson(String stock, Person person) throws PersonServiceException;

}
