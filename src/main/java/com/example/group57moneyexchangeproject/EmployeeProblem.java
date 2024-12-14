package com.example.group57moneyexchangeproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeProblem {

    @FXML
    private TextField complaintIdTextField;

    @FXML
    private TextField complaintTextTextField;

    @FXML
    private TextField employeeNameTextField;

    @FXML
    private TableView<EmployeeComplaint> employeeComplaintsTableView;

    @FXML
    private TableColumn<EmployeeComplaint, String> ComplaintIdTableColumn;

    @FXML
    private TableColumn<EmployeeComplaint, String> employeeNameTableColumn;

    @FXML
    private TableColumn<EmployeeComplaint, String> complaintTextTableColumn;

    private ObservableList<EmployeeComplaint> employeeComplaints = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        ComplaintIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("complaintId"));
        employeeNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        complaintTextTableColumn.setCellValueFactory(new PropertyValueFactory<>("complaintText"));

        // Bind the observable list to the table view
        employeeComplaintsTableView.setItems(employeeComplaints);
    }

    @FXML
    public void EmployeeComplaint(ActionEvent event) {
        String complaintId = complaintIdTextField.getText();
        String employeeName = employeeNameTextField.getText();
        String complaintText = complaintTextTextField.getText();

        if (complaintId.isEmpty() || employeeName.isEmpty() || complaintText.isEmpty()) {
            System.out.println("All fields are required!");
            return;
        }

        EmployeeComplaint newComplaint = new EmployeeComplaint(complaintId, employeeName, complaintText);
        employeeComplaints.add(newComplaint);

        complaintIdTextField.clear();
        employeeNameTextField.clear();
        complaintTextTextField.clear();

        System.out.println("Complaint successfully added!");
    }
}
