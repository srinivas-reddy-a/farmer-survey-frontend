package com.example.farmer_survey_frontend.Respones;

import com.example.farmer_survey_frontend.UserData.UserDataModel;

import java.util.List;

public class GetFarmerDataRespones {
    List<UserDataModel> users;

    public GetFarmerDataRespones(List<UserDataModel> users) {
        this.users = users;
    }

    public List<UserDataModel> getData() {
        return users;
    }

    public void setData(List<UserDataModel> users) {
        this.users = users;
    }
}
