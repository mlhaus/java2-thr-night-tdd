package com.hauschildt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    private String buildString(int length) {
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = 'X';
        }
        return new String(chars);
    }

    @Test
    void getFirstName() {
        String expected = Person.DEFAULT_FIRST_NAME;
        String actual = person.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    void setFirstNameMinGood() {
        String expected = buildString(Person.MIN_FIRST_NAME_LENGTH);
        person.setFirstName(expected);
        String actual = person.getFirstName();
        assertEquals(expected , actual);
    }

    @Test
    void setFirstNameMaxGood() {
        String expected = buildString(Person.MAX_FIRST_NAME_LENGTH);
        person.setFirstName(expected);
        String actual = person.getFirstName();
        assertEquals(expected , actual);
    }

    @Test
    void getLastName() {
        assertEquals(Person.DEFAULT_LAST_NAME, person.getLastName());
    }

    @Test
    void setLastNameMinGood() {
        String expected = buildString(Person.MIN_LAST_NAME_LENGTH);
        person.setLastName(expected);
        String actual = person.getLastName();
        assertEquals(expected , actual);
    }

    @Test
    void setLastNameMaxGood() {
        String expected = buildString(Person.MAX_LAST_NAME_LENGTH);
        person.setLastName(expected);
        String actual = person.getLastName();
        assertEquals(expected , actual);
    }

    @Test
    void getHeightInInches() {
        assertEquals(Person.DEFAULT_HEIGHT_IN_INCHES, person.getHeightInInches());
    }

    @Test
    void setHeightInInchesMinGood() {
        person.setHeightInInches(Person.MIN_HEIGHT);
        assertEquals(Person.MIN_HEIGHT, person.getHeightInInches());
    }

    @Test
    void setHeightInInchesMaxGood() {
        person.setHeightInInches(Person.MAX_HEIGHT);
        assertEquals(Person.MAX_HEIGHT, person.getHeightInInches());
    }

    @Test
    void getWeightInPounds() {
        assertEquals(Person.DEFAULT_WEIGHT_IN_POUNDS, person.getWeightInPounds());
    }

    @Test
    void doublePracticeTest() {
        double actual = 1.1 + 1.01;
        double expected = 2.11;
        assertEquals(actual, expected, 0.001);
    }

    @Test
    void setWeightInPoundsMinGood() {
        person.setWeightInPounds(Person.MIN_WEIGHT);
        assertEquals(Person.MIN_WEIGHT, person.getWeightInPounds());
    }

    @Test
    void setWeightInPoundsMaxGood() {
        person.setWeightInPounds(Person.MAX_WEIGHT);
        assertEquals(Person.MAX_WEIGHT, person.getWeightInPounds());
    }

    @Test
    void getDateOfBirth() {
        assertEquals(Person.DEFAULT_DATE_OF_BIRTH, person.getDateOfBirth());
    }

    @Test
    void setDateOfBirthMinGood() {
        person.setDateOfBirth(Person.MIN_DATE_OF_BIRTH);
        assertEquals(Person.MIN_DATE_OF_BIRTH, person.getDateOfBirth());
    }

    @Test
    void setDateOfBirthInThePastGood() {
        LocalDate expected = Person.MIN_DATE_OF_BIRTH.minusDays(1);
        person.setDateOfBirth(expected);
        assertEquals(expected, person.getDateOfBirth());
    }

    @Test
    void setDateOfBirthInTheFutureBad() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                person.setDateOfBirth(Person.MIN_DATE_OF_BIRTH.plusDays(1));
            }
        });
    }

    @Test
    void isAlive() {
        assertEquals(Person.DEFAULT_ALIVE, person.isAlive());
    }

    @Test
    void setAlive() {
        person.setAlive(false);
        assertEquals(false, person.isAlive());
    }

    @Test
    void testToString() {
        String expected = "Person{" +
                "firstName='" + Person.DEFAULT_FIRST_NAME + '\'' +
                ", lastName='" + Person.DEFAULT_LAST_NAME + '\'' +
                ", heightInInches=" + Person.DEFAULT_HEIGHT_IN_INCHES +
                ", weightInPounds=" + Person.DEFAULT_WEIGHT_IN_POUNDS +
                ", dateOfBirth=" + Person.DEFAULT_DATE_OF_BIRTH +
                ", alive=" + Person.DEFAULT_ALIVE +
                '}';
        String actual = person.toString();
        assertEquals(expected, actual);
    }

    @Test
    void compareToOtherLastNameAfter() {
        Person other = new Person();
        other.setLastName("Z");
        assertTrue(person.compareTo(other) < 0);
    }

    @Test
    void compareToOtherLastNameBefore() {
        Person other = new Person();
        other.setLastName("A");
        assertTrue(person.compareTo(other) > 0);
    }

    @Test
    void compareToOtherLastNameSame() {
        Person other = new Person();
        assertTrue(person.compareTo(other) == 0);
    }

    @Test
    void compareToOtherFirstNameAfter() {
        Person other = new Person();
        other.setFirstName("Z");
        assertTrue(person.compareTo(other) < 0);
    }

    @Test
    void compareToOtherFirstNameBefore() {
        Person other = new Person();
        other.setFirstName("A");
        assertTrue(person.compareTo(other) > 0);
    }


}