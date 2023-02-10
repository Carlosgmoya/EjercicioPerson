package org.mps.person;

import java.util.List;

/**
 * Class representing a person with a name, age and gender,
 *
 * @author Carlos García Moya
 */

public class Person {
    private final String  name;
    private final int age;
    private final String gender; //Male, Female

    /**
     * Constructs a person with a name, age and gender
     *
     * @param name the name of the person
     * @param age the age of the person
     * @param gender the gender of the person
     */

    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name(){ return name; }

    public int age(){ return age; }

    public String gender(){ return gender; }

    /**
     * Compute the average age of male and female persons in a list and returns the result in
     * an array of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     *
     * @param persons
     * @return
     *
     */

    public double[] averageAgePerGender(List<Person> persons){
        double avgMale, avgFemale;
        int iMale = 0, iFemale = 0;
        double maleSum = 0, femaleSum = 0;
        double[] res = new double[2];

        for(Person p : persons){
            if (p.gender().equals("Male")){
                iMale++;
                maleSum+= p.age();
            } else if (p.gender().equals("Female")){
                iFemale++;
                femaleSum+= p.age();
            }
        }

        avgMale = maleSum/iMale;
        avgFemale = femaleSum/iFemale;

        res[0] = avgMale;
        res[1] = avgFemale;

        return res;
    }

}
