package com.example.farmer_survey_frontend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.farmer_survey_frontend.Retrofit.RetrofitClient;
import com.example.farmer_survey_frontend.UserData.UserDataActivity;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText edit_text,edit_text1,edit_text2,edit_text3,problem,need;
    private Button add,FarmerDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_text=findViewById(R.id.edit_text);
        edit_text1=findViewById(R.id.edit_text1);
        edit_text2=findViewById(R.id.edit_text2);
        edit_text3=findViewById(R.id.edit_text3);
        problem = findViewById(R.id.problems);
        need = findViewById(R.id.needs);
        add =findViewById(R.id.add);
        FarmerDetails=findViewById(R.id.FarmerDetails);

        try {
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    edit_text1.setText("1744748");
//                    edit_text2.setText("n");
//                    edit_text3.setText("154746");
//                    problem.setText("n");
//                    need.setText("n");
                    addData();
                }
            });
        }catch (Exception e){

        }

        try{
            FarmerDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, UserDataActivity.class));
                }
            });
        }catch (Exception e){

        }
    }
    private void addData(){


        String name= edit_text.getText().toString();
        String number=edit_text1.getText().toString();
        String village =edit_text2.getText().toString();
        String pincode=edit_text3.getText().toString();
        String problems =problem.getText().toString();
        String needs=need.getText().toString();


        if(name.isEmpty()){
            edit_text.requestFocus();
            edit_text.setError("please enter name");
            return;
        }
//        if(number.isEmpty()){
//            edit_text1.setText("1");
//            n = edit_text1.getText().toString();
//        }else {
//            n = number;
//        }
//        if(village.isEmpty()){
//            edit_text2.setText("null");
//            v = edit_text2.getText().toString();
//        }else {
//            v = village;
//        }
//        if(pincode.isEmpty()){
//            edit_text3.setText("1");
//            p = edit_text3.getText().toString();
//        }else {
//            p = pincode;
//        }
//        if(problems.isEmpty()){
//            problem.setText("null");
//            pr = problem.getText().toString();
//        }else {
//            pr = problems;
//        }
//        if(needs.isEmpty()){
//            need.setText("null");
//            ne = need.getText().toString();
//        }else {
//            ne = needs;
//        }

        Call<ResponseBody> call = RetrofitClient.getInstance().getApi().postFarmerData(name,number,village,pincode,problems,needs);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                edit_text.setText(" ");
                edit_text1.setText(" ");
                edit_text2.setText(" ");
                edit_text3.setText(" ");
                problem.setText(" ");
                need.setText(" ");

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}