package com.example.farmer_survey_frontend.UserData;

public class UserDataModel {
    private String id;
    private String name;
    private int number;
    private String village;
    private int pincode;
    private String problems;
    private String needs;

    public UserDataModel(String id,String name, int number, String village, int pincode, String problems, String needs) {
        this.id = id ;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public int getPinCode() {
        return pincode;
    }

    public void setPinCode(int pincode) {
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
