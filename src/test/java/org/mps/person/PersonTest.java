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
 4. Average age of the setup people is : [30, 35]



 */
class PersonTest {
    Person p1, p2, p3, p4;

    @BeforeEach
    void setup(){
        p1 = new Person("Pepe", 20, "Male");
        p2 = new Person("Carlos", 40 , "Male");
        p3 = new Person("Maria", 30, "Female");
        p4 = new Person("Ana", 40, "Female");
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
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        double[] obtainedValue = p1.averageAgePerGender(list);
        double[] expectedValue = {30, 35};
        assertArrayEquals(expectedValue, obtainedValue);
    }

}