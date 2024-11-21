package Yearup.pluralsight;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = createPeopleList();

        System.out.print("Enter a name to search: ");
        Scanner scanner = new Scanner(System.in);
        String searchName = scanner.nextLine();

        List<Person> matchingPeople = people.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(searchName) ||
                        person.getLastName().equalsIgnoreCase(searchName))
                .toList();

        System.out.println("People with matching name:");
        matchingPeople.forEach(person ->
                System.out.println(person.getFirstName() + " " + person.getLastName()));

        OptionalDouble averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average();
        System.out.println("Average age: " + averageAge);

        OptionalInt oldestAge = people.stream()
                .mapToInt(Person::getAge)
                .max();
        System.out.println("Oldest person's age: " + oldestAge);

        OptionalInt youngestAge = people.stream()
                .mapToInt(Person::getAge)
                .min();
        System.out.println("Youngest person's age: " + youngestAge);
    }

    private static List<Person> createPeopleList() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Doe", 25));
        people.add(new Person("Jane", "Smith", 30));
        people.add(new Person("Michael", "Johnson", 35));
        people.add(new Person("Emily", "Brown", 22));
        people.add(new Person("David", "Miller", 40));
        people.add(new Person("Sarah", "Davis", 28));
        people.add(new Person("Daniel", "Anderson", 33));
        people.add(new Person("Jessica", "Wilson", 27));
        people.add(new Person("Matthew", "Martinez", 31));
        people.add(new Person("Olivia", "Taylor", 29));

        return people;
    }
}