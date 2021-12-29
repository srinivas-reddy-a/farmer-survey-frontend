package com.example.farmer_survey_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edit_text,edit_text1,edit_text2,edit_text3,problems,needs;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_text=findViewById(R.id.edit_text);
        edit_text1=findViewById(R.id.edit_text1);
        edit_text2=findViewById(R.id.edit_text2);
        edit_text3=findViewById(R.id.edit_text3);
        problems = findViewById(R.id.problems);
        needs = findViewById(R.id.needs);
        add =findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
    }
    private void addData(){

    }
}