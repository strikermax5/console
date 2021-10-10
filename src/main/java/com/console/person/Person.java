package com.console.person;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Person implements Serializable {
    private String lastName;
    private String firstName;
    private int age;
}
