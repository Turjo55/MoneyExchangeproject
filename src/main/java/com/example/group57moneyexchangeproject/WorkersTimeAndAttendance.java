package com.example.group57moneyexchangeproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class WorkersTimeAndAttendance {

    @FXML private TextField nameTextField;
    @FXML private TextField codeTextField;
    @FXML private TextField workingHoursTextField;
    @FXML private RadioButton checkInRadioButton;
    @FXML private RadioButton checkOutRadioButton;
    @FXML private TableView<Worker> workHoursTableView;
    @FXML private TableColumn<Worker, String> nameTableColumn;
    @FXML private TableColumn<Worker, String> codeTableColumn;
    @FXML private TableColumn<Worker, String> workHoursTableColumn;
    @FXML private TableColumn<Worker, String> checkInTableColumn;
    @FXML private TableColumn<Worker, String> checkOutTableColumn;

    private ToggleGroup toggleGroup;
    private ObservableList<Worker> workerData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        toggleGroup = new ToggleGroup();
        checkInRadioButton.setToggleGroup(toggleGroup);
        checkOutRadioButton.setToggleGroup(toggleGroup);

        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        codeTableColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
        workHoursTableColumn.setCellValueFactory(cellData -> cellData.getValue().workingHoursProperty());
        checkInTableColumn.setCellValueFactory(cellData -> cellData.getValue().checkInProperty());
        checkOutTableColumn.setCellValueFactory(cellData -> cellData.getValue().checkOutProperty());

        workHoursTableView.setItems(workerData);
    }

    @FXML
    private void workHoursButton() {
        String name = nameTextField.getText();
        String code = codeTextField.getText();
        String workingHours = workingHoursTextField.getText();
        String checkIn = checkInRadioButton.isSelected() ? "Checked In" : "";
        String checkOut = checkOutRadioButton.isSelected() ? "Checked Out" : "";

        Worker newWorker = new Worker(name, code, workingHours, checkIn, checkOut);
        workerData.add(newWorker);

        nameTextField.clear();
        codeTextField.clear();
        workingHoursTextField.clear();
        toggleGroup.selectToggle(null);
    }
}
