package edu.arielperez.advancedjava.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Junit test for PersonStocks class
 */
public class PersonStocksTest {

    public static final String stock = "ENV";


    /**
     * Testing helper method for generating Person test data
     *
     * @return a Person object that uses static constants for data.
     */
    public static PersonStocks createPersonStocks() {
        Person person = PersonTest.createPerson();
        return new PersonStocks(person, stock);
    }

    @Test
    public void testPersonStocksGetterAndSetters() {
        Person person = PersonTest.createPerson();
        PersonStocks personStocks = new PersonStocks();
        int id = 10;
        personStocks.setId(id);
        personStocks.setPerson(person);
        personStocks.setStock(stock);
        assertEquals("person matches", person, personStocks.getPerson());
        assertEquals("stock matches", stock, personStocks.getStock());
        assertEquals("id matches", id, personStocks.getId());
    }

    @Test
    public void testEqualsNegativeDifferentPerson() {
        PersonStocks personStocks = createPersonStocks();
        personStocks.setId(10);
        Person person = new Person();
        person.setFirstName(PersonTest.firstName);
        person.setLastName(PersonTest.lastName);
        PersonStocks personStocks2 = new PersonStocks(person, stock);
        assertFalse("Different person", personStocks.equals(personStocks2));
    }

    @Test
    public void testEquals() {
        PersonStocks personStocks = createPersonStocks();
        assertTrue("Same objects are equal", personStocks.equals(createPersonStocks()));
    }

    @Test
    public void testToString() {
        PersonStocks personStocks = createPersonStocks();
        assertTrue("toString has lastName", personStocks.toString().contains(PersonTest.lastName));
        assertTrue("toString has firstName", personStocks.toString().contains(PersonTest.firstName));
        assertTrue("toString has stock", personStocks.toString().contains(stock));
    }
}
