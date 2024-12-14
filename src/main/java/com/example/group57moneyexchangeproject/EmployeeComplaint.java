package com.example.group57moneyexchangeproject;

public class EmployeeComplaint {
    private String complaintId;
    private String employeeName;
    private String complaintText;

    public EmployeeComplaint(String complaintId, String employeeName, String complaintText) {
        this.complaintId = complaintId;
        this.employeeName = employeeName;
        this.complaintText = complaintText;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }
}
