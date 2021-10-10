package com.console.patient;


import com.console.person.Person;

import lombok.Setter;
import lombok.Getter;

import java.io.Serializable;
import java.util.Comparator;

@Getter
@Setter
public class Patient extends Person implements Comparable<Patient> {

    private String reason;

    public int compareTo(Patient patient) {
        int compareAge = ((Patient) patient).getAge();

        //ascending order
        return getAge() - compareAge;

    }
    public static Comparator<Patient> FruitNameComparator
            = new Comparator<Patient>() {

        public int compare(Patient patient1, Patient patient2) {

            Integer patient1Age = patient1.getAge();
            Integer patient2Age = patient2.getAge();

            //ascending order
            return patient1.compareTo(patient2);

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }

    };

}
