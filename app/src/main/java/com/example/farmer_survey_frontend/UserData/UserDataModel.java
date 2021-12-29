package com.example.farmer_survey_frontend.UserData;

public class UserDataModel {
    private String name;
    private String number;
    private String village;
    private String pinCode;
    private String problem;
    private String needs;

    public UserDataModel(String name, String number, String village, String pinCode, String problem, String needs) {
        this.name = name;
        this.number = number;
        this.village = village;
        this.pinCode = pinCode;
        this.problem = problem;
        this.needs = needs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }
}
