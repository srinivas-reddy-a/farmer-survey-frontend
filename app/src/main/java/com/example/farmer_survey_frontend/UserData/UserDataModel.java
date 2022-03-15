package com.example.farmer_survey_frontend.UserData;

public class UserDataModel {
    private String id;
    private String name;
    private String number;
    private String village;
    private String pincode;
    private String problems;
    private String needs;

    public UserDataModel(String id, String name, String number, String village, String pincode, String problems, String needs) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.village = village;
        this.pincode = pincode;
        this.problems = problems;
        this.needs = needs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }
}
