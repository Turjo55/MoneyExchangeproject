package com.example.group57moneyexchangeproject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LeaveApplication {
    private final SimpleStringProperty name;
    private final SimpleStringProperty id;
    private final SimpleIntegerProperty days;
    private final SimpleStringProperty department;
    private final SimpleStringProperty reason;
    private final SimpleStringProperty status;

    // Constructor
    public LeaveApplication(String name, String id, int days, String department, String reason, String status) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleStringProperty(id);
        this.days = new SimpleIntegerProperty(days);
        this.department = new SimpleStringProperty(department);
        this.reason = new SimpleStringProperty(reason);
        this.status = new SimpleStringProperty(status);
    }

    // Getters
    public String getName() {
        return name.get();
    }

    public String getId() {
        return id.get();
    }

    public int getDays() {
        return days.get();
    }

    public String getDepartment() {
        return department.get();
    }

    public String getReason() {
        return reason.get();
    }

    public String getStatus() {
        return status.get();
    }

    // Setters (if needed)
    public void setName(String name) {
        this.name.set(name);
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setDays(int days) {
        this.days.set(days);
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public void setReason(String reason) {
        this.reason.set(reason);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
