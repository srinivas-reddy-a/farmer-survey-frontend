package com.example.farmer_survey_frontend.UserData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farmer_survey_frontend.R;
import com.example.farmer_survey_frontend.Respones.GetFarmerDataRespones;
import com.example.farmer_survey_frontend.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

//        userDataModels = new ArrayList<>();
//        userDataModels.add(new UserDataModel("rohan","46364931848","vdjsBDK","123242","HJVDNMKDHVBDNDVDJDNKDVDLDDVJDKVKJKL[VKJKLLVKDKDLL[VKJKLL[VDIKQLL[VDILKL[DVONKDQLKVDNKDLKVDNKLKVDNK",
//                "hydfdhbfsvhfbhvodfnhioflhiffvhlivbjldssssssssssssssssssssssssss")
//        );
//        userDataModels.add(new UserDataModel("rohan","46364931848","vdjsBDK","123242","HJVDNMKDHVBDNDVDJDNKDVDLDDVJDKVKJKL[VKJKLLVKDKDLL[VKJKLL[VDIKQLL[VDILKL[DVONKDQLKVDNKDLKVDNKLKVDNK",
//                "hydfdhbfsvhfbhvodfnhioflhiffvhlivbjldssssssssssssssssssssssssss")
//        );
//        userDataModels.add(new UserDataModel("rohan","46364931848","vdjsBDK","123242","HJVDNMKDHVBDNDVDJDNKDVDLDDVJDKVKJKL[VKJKLLVKDKDLL[VKJKLL[VDIKQLL[VDILKL[DVONKDQLKVDNKDLKVDNKLKVDNK",
//                "hydfdhbfsvhfbhvodfnhioflhiffvhlivbjldssssssssssssssssssssssssss")
//        );
//
//        userDataAdapter = new UserDataAdapter(userDataModels);
//        UserDataRecyclerView.setAdapter(userDataAdapter);

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