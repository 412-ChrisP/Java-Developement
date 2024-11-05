package Yearup.pluralsight;

import java.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person>
{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getters
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getAge()
    {
        return age;
    }

    @Override
    public int compareTo(Person other)
    {
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        if (lastNameComparison != 0)
        {
            return lastNameComparison;
        }

        int firstNameComparison = this.firstName.compareTo(other.firstName);
        if (firstNameComparison != 0)
        {
            return firstNameComparison;
        }

        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString()
    {
        return firstName + " " + lastName + " (" + age + ")";
    }
}