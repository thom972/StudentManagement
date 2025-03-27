package org.example;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class Person {
    protected int studentId;
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person() {}

    public abstract String getDetails();


}
