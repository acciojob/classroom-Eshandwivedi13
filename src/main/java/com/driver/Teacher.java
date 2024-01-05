package com.driver;

public class Teacher {

    private String name;

    private int numberOfStudents;

    private int age;

    public String getName() {
        return name;
    }

    public Teacher(String name, int numberOfStudents, int age) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.age = age;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getAge() {
        return age;
    }

    public Teacher() {

    }
}