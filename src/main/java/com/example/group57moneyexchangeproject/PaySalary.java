package com.example.group57moneyexchangeproject;

import java.time.LocalDate;

public class PaySalary {
    private String code;
    private String name;
    private double salary;
    private LocalDate date;

    public PaySalary(String code, String name, double salary, LocalDate date) {
        this.code = code;
        this.name = name;
        this.salary = salary;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
