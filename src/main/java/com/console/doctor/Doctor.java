package com.console.doctor;


import com.console.person.Person;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Doctor extends Person {

    private long identificationNumber;

    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        return new StringBuffer(" First Name: ").append(getFirstName())
                .append(" Last Name : ").append(getLastName()).append(" Age : ").append(getAge()).append(" Identification Number: ").append(getIdentificationNumber()).toString();
    }
}
