package com.tw.apistackbase.controller;

public class Employee {

    int id;
    String name;
    int age;
    String gender;

    public Employee(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}