package com.example.group57moneyexchangeproject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Worker {
    private final StringProperty name;
    private final StringProperty code;
    private final StringProperty workingHours;
    private final StringProperty checkIn;
    private final StringProperty checkOut;

    public Worker(String name, String code, String workingHours, String checkIn, String checkOut) {
        this.name = new SimpleStringProperty(name);
        this.code = new SimpleStringProperty(code);
        this.workingHours = new SimpleStringProperty(workingHours);
        this.checkIn = new SimpleStringProperty(checkIn);
        this.checkOut = new SimpleStringProperty(checkOut);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty codeProperty() {
        return code;
    }

    public StringProperty workingHoursProperty() {
        return workingHours;
    }

    public StringProperty checkInProperty() {
        return checkIn;
    }

    public StringProperty checkOutProperty() {
        return checkOut;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCode() {
        return code.get();
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getWorkingHours() {
        return workingHours.get();
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours.set(workingHours);
    }

    public String getCheckIn() {
        return checkIn.get();
    }

    public void setCheckIn(String checkIn) {
        this.checkIn.set(checkIn);
    }

    public String getCheckOut() {
        return checkOut.get();
    }

    public void setCheckOut(String checkOut) {
        this.checkOut.set(checkOut);
    }
}
