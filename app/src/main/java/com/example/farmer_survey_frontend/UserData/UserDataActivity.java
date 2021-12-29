package com.example.farmer_survey_frontend.UserData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.farmer_survey_frontend.R;

import java.util.ArrayList;
import java.util.List;

public class UserDataActivity extends AppCompatActivity {

    private RecyclerView UserDataRecyclerView;
    private List<UserDataModel> userDataModels;
    private UserDataAdapter userDataAdapter;

    private Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        UserDataRecyclerView=findViewById(R.id.UserDataRecyclerView);
        home = findViewById(R.id.home);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        UserDataRecyclerView.setLayoutManager(layoutManager);

        userDataModels = new ArrayList<>();
        userDataModels.add(new UserDataModel("rohan","46364931848","vdjsBDK","123242","HJVDNMKDHVBDNDVDJDNKDVDLDDVJDKVKJKL[VKJKLLVKDKDLL[VKJKLL[VDIKQLL[VDILKL[DVONKDQLKVDNKDLKVDNKLKVDNK",
                "hydfdhbfsvhfbhvodfnhioflhiffvhlivbjldssssssssssssssssssssssssss")
        );
        userDataModels.add(new UserDataModel("rohan","46364931848","vdjsBDK","123242","HJVDNMKDHVBDNDVDJDNKDVDLDDVJDKVKJKL[VKJKLLVKDKDLL[VKJKLL[VDIKQLL[VDILKL[DVONKDQLKVDNKDLKVDNKLKVDNK",
                "hydfdhbfsvhfbhvodfnhioflhiffvhlivbjldssssssssssssssssssssssssss")
        );
        userDataModels.add(new UserDataModel("rohan","46364931848","vdjsBDK","123242","HJVDNMKDHVBDNDVDJDNKDVDLDDVJDKVKJKL[VKJKLLVKDKDLL[VKJKLL[VDIKQLL[VDILKL[DVONKDQLKVDNKDLKVDNKLKVDNK",
                "hydfdhbfsvhfbhvodfnhioflhiffvhlivbjldssssssssssssssssssssssssss")
        );

        userDataAdapter = new UserDataAdapter(userDataModels);
        UserDataRecyclerView.setAdapter(userDataAdapter);

        try{
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }catch (Exception e){

        }



    }

}