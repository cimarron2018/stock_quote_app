package edu.arielperez.advancedjava.service;

import edu.arielperez.advancedjava.model.Person;
import edu.arielperez.advancedjava.model.PersonTest;
import edu.arielperez.advancedjava.utilities.DatabaseUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Junit test for DatabasePersonService class
 */
public class DatabasePersonServiceTest {

    private PersonService personService;

    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    // do not assume db is correct
    @Before
    public void setUp() throws Exception {
        // we could also copy db state here for later restore before initializing
        initDb();
        personService = ServiceFactory.getPersonService();
    }

    // clean up after ourselves. (this could also restore db from initial state
    @After
    public void tearDown() throws Exception {
        initDb();
    }

    @Test
    public void testGetInstance() {
        assertNotNull("Make sure personService is available", personService);
    }

    @Test
    public void testGetPerson() throws PersonServiceException {
        List<Person> personList = personService.getPerson();
        assertFalse("Make sure we get some Person objects from service", personList.isEmpty());
    }

    @Test
    public void testAddOrUpdatePerson() throws PersonServiceException {
        Person newPerson = PersonTest.createPerson();
        personService.addOrUpdatePerson(newPerson);
        List<Person> personList = personService.getPerson();
        boolean found = false;
        for (Person person : personList) {
            if (person.getLastName().equals(PersonTest.lastName) && person.getFirstName().equals(PersonTest.firstName)) {
                found = true;
                break;
            }
        }
        assertTrue("Found the person we added", found);
    }

    @Test
    public void testGetStocksByPerson() throws PersonServiceException {
        Person person = PersonTest.createPerson();
        List<String> stocks = personService.getStocks(person);
        // make the person have all the hobbies
        for (String stock : stocks) {
            personService.addStockToPerson(stock, person);
        }
        List<String> stockList = personService.getStocks(person);
        for (String stock : stocks) {
            boolean removed = stockList.remove(stock);
            assertTrue("Verify that the stock was found on the list", removed);
        }
        // if  hobbyList is empty then we know the lists matched.
        assertTrue("Verify the list of returned stocks match what was expected ", stockList.isEmpty());

    }

}
