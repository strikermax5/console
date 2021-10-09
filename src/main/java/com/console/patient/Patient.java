package com.console.patient;


import com.console.person.Person;

import lombok.Setter;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Setter
public class Patient extends Person {

    private String reason;
}
