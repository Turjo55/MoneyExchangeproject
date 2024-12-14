package com.example.group57moneyexchangeproject;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class EmployeeOnboarding {

    private static final String FILE_PATH = "employees.bin";

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField contactNumberTextField;

    @FXML
    private TextField employeeIDTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField contractTextField;

    @FXML
    private TableView<Employee> addNewEmployeeTableView;

    @FXML
    private TableColumn<Employee, String> typeTableColumn;

    @FXML
    private TableColumn<Employee, String> employeeIDTableColumn;

    @FXML
    private TableColumn<Employee, String> nameTableColumn;

    @FXML
    private TableColumn<Employee, String> addressTableColumn;

    @FXML
    private TableColumn<Employee, String> contactNumberTableColumn;

    @FXML
    private TableColumn<Employee, String> contractTableColumn;

    private ObservableList<Employee> employees = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Bind table columns to Employee properties
        typeTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
        employeeIDTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployeeID()));
        nameTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        addressTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress()));
        contactNumberTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContactNumber()));
        contractTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContract()));

        addNewEmployeeTableView.setItems(employees);

        typeComboBox.getItems().addAll("Permanent", "Contractual", "Intern");

        loadEmployeesFromFile();
    }

    @FXML
    private void addNewEmployeeButtonOnClick(ActionEvent event) {
        String type = typeComboBox.getValue();
        String employeeID = employeeIDTextField.getText().trim();
        String name = nameTextField.getText().trim();
        String address = addressTextField.getText().trim();
        String contactNumber = contactNumberTextField.getText().trim();
        String contract = contractTextField.getText().trim();

        if (type == null || employeeID.isEmpty() || name.isEmpty() || address.isEmpty() || contactNumber.isEmpty() || contract.isEmpty()) {
            showErrorAlert("Invalid Input", "All fields must be filled.");
            return;
        }

        Employee newEmployee = new Employee(type, employeeID, name, address, contactNumber, contract);
        employees.add(newEmployee);

        saveEmployeesToFile();

        typeComboBox.setValue(null);
        employeeIDTextField.clear();
        nameTextField.clear();
        addressTextField.clear();
        contactNumberTextField.clear();
        contractTextField.clear();
    }

    private void saveEmployeesToFile() {
        Employee.saveToFile(new ArrayList<>(employees), FILE_PATH);
    }

    private void loadEmployeesFromFile() {
        List<Employee> loadedEmployees = Employee.loadFromFile(FILE_PATH);
        employees.setAll(loadedEmployees);
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
