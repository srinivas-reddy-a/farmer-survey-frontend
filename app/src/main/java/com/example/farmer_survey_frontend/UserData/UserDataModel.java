package com.example.farmer_survey_frontend.UserData;

public class UserDataModel {
    private String name;
    private String number;
    private String village;
    private String pincode;
    private String problems;
    private String needs;

    public UserDataModel(String name, String number, String village, String pincode, String problems, String needs) {
        this.name = name;
        this.number = number;
        this.village = village;
        this.pincode = pincode;
        this.problems = problems;
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
        return pincode;
    }

    public void setPinCode(String pincode) {
        this.pincode = pincode;
    }

    public String getProblem() {
        return problems;
    }

    public void setProblem(String problems) {
        this.problems = problems;
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }
}
