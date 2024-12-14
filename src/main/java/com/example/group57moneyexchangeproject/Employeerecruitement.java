package com.example.group57moneyexchangeproject;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class Employeerecruitement {

    private static final String FILE_PATH = "job_requirements.bin";

    @FXML
    private TextField jobPositionTextField;

    @FXML
    private TextField requirementTextField;

    @FXML
    private TextField jobDescriptionTextField;

    @FXML
    private TextField salaryRangeTextField;

    @FXML
    private TableView<JobRequirement> recruitementTableView;

    @FXML
    private TableColumn<JobRequirement, String> jobPosTableCol;

    @FXML
    private TableColumn<JobRequirement, String> requirementsTableCol;

    @FXML
    private TableColumn<JobRequirement, String> jobDescriptionTableCol;

    @FXML
    private TableColumn<JobRequirement, String> salaryRangeTableCol;

    private ObservableList<JobRequirement> jobRequirements = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        jobPosTableCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobPosition()));
        requirementsTableCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRequirements()));
        jobDescriptionTableCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobDescription()));
        salaryRangeTableCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSalaryRange()));

        recruitementTableView.setItems(jobRequirements);


        loadJobRequirementsFromFile();
    }

    @FXML
    private void addJobRequirementButtonOnClick(ActionEvent event) {
        JobRequirement newRequirement = new JobRequirement(
                jobPositionTextField.getText(),
                requirementTextField.getText(),
                jobDescriptionTextField.getText(),
                salaryRangeTextField.getText()
        );
        jobRequirements.add(newRequirement);


        saveJobRequirementsToFile();


        jobPositionTextField.clear();
        requirementTextField.clear();
        jobDescriptionTextField.clear();
        salaryRangeTextField.clear();
    }

    private void saveJobRequirementsToFile() {
        JobRequirement.saveToFile(new ArrayList<>(jobRequirements), FILE_PATH);
    }

    private void loadJobRequirementsFromFile() {
        List<JobRequirement> loadedRequirements = JobRequirement.loadFromFile(FILE_PATH);
        jobRequirements.setAll(loadedRequirements);
    }
}
