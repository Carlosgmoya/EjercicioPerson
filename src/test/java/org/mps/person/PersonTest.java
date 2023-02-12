package org.mps.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
 Test cases:
 1. Person age < 0
 2. Person age > 116
 3. Person gender != Male || Female
 4. Average age of the setup people is -> [30, 35]
 5. Average age of an empty list is -> ???
 6. Average age of 1 person -> his age in his gender place
 7. Average age of 2 first people in setup(both Male) -> [30, 0]
 8. p1 names is -> "Pepe"
 */
class PersonTest {
    Person p1, p2, p3, p4;
    List<Person> list;

    @BeforeEach
    void setup(){
        p1 = new Person("Pepe", 20, "Male");
        p2 = new Person("Carlos", 40 , "Male");
        p3 = new Person("Maria", 30, "Female");
        p4 = new Person("Ana", 40, "Female");
        list = new ArrayList<>();
    }

    @Test
    void PersonWithNegativeAge(){
        assertThrows(ImpossibleAgeException.class, () -> new Person("Pepe", -1, "Male"));
    }
    @Test
    void PersonWithTooBigAge(){
        assertThrows(ImpossibleAgeException.class, () -> new Person("Pepe", 1200, "Male"));
    }

    @Test
    void PersonWithWrongGender(){
        assertThrows(TwoGendersException.class, () -> new Person("Pepe", 20, "Dog"));
    }

    @Test
    void AverageAgeOf4People(){
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        double[] obtainedValue = p1.averageAgePerGender(list);
        double[] expectedValue = {30, 35};
        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    void AverageAgeOfAnEmptyList(){
        assertThrows(EmptyListException.class, () -> p1.averageAgePerGender(list));
    }

    @Test
    void AverageAgeOf1MalePerson(){
        list.add(p1);

        double[] obtainedValue = p1.averageAgePerGender(list);
        double[] expectedValue = {p1.age(), 0};
        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    void AverageAgeOfOnlyMalePeople(){
        list.add(p1);
        list.add(p2);

        double[] obtainedValue = p1.averageAgePerGender(list);
        double[] expectedValue = {30, 0};
        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    void NameOfAPersonIsHisName(){
        String obtainedValue = p1.name();
        String expectedValue = "Pepe";

        assertEquals(obtainedValue, expectedValue);
    }

}