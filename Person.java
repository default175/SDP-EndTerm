package org.example;
import lombok.*;

@Getter @Setter
public class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}