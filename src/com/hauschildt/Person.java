package com.hauschildt;

import java.time.LocalDate;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int heightInInches;
    private double weightInPounds;
    private LocalDate dateOfBirth;
    private boolean alive;

    public static final String DEFAULT_FIRST_NAME = "John";
    public static final String DEFAULT_LAST_NAME = "Doe";
    public static final int DEFAULT_HEIGHT_IN_INCHES = 0;
    public static final double DEFAULT_WEIGHT_IN_POUNDS = 0;
    public static final LocalDate DEFAULT_DATE_OF_BIRTH = LocalDate.now();
    public static final boolean DEFAULT_ALIVE = true;

    public static final int MIN_FIRST_NAME_LENGTH = 3;
    public static final int MAX_FIRST_NAME_LENGTH = 25;
    public static final int MIN_LAST_NAME_LENGTH = 1;
    public static final int MAX_LAST_NAME_LENGTH = 25;
    public static final int MIN_HEIGHT = 0;
    public static final int MAX_HEIGHT = 100;
    public static final double MIN_WEIGHT = 0;
    public static final double MAX_WEIGHT = 1000;
    public static final LocalDate MIN_DATE_OF_BIRTH = LocalDate.now();

    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_HEIGHT_IN_INCHES, DEFAULT_WEIGHT_IN_POUNDS,
                DEFAULT_DATE_OF_BIRTH, DEFAULT_ALIVE);
    }



    public Person(String firstName, String lastName, int heightInInches, double weightInPounds, LocalDate dateOfBirth,
                  boolean alive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
        this.dateOfBirth = dateOfBirth;
        this.alive = alive;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        validateDateOfBirth(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    private void validateDateOfBirth(LocalDate dateOfBirth) {
        if(dateOfBirth.isAfter(MIN_DATE_OF_BIRTH)) {
            throw new IllegalArgumentException("The date of birth cannot be in the future.");
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", heightInInches=" + heightInInches +
                ", weightInPounds=" + weightInPounds +
                ", dateOfBirth=" + dateOfBirth +
                ", alive=" + alive +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        int result = this.lastName.compareToIgnoreCase(o.lastName);
        if(result == 0) {
            return this.firstName.compareToIgnoreCase(o.firstName);
        }
        return result;
    }
}
