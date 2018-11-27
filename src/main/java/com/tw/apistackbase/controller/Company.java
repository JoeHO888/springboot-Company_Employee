package com.tw.apistackbase.controller;

public class Company {

    int id;
    String name;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    String brand;

    public Company(String name, String brand) {
        this.name = name;
        this.brand = brand;

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


}