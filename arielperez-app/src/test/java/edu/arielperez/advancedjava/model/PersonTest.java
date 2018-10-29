package edu.arielperez.advancedjava.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Junit test for Person class
 */
public class PersonTest {

    public static final String firstName = "John";
    public static final String lastName = "Hancock";

    /**
     * Testing helper method for generating Person test data
     *
     * @return a Person object that uses static constants for data.
     */
    public static Person createPerson() {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return person;
    }

    @Test
    public void testPersonSettersAndGetters() {
        Person person = createPerson();
        int id = 10;
        person.setId(id);
        assertEquals("First Name", firstName, person.getFirstName());
        assertEquals("Last Name", lastName, person.getLastName());
        assertEquals("id", id, person.getId());

    }



}
