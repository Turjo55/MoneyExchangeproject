package com.example.group57moneyexchangeproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class EmployeeSalary {

    @FXML
    private TextField codeTextField;

    @FXML
    private TextField salaryTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private DatePicker dateDatePicker;

    @FXML
    private TableView<PaySalary> paySalaryTableView;

    @FXML
    private TableColumn<PaySalary, String> codeTableColumn;

    @FXML
    private TableColumn<PaySalary, String> nameTableColumn;

    @FXML
    private TableColumn<PaySalary, Double> salaryTableColumn;

    @FXML
    private TableColumn<PaySalary, LocalDate> dateTableColumn;

    private ObservableList<PaySalary> salaryList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configure table columns
        codeTableColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        salaryTableColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        paySalaryTableView.setItems(salaryList);
    }

    @FXML
    public void paySalaryButton(ActionEvent event) {
        String code = codeTextField.getText();
        String name = nameTextField.getText();
        String salaryText = salaryTextField.getText();
        LocalDate date = dateDatePicker.getValue();

        if (code.isEmpty() || name.isEmpty() || salaryText.isEmpty() || date == null) {
            System.out.println("All fields must be filled out.");
            return;
        }

        try {
            double salary = Double.parseDouble(salaryText);

            PaySalary newPaySalary = new PaySalary(code, name, salary, date);

            salaryList.add(newPaySalary);

            codeTextField.clear();
            nameTextField.clear();
            salaryTextField.clear();
            dateDatePicker.setValue(null);

            System.out.println("Salary payment successfully added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary amount. Please enter a number.");
        }
    }
}
