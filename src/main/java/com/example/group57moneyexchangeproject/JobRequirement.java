package com.example.group57moneyexchangeproject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JobRequirement implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String jobPosition;
    private final String requirements;
    private final String jobDescription;
    private final String salaryRange;

    public JobRequirement(String jobPosition, String requirements, String jobDescription, String salaryRange) {
        this.jobPosition = jobPosition;
        this.requirements = requirements;
        this.jobDescription = jobDescription;
        this.salaryRange = salaryRange;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    @Override
    public String toString() {
        return "JobRequirement{" +
                "jobPosition='" + jobPosition + '\'' +
                ", requirements='" + requirements + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", salaryRange='" + salaryRange + '\'' +
                '}';
    }



    public static void saveToFile(List<JobRequirement> jobRequirements, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(jobRequirements);
        } catch (IOException e) {
            System.err.println("Error saving job requirements to file: " + e.getMessage());
        }
    }

    public static List<JobRequirement> loadFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<JobRequirement>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading job requirements from file: " + e.getMessage());
            return new ArrayList<>(); // Return an empty list if loading fails
        }
    }
}
//