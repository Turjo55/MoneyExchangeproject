package com.example.group57moneyexchangeproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.Date;

public class EmployeeWorkshop {

    @FXML private TextField nameTextField;
    @FXML private TextField codeTextField;
    @FXML private TextField titleTextField;
    @FXML private DatePicker dateDatePicker;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private TableView<Workshop> workshopTableView;
    @FXML private TableColumn<Workshop, String> nameTableColumn;
    @FXML private TableColumn<Workshop, String> codeTableColumn;
    @FXML private TableColumn<Workshop, String> titleTableColumn;
    @FXML private TableColumn<Workshop, String> dateTableColumn;
    @FXML private TableColumn<Workshop, String> startTableColumn;
    @FXML private TableColumn<Workshop, String> endTableColumn;

    private ObservableList<Workshop> workshopData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        codeTableColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
        titleTableColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        dateTableColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        startTableColumn.setCellValueFactory(cellData -> cellData.getValue().startProperty());
        endTableColumn.setCellValueFactory(cellData -> cellData.getValue().endProperty());

        workshopTableView.setItems(workshopData);
    }

    @FXML
    private void workshopButton() {
        // Collect data from the UI elements
        String name = nameTextField.getText();
        String code = codeTextField.getText();
        String title = titleTextField.getText();
        String date = dateDatePicker.getValue() != null ? dateDatePicker.getValue().toString() : "";
        String start = startDatePicker.getValue() != null ? startDatePicker.getValue().toString() : "";
        String end = endDatePicker.getValue() != null ? endDatePicker.getValue().toString() : "";

        Workshop newWorkshop = new Workshop(name, code, title, date, start, end);
        workshopData.add(newWorkshop);

        nameTextField.clear();
        codeTextField.clear();
        titleTextField.clear();
        dateDatePicker.setValue(null);
        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
    }
}
