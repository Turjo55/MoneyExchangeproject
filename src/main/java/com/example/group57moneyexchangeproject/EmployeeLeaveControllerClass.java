package com.example.group57moneyexchangeproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeLeaveControllerClass {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private ComboBox<String> selectDaysComboBox;

    @FXML
    private ComboBox<String> selectDeptComboBox;

    @FXML
    private TextArea reasonTextArea;

    @FXML
    private TextField statusTextField;

    @FXML
    private TableView<LeaveApplication> leaveApplicationTableView;

    @FXML
    private TableColumn<LeaveApplication, String> nameTablecolumn;

    @FXML
    private TableColumn<LeaveApplication, String> idTableCol;

    @FXML
    private TableColumn<LeaveApplication, Integer> daysTableCol;

    @FXML
    private TableColumn<LeaveApplication, String> deptTablecolumn;

    @FXML
    private TableColumn<LeaveApplication, String> reasonTablecolumn;

    @FXML
    private TableColumn<LeaveApplication, String> statusTablecolumn;

    private ObservableList<LeaveApplication> leaveApplications = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        selectDaysComboBox.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7"));
        selectDeptComboBox.setItems(FXCollections.observableArrayList("HR", "IT", "Finance", "Marketing"));

        nameTablecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idTableCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        daysTableCol.setCellValueFactory(new PropertyValueFactory<>("days"));
        deptTablecolumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        reasonTablecolumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
        statusTablecolumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        leaveApplicationTableView.setItems(leaveApplications);
    }

    public void applyForLeaveButtonONClickk(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String id = idTextField.getText();
        String days = selectDaysComboBox.getValue();
        String department = selectDeptComboBox.getValue();
        String reason = reasonTextArea.getText();

        if (name.isEmpty() || id.isEmpty() || days == null || department == null || reason.isEmpty()) {
            statusTextField.setText("Please fill in all fields.");
            return;
        }

        LeaveApplication newLeaveApplication = new LeaveApplication(
                name,
                id,
                Integer.parseInt(days),
                department,
                reason,
                "Pending"
        );

        leaveApplications.add(newLeaveApplication);
        statusTextField.setText("Leave application submitted.");

        nameTextField.clear();
        idTextField.clear();
        selectDaysComboBox.setValue(null);
        selectDeptComboBox.setValue(null);
        reasonTextArea.clear();
    }
}

