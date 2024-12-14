package com.example.group57moneyexchangeproject;

public class LeaveApplication {
    private String name;
    private String id;
    private int days;
    private String department;
    private String reason;
    private String status;

    public LeaveApplication(String name, String id, int days, String department, String reason, String status) {
        this.name = name;
        this.id = id;
        this.days = days;
        this.department = department;
        this.reason = reason;
        this.status = status;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LeaveApplication{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", days=" + days +
                ", department='" + department + '\'' +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
