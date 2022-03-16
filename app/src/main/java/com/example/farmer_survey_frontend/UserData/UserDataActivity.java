package com.example.farmer_survey_frontend.UserData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farmer_survey_frontend.R;
import com.example.farmer_survey_frontend.Respones.GetFarmerDataRespones;
import com.example.farmer_survey_frontend.Retrofit.RetrofitClient;
import com.example.farmer_survey_frontend.SearchPage.SearchPageActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataActivity extends AppCompatActivity {

    private RecyclerView UserDataRecyclerView;
    private List<UserDataModel> userDataModels;
    private UserDataAdapter userDataAdapter;

    private ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        UserDataRecyclerView=findViewById(R.id.UserDataRecyclerView);
        home = findViewById(R.id.home);

        findViewById(R.id.searchHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDataActivity.this, SearchPageActivity.class));
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        UserDataRecyclerView.setLayoutManager(layoutManager);

        Call<GetFarmerDataRespones> call = RetrofitClient.getInstance().getApi().getData();
        call.enqueue(new Callback<GetFarmerDataRespones>() {
            @Override
            public void onResponse(Call<GetFarmerDataRespones> call, Response<GetFarmerDataRespones> response) {
                userDataModels = response.body().getData();
                userDataAdapter = new UserDataAdapter(userDataModels,UserDataActivity.this);
                UserDataRecyclerView.setAdapter(userDataAdapter);
            }

            @Override
            public void onFailure(Call<GetFarmerDataRespones> call, Throwable t) {
                Toast.makeText(UserDataActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

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