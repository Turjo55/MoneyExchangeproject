package com.example.group57moneyexchangeproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class employeePerformance {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField codeTextField;

    @FXML
    private TextField scoreTextField;

    @FXML
    private TableView<Performance> addPerformanceScoreTableView;

    @FXML
    private TableColumn<Performance, String> nameTableColumn;

    @FXML
    private TableColumn<Performance, String> codeTableColumn;

    @FXML
    private TableColumn<Performance, String> scoreTableColumn;

    private ObservableList<Performance> performanceList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        codeTableColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
        scoreTableColumn.setCellValueFactory(cellData -> cellData.getValue().scoreProperty());

        addPerformanceScoreTableView.setItems(performanceList);
    }

    @FXML
    private void addPerformanceScoreButton(ActionEvent event) {
        String name = nameTextField.getText().trim();
        String code = codeTextField.getText().trim();
        String score = scoreTextField.getText().trim();

        if (name.isEmpty() || code.isEmpty() || score.isEmpty()) {
            showErrorAlert("Invalid Input", "All fields must be filled.");
            return;  // Don't proceed if inputs are empty
        }

        Performance newPerformance = new Performance(name, code, score);
        performanceList.add(newPerformance);

        nameTextField.clear();
        codeTextField.clear();
        scoreTextField.clear();
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);  // No header text
        alert.setContentText(message);  // Set error message
        alert.showAndWait();  // Show the alert and wait for the user to close it
    }

    public static class Performance {
        private final String name;
        private final String code;
        private final String score;

        public Performance(String name, String code, String score) {
            this.name = name;
            this.code = code;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        public String getScore() {
            return score;
        }

        public javafx.beans.property.StringProperty nameProperty() {
            return new javafx.beans.property.SimpleStringProperty(name);
        }

        public javafx.beans.property.StringProperty codeProperty() {
            return new javafx.beans.property.SimpleStringProperty(code);
        }

        public javafx.beans.property.StringProperty scoreProperty() {
            return new javafx.beans.property.SimpleStringProperty(score);
        }
    }
}